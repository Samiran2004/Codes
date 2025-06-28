import java.util.Scanner;

public class Minimum_Parentheses {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the pattern: ");
        String pattern = input.next();
        input.close();
        System.out.println(minimumParentheses(pattern));
    }

    private static int minimumParentheses(String str) {
        int count = 0;
        int openBar = 0;
        char[] charArr = str.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == '(') {
                openBar++;
            } else if (charArr[i] == ')') {
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
