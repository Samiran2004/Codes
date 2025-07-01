import java.util.Scanner;

public class String_Is_A_Palindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = input.nextLine();
        input.close();
        System.out.println(checkPalindrome(str));
    }

    private static boolean checkPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char currElm = str.charAt(i);
            if (Character.isLetterOrDigit(currElm)) {
                builder.append(Character.toLowerCase(currElm));
            }
        }

        String cleanStr = builder.toString();
        int left = 0;
        int right = cleanStr.length() - 1;
        while (left < right) {
            if (cleanStr.charAt(left) != cleanStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}