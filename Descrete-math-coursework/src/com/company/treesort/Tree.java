package com.company.treesort;

import java.util.ArrayList;

public class Tree {
    private Tree left;            // левое и правое поддеревья и ключ
    private Tree right;
    private int key;

    public Tree(int k) {        // конструктор с инициализацией ключа
        key = k;
    }

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
        Рассмотреть корневой узел.
        Рекурсивно обойти правое поддерево.
    */
    public void traverse(ArrayList<Integer> sortedArray) {
        if (left != null)
            left.traverse(sortedArray);

        sortedArray.add(key);

        if (right != null)
            right.traverse(sortedArray);
    }

    public ArrayList<Integer> sort(){
        ArrayList<Integer> sortedArray = new ArrayList<>();
        traverse(sortedArray);
        return sortedArray;
    }
}
