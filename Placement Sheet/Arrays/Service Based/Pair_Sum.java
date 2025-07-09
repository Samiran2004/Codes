import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Pair_Sum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.printf("Enter %d number element of the array: ", i + 1);
            arr[i] = input.nextInt();
        }
        System.out.print("Enter the target value: ");
        int target = input.nextInt();
        input.close();
        System.out.println("Pair sum: " + pairSum(arr, target));
    }

    private static int pairSum(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                count++;
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        return count == 0 ? -1 : count;
    }
}
