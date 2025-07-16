import java.util.Scanner;

public class Is_SubSequence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the 1st string: ");
        String str1 = input.next();
        System.out.print("Enter the 2nd string: ");
        String str2 = input.next();
        input.close();
        System.out.println(isSubsequence(str1, str2));
    }

    private static String isSubsequence(String str1, String str2) {
        if (str1 == null || str1.length() == 0) {
            return "True";
        }
        if (str2 == null || str2.length() == 0) {
            return "False";
        }

        int i = 0;
        int j = 0;

        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
            }
            j++;
        }

        if (i == str1.length()) {
            return "True";
        } else {
            return "False";
        }
    }
}
