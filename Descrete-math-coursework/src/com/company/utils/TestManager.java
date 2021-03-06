package com.company.utils;

import com.company.heapsort.Heap;
import com.company.timsort.Timsort;
import com.company.treesort.Tree;

import java.util.ArrayList;

// Класс для тестирования сортировок
public class TestManager {

    // Генерация массива, состоящего из случайных целочисленных значений
    // из диапазона [-number; number-1]
    public static int[] generateArray(int number) {
        int[] result = new int[number];
        for (int i = 0; i < number; i++){
            result[i] = (int) (2 * number * Math.random() - number);
        }
        return result;
    }

//    public static ArrayList<Integer> generateArrayList(int number) {
//        ArrayList<Integer> result = new ArrayList<>();
//        for (int i = 0; i < number; i++) {
//            result.add((int) (2 * number * Math.random() - number));
//        }
//        return result;
//    }

//    public static void printArrayList(ArrayList<Integer> arrayList) {
//        System.out.println(arrayList);
//    }
//
//    public static void printArray(int[] array) {
//        System.out.println(Arrays.toString(array));
//    }

//    public static void testSortsWithResults(int numberData) {
//        int[] dataArray = generateArray(numberData);
//        ArrayList<Integer> dataArrayList = new ArrayList<>();
//        for (int i = 0; i < dataArray.length; i++) {
//            dataArrayList.add(dataArray[i]);
//        }
//        System.out.print("Исходный массив: ");
//        printArray(dataArray);
//
//        Heap heap = new Heap(dataArrayList);
//        ArrayList<Integer> resultHeap = heap.sort();
//        System.out.print("Пирамидальная сортировка:  ");
//        printArrayList(resultHeap);
//
//        Tree tree = new Tree(dataArray);
//        ArrayList<Integer> resultTree = tree.sort();
//        System.out.print("Сортировка с помощью двоичного дерева: ");
//        printArrayList(resultTree);
//
//        Timsort.timSort(dataArray, dataArray.length);
//        System.out.print("Timsort: ");
//        printArray(dataArray);
//
//        for (int i = 0; i < numberData; i++) {
//            if (!resultHeap.get(i).equals(resultTree.get(i))
//                    || !resultHeap.get(i).equals(dataArray[i])
//                    || !resultTree.get(i).equals(dataArray[i])){
//                throw new RuntimeException("Error in a sort");
//            }
//        }
//    }

//    public static void testSortsWithTime(int numberData) {
//        int[] dataArray = generateArray(numberData);
//        ArrayList<Integer> dataArrayList = new ArrayList<>();
//        for (int i = 0; i < dataArray.length; i++) {
//            dataArrayList.add(dataArray[i]);
//        }
//
//        long begin = System.nanoTime();
//        Heap heap = new Heap(dataArrayList);
//        ArrayList<Integer> resultHeap = heap.sort();
//        System.out.println(String.format("Пирамидальная сортировка: %f с",
//                (System.nanoTime() - begin) / 1000000000f));
//
//        begin = System.nanoTime();
//        Tree tree = new Tree(dataArray);
//        ArrayList<Integer> resultTree = tree.sort();
//        System.out.println(String.format("Сортировка с помощью двоичного дерева: %f с",
//                (System.nanoTime() - begin) / 1000000000f));
//
//        begin = System.nanoTime();
//        Timsort.timSort(dataArray, dataArray.length);
//        System.out.println(String.format("Timsort: %f с",
//                (System.nanoTime() - begin) / 1000000000f));
//
//        for (int i = 0; i < numberData; i++) {
//            if (!resultHeap.get(i).equals(resultTree.get(i))
//                    || !resultHeap.get(i).equals(dataArray[i])
//                    || !resultTree.get(i).equals(dataArray[i])){
//                throw new RuntimeException("Error in a sort");
//            }
//        }
//    }

    // Нахождение среднего времени работы сортировок по количеству результатов repeat
    // для входного массива размером numberData
    public static void testSortsForDiagram(int numberData, int repeat) {
        // Переменные для хранения времени работы сортировок
        double sumHeap = 0 , sumTree = 0, sumTim = 0;

        // Получение repeat результатов времени работы сортировок
        for (int iRepeat = 0; iRepeat < repeat; iRepeat++){
            // Заполнение входного массива случайными значениями
            int[] dataArray = generateArray(numberData);
            ArrayList<Integer> dataArrayList = new ArrayList<>();
            for (int i = 0; i < dataArray.length; i++) {
                dataArrayList.add(dataArray[i]);
            }

            // Вычисление времени работы пирамидальной сортировки
            long begin = System.nanoTime();
            Heap heap = new Heap(dataArrayList);
            ArrayList<Integer> resultHeap = heap.sort();
            sumHeap += System.nanoTime() - begin;

            // Вычисление времени работы сортировки двоичным деревом
            begin = System.nanoTime();
            Tree tree = new Tree(dataArray);
            ArrayList<Integer> resultTree = tree.sort();
            sumTree += System.nanoTime() - begin;

            // Вычисление времени работы сортировки Timsort
            begin = System.nanoTime();
            Timsort.timSort(dataArray, dataArray.length);
            sumTim += System.nanoTime() - begin;
        }

        // Вычисление среднего времени работы каждой сортировки
        sumHeap /= repeat;
        sumTree /= repeat;
        sumTim /= repeat;

        // Вывод среденего времени работы в секундах на экран
        System.out.print(String.format("%d \t",numberData));
        System.out.print(String.format("%f\t", sumHeap / 1000000000));
        System.out.print(String.format("%f\t", sumTree / 1000000000));
        System.out.println(String.format("%f", sumTim / 1000000000));


//        for (int i = 0; i < numberData; i++) {
//            if (!resultHeap.get(i).equals(resultTree.get(i))
//                    || !resultHeap.get(i).equals(dataArray[i])
//                    || !resultTree.get(i).equals(dataArray[i])){
//                throw new RuntimeException("Error in a sort");
//            }
//        }
    }

//    static int[] randomizer(int number) {
//        // Индекс массива
//        int index = 0;
//        // Левая и правая границы, размер
//        int a = 0;
//        int b = 1;
//        int size = 1;
//        // Сортировка
//        int[] result = new int[number];
//        // Генерация рандомного отсортированного участка
//        for(; index < result.length / 2; index++) {
//            result[index] = a + (int) (Math.random() * b);
//            a += size;
//            b += size;
//        }
//        // Генерация рандомного неотсортированного участка
//        for(; index < result.length; index++) {
//            result[index] = a + (int) (Math.random() * b);
//            b -= size;
//            a -= size;
//        }
//
//        return result;
//
//    }
}
