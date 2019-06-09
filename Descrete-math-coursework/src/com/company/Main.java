package com.company;

import com.company.heapsort.Heap;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Введите количество элементов: ");
        Scanner readInput = new Scanner(System.in);
        int size = readInput.nextInt();
        System.out.print("Введите элементы: ");
        ArrayList<Integer> input = new ArrayList<>(size);
        for (int i = 0; i < size; i++){
            input.add(readInput.nextInt());
        }
        Heap heap = new Heap(input);
        ArrayList<Integer> sortedArray = heap.sort();
        for (int i = 0; i < size; i++){
            System.out.print(sortedArray.get(i) + " ");
        }
    }
}
