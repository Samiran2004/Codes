import java.util.Arrays;
import java.util.Scanner;

public class BlockHeights {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter the data: ");
            arr[i] = input.nextInt();
        }
        input.close();
        System.out.println(getNumberOfBlocks(arr));
    }

    private static int getNumberOfBlocks(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int[] compareArr = Arrays.copyOf(arr, arr.length);

        Arrays.sort(compareArr);

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (compareArr[i] != arr[i]) {
                count++;
            }
        }

        return count;

    }
}
