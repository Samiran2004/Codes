package sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuickSort2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();

        List<Integer> arr = new ArrayList<>(size);

        for (int i = 0; i<size; i++) {
            System.out.printf("Enter %d number element of the array: ", i+1);
            arr.add(input.nextInt());
        }

        input.close();
        List<Integer> resultArr = quickSort(arr);

        for (Integer integer : resultArr) {
            System.out.print(integer + " ");
        }
    }

    private static List<Integer> quickSort(List<Integer> arr) {
        int low = 0, high = arr.size() - 1;
        List<Integer> resultArr = new ArrayList<>(arr.size());

        sort(arr, low, high);

        for (int i = 0; i<arr.size(); i++) {
            resultArr.add(i, arr.get(i));
        }

        return resultArr;
    }

    private static void sort(List<Integer> arr, int low, int high) {
        if(low >= high) {
            return;
        }

        int start = low, end = high, mid = start + (end - start) / 2, pivot = arr.get(mid);

        while (start <= end) {

            while (arr.get(start) < pivot) {
                start++;
            }

            while (arr.get(end) > pivot) {
                end--;
            }

            if(start <= end) {
                int temp = arr.get(start);
                arr.set(start, arr.get(end));
                arr.set(end, temp);
                start++;
                end--;
            }
        }

        sort(arr, low, end);
        sort(arr, start, high);
    }
}
