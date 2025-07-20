package searching;

import java.util.ArrayList;
import java.util.Scanner;

public class FindKthElement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the 1st array: ");
        int size1 = input.nextInt();
        ArrayList<Integer> arr1 = new ArrayList<>(size1);
        for(int i = 0; i<size1; i++) {
            System.out.printf("Enter %d number element of the 1st array: ", i+1);
            arr1.add(input.nextInt());
        }

        System.out.print("Enter the size of the 2nd array: ");
        int size2 = input.nextInt();
        ArrayList<Integer> arr2 = new ArrayList<>(size2);
        for(int i = 0; i < size2; i++) {
            System.out.printf("Enter %d number element of the 2nd array: ", i+1);
            arr2.add(input.nextInt());
        }

        System.out.print("Enter the value of K: ");
        int k = input.nextInt();
        System.out.println("Kth element is: "+ findKthElement(arr1, arr2, k));
    }

    private static int findKthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int k) {
        int m = arr1.size();
        int n = arr2.size();

        if(m > n) {
            return findKthElement(arr2, arr1, k);
        }

        int low = Math.max(0, k-1);
        int high = Math.min(k, m);

        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = k - cut1;

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : arr1.get(cut1 - 1);
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : arr2.get(cut2 - 1);
            int r1 = (cut1 == m) ? Integer.MAX_VALUE : arr1.get(cut1);
            int r2 = (cut2 == n) ? Integer.MAX_VALUE : arr2.get(cut2);

            if(l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = cut1 - 1;
            }else {
                low = cut1 + 1;
            }
        }

        return -1;
    }
}
