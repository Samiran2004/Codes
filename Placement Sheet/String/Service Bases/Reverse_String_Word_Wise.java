/*
 * Sample Input 1:
 * Welcome to Coding Ninjas
 * Sample Output 1:
 * Ninjas Coding to Welcome
 * Sample Input 2:
 * Always indent your code
 * Sample Output 2:
 * code your indent Always
 */

import java.util.Scanner;

public class Reverse_String_Word_Wise {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str = input.nextLine();
        input.close();

        System.out.println("Original String: " + str);
        System.out.println("Reverse String: " + reverseStringWordWise(str));
    }

    private static String reverseStringWordWise(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }

        StringBuilder builder = new StringBuilder();
        String[] splitArr = input.split(" ");
        for (int i = splitArr.length - 1; i >= 0; i--) {
            builder.append(splitArr[i]);
            if (i != 0) {
                builder.append(" ");
            }
        }

        return builder.toString();
    }
}
