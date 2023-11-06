/*Write a program for analysis of quick sort by using deterministic and randomized variant.*/

import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {12, 4, 5, 6, 7, 3, 1, 15, 2, 8};
        System.out.println("Original Array:");
        printArray(arr);

        System.out.println("\nDeterministic Quick Sort:");
        deterministicQuickSort(arr, 0, arr.length - 1);
        printArray(arr);

        int[] randomizedArr = {12, 4, 5, 6, 7, 3, 1, 15, 2, 8}; // Reset the array
        System.out.println("\nRandomized Quick Sort:");
        randomizedQuickSort(randomizedArr, 0, randomizedArr.length - 1);
        printArray(randomizedArr);
    }

    public static void deterministicQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);

            deterministicQuickSort(arr, low, pivot - 1);
            deterministicQuickSort(arr, pivot + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void randomizedQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = randomizedPartition(arr, low, high);

            randomizedQuickSort(arr, low, pivot - 1);
            randomizedQuickSort(arr, pivot + 1, high);
        }
    }

    public static int randomizedPartition(int[] arr, int low, int high) {
        int randomIndex = new Random().nextInt(high - low + 1) + low;
        int temp = arr[randomIndex];
        arr[randomIndex] = arr[high];
        arr[high] = temp;
        return partition(arr, low, high);
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
