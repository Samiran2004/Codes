package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i<size; i++) {
            System.out.printf("Enter %d number element of the array: ", i+1);
            arr[i] = input.nextInt();
        }
        input.close();
        System.out.println("Original Array: "+ Arrays.toString(arr));
        mergeSortInPlace(arr, 0, size);
        System.out.println("Sorted Array: "+ Arrays.toString(arr));
    }

    private static void mergeSortInPlace(int[] arr, int start, int end) {
        if(end - start <= 1) return;

        int mid = (start + end) / 2;

        mergeSortInPlace(arr, start, mid);
        mergeSortInPlace(arr, mid, end);

        mergeInPlace(arr, start, mid, end);
    }

    private static void mergeInPlace(int[] arr, int start, int mid, int end) {
        int[] mix = new int[end - start];

        int i = start;
        int j = mid;
        int k = 0;

        while (i < mid && j < end) {
            if(arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            }else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i < mid) {
            mix[k] = arr[i];
            i++;
            k++;
        }

        while (j < end) {
            mix[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l<mix.length; l++) {
            arr[start+l] = mix[l];
        }
    }
}
