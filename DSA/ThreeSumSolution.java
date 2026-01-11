import java.util.*;

public class ThreeSumSolution {

    // Brute-force 3Sum with target
    public static List<List<Integer>> threeSumBruteForce(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == target) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(temp); // sort triplet to avoid duplicates
                        set.add(temp); // HashSet removes duplicates
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }

    // Optimized 3Sum (target fixed as 0, like LeetCode 15)
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];

                if (total == 0) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[left], nums[right]);
                    res.add(triplet); // Set ensures uniqueness

                    // Skip duplicates for left
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicates for right
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (total < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter data: ");
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the value of target: ");
        int target = sc.nextInt();

        List<List<Integer>> bruteForceResult = threeSumBruteForce(arr, target);
        List<List<Integer>> optimizedResult = threeSum(arr);

        System.out.println("Brute force result (target = " + target + "): " + bruteForceResult);
        System.out.println("Optimized 3Sum result (target = 0): " + optimizedResult);

        sc.close();
    }
}
