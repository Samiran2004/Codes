import java.util.ArrayList;
import java.util.Scanner;

public class Move_Zeroes_To_End {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();
        ArrayList<Integer> arr = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            System.out.printf("Enter the %d number element of the array: ", i + 1);
            arr.add(input.nextInt());
        }
        input.close();
        System.out.println("Before moving zeroes the array is: " + arr);
        // pushZerosAtEnd(arr);
        pushZerosAtEndOptimal(arr);
        System.out.println("After move zeroes the array is: " + arr);
    }

    // ! Time Complexity: O(N)

    // ! Space Complexity: O(N)
    private static void pushZerosAtEnd(ArrayList<Integer> arr) {
        ArrayList<Integer> newArr = new ArrayList<>(arr.size());

        int count = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) != 0) {
                newArr.add(arr.get(i));
                count++;
            }
        }

        while (count != arr.size()) {
            newArr.add(0);
            count++;
        }

        for (int i = 0; i < newArr.size(); i++) {
            arr.set(i, newArr.get(i));
        }
    }

    /*
     * Todo:
     * Try doing it in O(n) time complexity and O(1) space complexity.
     * do it in-place (no O(N) extra space)
     */

    private static void pushZerosAtEndOptimal(ArrayList<Integer> arr) {
        if (arr.isEmpty()) {
            return;
        }

        int pos = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) != 0) {
                arr.set(pos, arr.get(i));
                pos++;
            }
        }

        while (pos != arr.size()) {
            arr.set(pos, 0);
            pos++;
        }
    }
}
