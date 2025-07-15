import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Longest_Subarray_Zero_Sum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();
        ArrayList<Integer> arr = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            System.out.printf("Enter %d number element of the array: ", i + 1);
            arr.add(input.nextInt());
        }
        input.close();
        System.out.println("Result: " + LongestSubsetWithZeroSumBruteForce(arr));
        System.out.println("Result: "+ LongestSubsetWithZeroSum(arr));
    }

    /*
     * Bruteforce method
     * Time Complexity: O(n^2)
     */
    private static int LongestSubsetWithZeroSumBruteForce(ArrayList<Integer> arr) {
        if (arr.size() == 0) {
            return 0;
        }

        int maxCount = 0;
        for (int i = 0; i < arr.size() - 1; i++) {
            int currCount = 1;
            int sum = arr.get(i);
            for (int j = i + 1; j < arr.size(); j++) {
                sum += arr.get(j);
                currCount++;
                if (sum == 0 && currCount > maxCount) {
                    maxCount = currCount;
                }
            }
        }

        return maxCount;
    }

    /*
     * Optimal Approach
     */
    private static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {
        if(arr.size() == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int sum = 0;

        for(int i = 0; i<arr.size(); i++) {
            sum += arr.get(i);

            if(sum == 0) {
                maxLen = i + 1;
            }

            if(map.containsKey(sum)) {
                int prevIdx = map.get(sum);
                maxLen = Math.max(maxLen, i - prevIdx);
            }else {
                map.put(sum, i);
            }
        }

        return maxLen;
    }

}
