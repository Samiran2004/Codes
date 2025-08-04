package Valid_Parentheses;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the braces: ");
        String braces = input.next();
        input.close();

        System.out.println("The braces: " + braces);
        System.out.println("Is ValidParenthesis: " + isValidParenthesis(braces));
    }

    public static boolean isValidParenthesis(String str) {
        if (str.length() == 0 || str == null) {
            return false;
        }

        char[] charArr = str.toCharArray();
        Stack stack = new Stack(charArr.length);

        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == '(' || charArr[i] == '{' || charArr[i] == '[') {
                stack.push(charArr[i]);
            }
            if ((charArr[i] == ')' && stack.peek() == '(') || (charArr[i] == '}' && stack.peek() == '{')
                    || (charArr[i] == ']' && stack.peek() == '[')) {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}