package com.company.heapsort;

import java.util.ArrayList;
import java.util.Arrays;

public class Heap {
    private ArrayList<Integer> a = new ArrayList<>();

    public Heap(Integer... a) {
        this.a = new ArrayList<>(Arrays.asList(a));
        makeHeap();
    }

    public Heap(ArrayList<Integer> a) {
        this.a = (ArrayList<Integer>)a.clone();
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
        if (a.get(vertex) < a.get(parent)) {
            Integer tmp = a.get(parent);
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
        int mv = a.get(lv) < a.get(rv) ? lv : rv;
        if (a.get(mv) < a.get(vertex)) {
            Integer tmp = a.get(vertex);
            a.set(vertex, a.get(mv));
            a.set(mv, tmp);
            siftDown(mv);
        }
    }

    // Добавить элемент
    public void add(int value) {
        a.add(value);
        siftUp(a.size() - 1);
    }

    // Забрать верхний элемент
    public Integer pool() {
        if (a.size() == 0) return null;
        Integer res = a.get(0);
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
    public ArrayList<Integer> sort() {
        ArrayList<Integer> result = new ArrayList<>();
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
