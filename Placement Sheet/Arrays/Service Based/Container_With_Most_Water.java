import java.util.Scanner;

public class Container_With_Most_Water {
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
        System.out.println("Max area: " + maxAreaBruteForce(arr));
        System.out.println("Max area: "+ maxArea(arr));
    }

    /*
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    private static int maxAreaBruteForce(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int maxArea = 0;
        int currArea = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                currArea = Integer.min(arr[i], arr[j]) * (j - i);
                maxArea = Integer.max(currArea, maxArea);
            }
        }

        return maxArea;
    }

    /*
     * Optimal approach
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    private static int maxArea(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int maxArea = 0;
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int currArea = Integer.min(arr[left], arr[right]) * (right - left);
            maxArea = Integer.max(maxArea, currArea);

            if(arr[left] < arr[right]) {
                left++;
            }else{
                right--;
            }
        }

        return maxArea;
    }
}
