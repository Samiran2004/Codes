package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
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
        arr = mergeSort(arr);
        System.out.println("Sorted Array: "+ Arrays.toString(arr));
    }

    private static int[] mergeSort(int[] arr) {
        if(arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    private static int[] merge(int[] first, int[] second) {
        int[] newArr = new int[first.length + second.length];

        int i = 0, j = 0, k= 0;

        while (i < first.length && j < second.length) {
            if(first[i] < second[j]) {
                newArr[k] = first[i];
                i++;
            }else {
                newArr[k] = second[j];
                j++;
            }
            k++;
        }

        while (i < first.length) {
            newArr[k] = first[i];
            i++;
            k++;
        }

        while (j < second.length) {
            newArr[k] = second[j];
            j++;
            k++;
        }

        return newArr;
    }
}
