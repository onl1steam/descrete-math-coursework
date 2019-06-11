package com.company.timsort;

// Класс для сортировки методом Timsort
public class Timsort {
    static int RUN = 32;

    // Сортировка вставками для массива arr
    // от индекса left до индекса right
    public static void insertionSort(int[] arr, int left, int right)
    {
        for (int i = left + 1; i <= right; i++)
        {
            int temp = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > temp)
            {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    // Функция для объединения сортировкой слиянием двух
    // отсортированных подмассивов
    public static void merge(int[] arr, int l,
                             int m, int r)
    {
        // Разделить участок начального массива на два подмассива
        // и создать временные массивы со скопированными значениями
        int len1 = m - l + 1, len2 = r - m;
        int[] left = new int[len1];
        int[] right = new int[len2];
        for (int x = 0; x < len1; x++)
        {
            left[x] = arr[l + x];
        }
        for (int x = 0; x < len2; x++)
        {
            right[x] = arr[m + 1 + x];
        }

        int i = 0;
        int j = 0;
        int k = l;

        // Записываем в исходный массив значения по возрастанию
        // из временных массивов
        while (i < len1 && j < len2)
        {
            if (left[i] <= right[j])
            {
                arr[k] = left[i];
                i++;
            }
            else
            {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // Если в левом подмассиве остались элементы, копируем их
        while (i < len1)
        {
            arr[k] = left[i];
            k++;
            i++;
        }

        // Если в правом подмассиве остались элементы, копируем их
        while (j < len2)
        {
            arr[k] = right[j];
            k++;
            j++;
        }
    }

    // Сортировка Timsort
    public static void timSort(int[] arr, int n)
    {

        // Отсортировать подмассивы размером RUN сортировкой вставками
        for (int i = 0; i < n; i += RUN)
        {
            insertionSort(arr, i, Math.min((i + 31), (n - 1)));
        }

        // Объединить подмассивы, начиная с размера 32
        // После каждой итерации размер объединяемых подмассивов
        // увеличивается в 2 раза
        for (int size = RUN; size < n; size = 2 * size)
        {
            // Поиск левой границы левого подмассива
            // Объединяем подмассивы arr[left..left+size-1] и
            // arr[left+size, left+2*size-1]
            // После каждого объединения увеличиваем left на 2*size
            for (int left = 0; left < n; left += 2 * size)
            {

                // Поиск правой границы левого подмассива
                // mid+1 - начало правого подмассива
                int mid = Math.min(left + size - 1, n-1);
                int right = Math.min((left + 2 * size - 1), (n - 1));

                // Объединить подмассивы arr[left.....mid] и
                // arr[mid+1....right]
                merge(arr, left, mid, right);
            }
        }
    }
}
