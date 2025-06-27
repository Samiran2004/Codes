import java.util.HashMap;
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
        System.out.println("Pair sum: " + pairSumBruteForce(arr, size, target));
        System.out.println("Pair sum: " + pairSum(arr, size, target));
    }

    // Brute-Force
    private static int pairSumBruteForce(int[] arr, int n, int target) {
        if (n == 1) {
            return -1;
        }
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    count++;
                }
            }
        }
        return count == 0 ? -1 : count;
    }

    // Optimal using hashing
    private static int pairSum(int[] arr, int n, int target) {

        if (n == 0) {
            return -1;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int count = 0;
        for (int i = 0; i < n; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                count += map.get(complement);
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        return count == 0 ? -1 : count;
    }
}
