import java.math.BigInteger;
import java.util.Scanner;
import java.util.Stack;

public class Next_Smallest_Palindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = input.next();
        input.close();

        System.out.println(nextLargestPalindromeBruteForce(str, str.length()));
        System.out.println(nextLargestPalindrome(str, str.length()));
    }

    private static String nextLargestPalindromeBruteForce(String number, int length) {

        if (length == 0) {
            return null;
        }

        String result = "";

        for (int i = Integer.parseInt(number) + 1; i > Integer.parseInt(number); i++) {
            if (checkPalindrome(String.valueOf(i))) {
                result = String.valueOf(i);
                break;
            }
        }
        return result;
    }

    private static boolean checkPalindrome(String str) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        char[] strArr = str.toCharArray();

        for (int i = 0; i < strArr.length; i++) {
            stack1.add(strArr[i]);
        }
        for (int i = strArr.length - 1; i >= 0; i--) {
            stack2.add(strArr[i]);
        }

        while (!stack1.isEmpty()) {
            if (stack1.pop() != stack2.pop()) {
                return false;
            }
        }
        return true;
    }

    private static String nextLargestPalindrome(String number, int length) {
        if (length == 0) {
            return null;
        }

        BigInteger start = new BigInteger(number).add(BigInteger.ONE);

        while (true) {
            String result = start.toString();

            if (checkIsPalindrome(result)) {
                return result;
            }

            start = start.add(BigInteger.ONE);
        }
    }

    private static boolean checkIsPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }
}
