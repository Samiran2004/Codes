import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Majority_Element {
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
        System.out.println("Majority Element: " + findMajority(arr, size));
        System.out.println("Majority Element: "+ findMajorityVotingAlgo(arr, size));
    }

    /*
     * Time Complexity: O(n log n)
     * Better approach
     */
    private static int findMajority(int[] arr, int n) {
        if (arr == null || n == 0) {
            return -1;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int floorOcTime = (int) Math.floor(n / 2);

        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int mejorElm = -1;
        int mejorVal = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > mejorVal) {
                mejorElm = entry.getKey();
                mejorVal = entry.getValue();
            }
        }

        if (mejorVal > floorOcTime) {
            return mejorElm;
        } else {
            return -1;
        }
    }

    /*
     * Optimal Approach
     * Using: Moore’s Voting Algorithm
     */

    private static int findMajorityVotingAlgo(int[] arr, int n) {
        if (arr == null || n == 0) {
            return -1;
        }

        int count = 0;
        int elm = 0;
        int floorOcTime = (int) Math.floor(n / 2);

        for (int i = 0; i < n; i++) {
            if (count == 0) {
                count = 1;
                elm = arr[i];
            } else if (arr[i] == elm) {
                count++;
            } else {
                count--;
            }
        }

        int count1 = 0;
        for(int i = 0; i<n; i++) {
            if(arr[i] == elm) {
                count1++;
            }
        }

        if(count1 > floorOcTime) {
            return elm;
        }
        return -1;
    }
}
