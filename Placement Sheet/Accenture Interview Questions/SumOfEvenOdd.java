import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SumOfEvenOdd {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number: ");
        long num = input.nextLong();

        System.out.println(Arrays.toString(sumOfEvenOdd(num)));

        input.close();
    }

    private static int[] sumOfEvenOdd(long num) {
        if (num == 0) {
            return new int[] { 0, 0 };
        }

        int[] arr = new int[2];

        ArrayList<Integer> oddArr = new ArrayList<>();
        ArrayList<Integer> evenArr = new ArrayList<>();

        int tempNum = (int) num;

        while (tempNum > 0) {
            int digit = tempNum % 10;

            if (digit % 2 == 0) {
                evenArr.add(digit);
            } else {
                oddArr.add(digit);
            }

            tempNum = tempNum / 10;
        }

        // Calculate sum for even array...
        int evenSum = 0;
        for (int i = 0; i < evenArr.size(); i++) {
            evenSum += evenArr.get(i);
        }

        // Calculate sum for odd arr...
        int oddSum = 0;
        for (int i = 0; i < oddArr.size(); i++) {
            oddSum += oddArr.get(i);
        }

        arr[0] = evenSum;
        arr[1] = oddSum;

        return arr;
    }
}