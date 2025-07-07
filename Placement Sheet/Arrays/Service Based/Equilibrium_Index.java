import java.util.Scanner;

public class Equilibrium_Index {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.printf("Enter %d number element of the array: ", i + 1);
            arr[i] = input.nextInt();
        }
        input.close();
        System.out.println(arrayEquilibriumIndex(arr));
    }

    private static int arrayEquilibriumIndex(int[] arr) {
        if (arr.length == 0) {
            return -1;
        }

        int arraySum = 0, leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            arraySum += arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            int rightSum = arraySum - leftSum - arr[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum = leftSum + arr[i];
        }
        return -1;
    }
}
