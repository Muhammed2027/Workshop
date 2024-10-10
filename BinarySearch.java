package Linearsearch;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {

    // Binary search method
    public static int binarySearch(int[] list, int key) {
        int low = 0;
        int high = list.length - 1;

        while (high >= low) {
            int mid = (low + high) / 2;
            if (key < list[mid]) {
                high = mid - 1;
            } else if (key == list[mid]) {
                return mid; // Key found
            } else {
                low = mid + 1;
            }
        }

        return -low - 1; // Key not found
    }

    // Generate a sorted random array
    public static int[] generateSortedArray(int N, int bound) {
        int[] array = new int[N];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            array[i] = random.nextInt(bound);
        }
        Arrays.sort(array); // Sort the array for binary search
        return array;
    }

    // Run best and worst case scenarios
    public static void runTest(int N) {
        int[] list = generateSortedArray(N, 1000);

        // Best Case: The key is the middle element
        int bestKey = list[list.length / 2];
        long startTime = System.nanoTime();
        binarySearch(list, bestKey);
        long endTime = System.nanoTime();
        System.out.println("Best Case for N = " + N + ": " + (endTime - startTime) + " nano sec");

        // Worst Case: The key is not in the list
        int worstKey = -1; // A key that is guaranteed not to be in the array
        startTime = System.nanoTime();
        binarySearch(list, worstKey);
        endTime = System.nanoTime();
        System.out.println("Worst Case for N = " + N + ": " + (endTime - startTime) + " nano sec");
    }

    public static void main(String[] args) {
        // Array sizes to test
        int[] testSizes = {10, 100, 1000, 10000,100000, 1000000, 10000000};

        // Run the test for each array size
        for (int N : testSizes) {
            runTest(N);
            System.out.println();
        }
    }
}