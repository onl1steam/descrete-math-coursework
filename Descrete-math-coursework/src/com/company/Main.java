package com.company;

import com.company.utils.TestManager;

public class Main {

    // Driver code
    public static void main(String[] args) {
        System.out.println("Heapsort\tTreesort\tTimsort");
        for (int i = 0; i <= 10; i++ ) {
            TestManager.testSortsForDiagram(10);
//            if (i < 100000) {
//                i *= 10;
//            } else {
//                i += 100000;
//            }
        }
    }
}