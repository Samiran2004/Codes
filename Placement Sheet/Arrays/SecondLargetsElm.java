import java.util.*;

class SecondLargestElm {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 35, 34};
        System.out.println(findSecondLargestElm(arr));
    }
    private static int findSecondLargestElm(int[] arr) {
        // //! Time Complexity: O(nlogn) | Space Complexity: O(1)
        // Arrays.sort(arr);
        // return arr[arr.length - 2];

        //* Better Approach */
        //! Time Complexity: O(n) | Space Complexity: O(1)
        if(arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must have at least two elements.");
        }else {
            int largestElm = Integer.MIN_VALUE;
            int scLargestElm = Integer.MIN_VALUE;
            //* Iterate all elements..
            for(int i = 0; i < arr.length; i++) {
                //* Check if current element is larger than largest element ---> Second largest element is largest element and Largest element is current element...
                if(arr[i] > largestElm) {
                    scLargestElm = largestElm;
                    largestElm = arr[i];
                }else if(arr[i] > scLargestElm && arr[i] != largestElm){ //* If current element is larger than Second Largest element and current element is not equal to largest element...
                    scLargestElm = arr[i];
                }
            }
            //* Return the final result...
            return scLargestElm;
        }
    }
}