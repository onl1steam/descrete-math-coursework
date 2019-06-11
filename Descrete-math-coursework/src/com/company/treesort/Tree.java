package com.company.treesort;

import java.util.ArrayList;

// Двоичное дерево поиска
public class Tree {
    // Левое поддерево
    private Tree left;
    // Правое поддерево
    private Tree right;
    // Ключ
    private int key;

    // Конструктор с инициализацией ключа
    public Tree(int k) {
        key = k;
    }

    // Конструктор, принимающий целочисленный массив
    public Tree(int[] data) {
        key = data[0];
        for (int i = 1; i < data.length; i++){
            this.insert(new Tree(data[i]));
        }
    }

    /*  insert (добавление нового поддерева (ключа))
        сравнить ключ добавляемого поддерева (К) с ключом корневого узла (X).
        Если K>=X, рекурсивно добавить новое дерево в правое поддерево.
        Если K<X, рекурсивно добавить новое дерево в левое поддерево.
        Если поддерева нет, то вставить на это место новое дерево
    */
    public void insert(Tree aTree) {
        if (aTree.key < key)
            if (left != null) left.insert(aTree);
            else left = aTree;
        else if (right != null) right.insert(aTree);
        else right = aTree;
    }

    /*  traverse (обход)
        Рекурсивно обойти левое поддерево.
        Добавить в динамический массив ключ корневого узла
        Рекурсивно обойти правое поддерево.
    */
    public void traverse(ArrayList<Integer> sortedArray) {
        if (left != null)
            left.traverse(sortedArray);

        sortedArray.add(key);

        if (right != null)
            right.traverse(sortedArray);
    }

    // Получить отсортированный массив
    public ArrayList<Integer> sort(){
        ArrayList<Integer> sortedArray = new ArrayList<>();
        traverse(sortedArray);
        return sortedArray;
    }
}
