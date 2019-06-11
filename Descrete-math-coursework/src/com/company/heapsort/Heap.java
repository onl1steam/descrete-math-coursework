package com.company.heapsort;

import java.util.ArrayList;
import java.util.Arrays;

// Двоичная куча
public class Heap {
    // Динамический массив для хранения сортируемой последовательности
    private ArrayList<Integer> a = new ArrayList<>();

    // Конструктор, принимающий 0 или более целочисленных значений
    public Heap(Integer... a) {
        this.a = new ArrayList<>(Arrays.asList(a));
        // Сформировать двоичную кучу
        makeHeap();
    }

    // Конструктор, принимающий динамический массив
    public Heap(ArrayList<Integer> a) {
        this.a = (ArrayList<Integer>)a.clone();
        makeHeap();
    }

    // Формирование кучи
    private void makeHeap() {
        if (a.size() == 0) return;
        for (int i = a.size(); i >= 0; i--) {
            siftDown(i);
        }
    }

    // Внутренний ремонт
    private void siftUp(int vertex) {
        if (vertex == 0) return;
        // Вычисление индекса родительской вершины
        int parent = (vertex - 1) / 2;
        // Если значение в текущей вершине меньше значения в родительской,
        // то переставить их местами и выполнить рекурсивный вызов
        if (a.get(vertex) < a.get(parent)) {
            Integer tmp = a.get(parent);
            a.set(parent, a.get(vertex));
            a.set(vertex, tmp);
            siftUp(parent);
        }
    }

    // Наружный ремонт
    private void siftDown(int vertex) {
        // Вычисление индексов дочерних вершин
        int lv = 2 * vertex + 1;
        int rv = 2 * vertex + 2;
        // Проверки на существование дочерних вершин
        if (lv >= a.size()) return;
        if (rv == a.size()) rv = lv;
        // Поиск индекса минимального значения среди значений дочерних вершин
        int mv = a.get(lv) < a.get(rv) ? lv : rv;
        // Если значение в текущей вершине больше минимального среди дочерних вершин,
        // то переставить значения местами и выполнить рекурсивный вызов от дочерней
        // вершины
        if (a.get(mv) < a.get(vertex)) {
            Integer tmp = a.get(vertex);
            a.set(vertex, a.get(mv));
            a.set(mv, tmp);
            siftDown(mv);
        }
    }

    // Добавить новый элемент
    public void add(int value) {
        a.add(value);
        siftUp(a.size() - 1);
    }

    // Забрать верхний элемент
    public Integer pool() {
        // Проверка на пустоту
        if (a.size() == 0) return null;
        // Запомнить значение корня
        Integer res = a.get(0);
        // Записать значение последней вершины в корневую
        // и удалить последнюю вершину
        a.set(0, a.get(a.size() - 1));
        a.remove(a.size() - 1);
        // Воостановить структуру двоичной кучи
        siftDown(0);
        return res;
    }

    // Проверка на пустоту
    public boolean isEmpty() {
        return a.isEmpty();
    }

    // Получить отсортированный массив
    public ArrayList<Integer> sort() {
        ArrayList<Integer> result = new ArrayList<>();
        while (!isEmpty()) {
            result.add(pool());
        }
        return result;
    }

//    @Override
//    public String toString() {
//        String result = "";
//        // Количество вершин на текущем уровне
//        int level = 1;
//        int counter = 0;
//        for (int i = 0; i < a.size(); i += 1) {
//            result += a.get(i);
//            counter += 1;
//            if (counter == level) {
//                result += "\n";
//                counter = 0;
//                level *= 2;
//            } else {
//                result += " ";
//            }
//        }
//        return result;
//    }
}
