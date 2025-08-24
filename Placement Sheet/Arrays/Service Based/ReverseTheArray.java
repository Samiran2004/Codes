import java.util.Scanner;

public class ReverseTheArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();
        int[] arr = new int[size];

        for(int i = 0; i<size; i++) {
            System.out.print("Enter the element of the array: ");
            arr[i] = input.nextInt();
        }

        System.out.print("Enter the position: ");
        int ps = input.nextInt();
        input.close();
        System.out.println("..........Original Array.........");
        printArray(arr);
        reverseTheArray(arr, ps);
        System.out.println("..........Reversed Array..........");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int i: arr) {
            System.out.print(i+" ");
        }
    }

    private static void reverseTheArray(int[]  arr, int m) {
        if (arr == null || arr.length == 0 || arr.length <= m) {
            return;
        }
        int start = m;
        int end = arr.length - 1;
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}