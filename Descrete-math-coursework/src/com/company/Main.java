package com.company;

import com.company.utils.TestManager;

public class Main {

    public static void main(String[] args) {
        System.out.println("data\tHeapsort,с\tTreesort,с\tTimsort,с");
        // Протестировать сортировки на входных массивах размера data
        // Для каждого размера входных данных повторять сортировку 1000 раз
        for (int data = 500; data <= 10000; data += 500 ) {
                TestManager.testSortsForDiagram(data, 1000);
        }
    }
}