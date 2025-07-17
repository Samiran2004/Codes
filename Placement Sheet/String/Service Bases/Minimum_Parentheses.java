import java.util.Scanner;

public class Minimum_Parentheses {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the parentheses: ");
        String str = input.next();
        input.close();
        System.out.println("Minimum number of parentheses required: " + minimumParentheses(str));
    }

    private static int minimumParentheses(String str) {
        if (str == null || str.isBlank()) {
            return -1;
        }

        int openBar = 0, count = 0;
        char[] strArr = str.toCharArray();

        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] == '(') {
                openBar++;
            } else if (strArr[i] == ')') {
                if (openBar > 0) {
                    openBar--;
                } else {
                    count++;
                }
            }
        }

        count += openBar;

        return count;
    }
}
