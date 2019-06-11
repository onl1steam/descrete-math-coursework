package com.company;

import com.company.utils.TestManager;

public class Main {

    // Driver code
    public static void main(String[] args) {
        System.out.println("data\tHeapsort\tTreesort\tTimsort");
        for (int data = 500; data <= 10000; data += 500 ) {
                TestManager.testSortsForDiagram(data, 10000);
        }
    }
}