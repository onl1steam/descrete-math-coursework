package com.company.utils;

import com.company.heapsort.Heap;
import com.company.timsort.Timsort;
import com.company.treesort.Tree;

import java.util.ArrayList;
import java.util.Arrays;

public class TestManager {
    // [-number; number-1]
    public static int[] generateArray(int number) {
        int[] result;
        result = randomizer(number);
        return result;
    }

    public static ArrayList<Integer> generateArrayList(int number) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            result.add((int) (2 * number * Math.random() - number));
        }
        return result;
    }

    public static void printArrayList(ArrayList<Integer> arrayList) {
        System.out.println(arrayList);
    }

    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void testSortsWithResults(int numberData) {
        int[] dataArray = generateArray(numberData);
        ArrayList<Integer> dataArrayList = new ArrayList<>();
        for (int i = 0; i < dataArray.length; i++) {
            dataArrayList.add(dataArray[i]);
        }
        System.out.print("Исходный массив: ");
        printArray(dataArray);

        Heap heap = new Heap(dataArrayList);
        ArrayList<Integer> resultHeap = heap.sort();
        System.out.print("Пирамидальная сортировка:  ");
        printArrayList(resultHeap);

        Tree tree = new Tree(dataArray);
        ArrayList<Integer> resultTree = tree.sort();
        System.out.print("Сортировка с помощью двоичного дерева: ");
        printArrayList(resultTree);

        Timsort.timSort(dataArray, dataArray.length);
        System.out.print("Timsort: ");
        printArray(dataArray);

        for (int i = 0; i < numberData; i++) {
            if (!resultHeap.get(i).equals(resultTree.get(i))
                    || !resultHeap.get(i).equals(dataArray[i])
                    || !resultTree.get(i).equals(dataArray[i])){
                throw new RuntimeException("Error in a sort");
            }
        }
    }

    public static void testSortsWithTime(int numberData) {
        int[] dataArray = generateArray(numberData);
        ArrayList<Integer> dataArrayList = new ArrayList<>();
        for (int i = 0; i < dataArray.length; i++) {
            dataArrayList.add(dataArray[i]);
        }

        long begin = System.nanoTime();
        Heap heap = new Heap(dataArrayList);
        ArrayList<Integer> resultHeap = heap.sort();
        System.out.println(String.format("Пирамидальная сортировка: %f с",
                (System.nanoTime() - begin) / 1000000000f));

        begin = System.nanoTime();
        Tree tree = new Tree(dataArray);
        ArrayList<Integer> resultTree = tree.sort();
        System.out.println(String.format("Сортировка с помощью двоичного дерева: %f с",
                (System.nanoTime() - begin) / 1000000000f));

        begin = System.nanoTime();
        Timsort.timSort(dataArray, dataArray.length);
        System.out.println(String.format("Timsort: %f с",
                (System.nanoTime() - begin) / 1000000000f));

        for (int i = 0; i < numberData; i++) {
            if (!resultHeap.get(i).equals(resultTree.get(i))
                    || !resultHeap.get(i).equals(dataArray[i])
                    || !resultTree.get(i).equals(dataArray[i])){
                throw new RuntimeException("Error in a sort");
            }
        }
    }

    public static void testSortsForDiagram(int numberData) {
        int[] dataArray = generateArray(numberData);
        ArrayList<Integer> dataArrayList = new ArrayList<>();
        for (int i = 0; i < dataArray.length; i++) {
            dataArrayList.add(dataArray[i]);
            System.out.print(dataArray[i] + " ");
        }
        System.out.println();


//
//        long begin = System.nanoTime();
//        Heap heap = new Heap(dataArrayList);
//        ArrayList<Integer> resultHeap = heap.sort();
//        System.out.print(String.format("%d\t",
//                (System.nanoTime() - begin)));
//
//        begin = System.nanoTime();
//        Tree tree = new Tree(dataArray);
//        ArrayList<Integer> resultTree = tree.sort();
//        System.out.print(String.format("%d\t",
//                (System.nanoTime() - begin)));
//
//        begin = System.nanoTime();
//        Timsort.timSort(dataArray, dataArray.length);
//        System.out.println(String.format("%d",
//                (System.nanoTime() - begin)));
//
//        for (int i = 0; i < numberData; i++) {
//            if (!resultHeap.get(i).equals(resultTree.get(i))
//                    || !resultHeap.get(i).equals(dataArray[i])
//                    || !resultTree.get(i).equals(dataArray[i])){
//                throw new RuntimeException("Error in a sort");
//            }
//        }
    }

    static int[] randomizer(int number) {
        // Индекс массива
        int index = 0;
        // Левая и правая границы, размер
        int a = 0;
        int b = 1;
        int size = 1;
        // Сортировка
        int[] result = new int[number];
        // Генерация рандомного отсортированного участка
        for(; index < result.length / 2; index++) {
            result[index] = a + (int) (Math.random() * b);
            a += size;
            b += size;
        }
        // Генерация рандомного неотсортированного участка
        for(; index < result.length; index++) {
            result[index] = a + (int) (Math.random() * b);
            b -= size;
            a -= size;
        }

        return result;

    }
}
