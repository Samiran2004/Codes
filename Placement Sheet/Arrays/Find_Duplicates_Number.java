import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Find_Duplicates_Number {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.printf("Enter %d number element of the array: ", i + 1);
            arr[i] = input.nextInt();
        }
        // System.out.println("Duplicate number: " + findDuplicateNumberBruteForce(arr));
        System.out.println(findDuplicateNumber(arr));
        input.close();
    }

    // Brute Force
    private static int findDuplicateNumberBruteForce(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int currNum = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (currNum == arr[j]) {
                    return currNum;
                }
            }
        }
        return -1;
    }

    // Final
    private static int findDuplicateNumber(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if(map.get(arr[i]) > 1) {
                return arr[i];
            }
        }
        return -1;
    }
}
