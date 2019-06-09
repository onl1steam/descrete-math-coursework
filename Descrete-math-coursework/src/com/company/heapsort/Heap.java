package com.company.heapsort;

import java.util.ArrayList;
import java.util.Arrays;

public class Heap<T extends Comparable<T>> {
    private ArrayList<T> a = new ArrayList<>();

    public Heap(T... a) {
        this.a = new ArrayList<>(Arrays.asList(a));
        makeHeap();
    }

    public Heap(ArrayList<T> a) {
        this.a = (ArrayList<T>) a.clone();
        makeHeap();
    }

    // Окучивание
    private void makeHeap() {
        if (a.size() == 0) return;
        for (int i = a.size(); i >= 0; i--) {
            siftDown(i);
        }
    }

    // Внутренний ремонт
    private void siftUp(int vertex) {
        if (vertex == 0) return;
        int parent = (vertex - 1) / 2;
        if (a.get(vertex).compareTo(a.get(parent)) < 0) {
            T tmp = a.get(parent);
            a.set(parent, a.get(vertex));
            a.set(vertex, tmp);
            siftUp(parent);
        }
    }

    // Наружный ремонт
    private void siftDown(int vertex) {
        int lv = 2 * vertex + 1;
        int rv = 2 * vertex + 2;
        if (lv >= a.size()) return;
        if (rv == a.size()) rv = lv;
        int mv = a.get(lv).compareTo(a.get(rv)) < 0 ? lv : rv;
        if (a.get(mv).compareTo(a.get(vertex)) < 0) {
            T tmp = a.get(vertex);
            a.set(vertex, a.get(mv));
            a.set(mv, tmp);
            siftDown(mv);
        }
    }

    // Добавить элемент
    public void add(T value) {
        a.add(value);
        siftUp(a.size() - 1);
    }

    // Забрать верхний элемент
    public T pool() {
        if (a.size() == 0) return null;
        T res = a.get(0);
        a.set(0, a.get(a.size() - 1));
        a.remove(a.size() - 1);
        siftDown(0);
        return res;
    }

    // Проверка на пустоту
    public boolean isEmpty() {
        return a.isEmpty();
    }

    // Получить отсортированный массив
    public ArrayList<T> sort() {
        ArrayList<T> result = new ArrayList<>();
        while (!isEmpty()) {
            result.add(pool());
        }
        return result;
    }

    @Override
    public String toString() {
        String result = "";
        // Количество вершин на текущем уровне
        int level = 1;
        int counter = 0;
        for (int i = 0; i < a.size(); i += 1) {
            result += a.get(i);
            counter += 1;
            if (counter == level) {
                result += "\n";
                counter = 0;
                level *= 2;
            } else {
                result += " ";
            }
        }
        return result;
    }
}
