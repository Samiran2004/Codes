import java.util.Stack;

public class ParenthesisChecker {

    private static boolean isMatchingPair(char open, char close) {
        return ((open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']'));
    }

    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char ch : expression.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (stack.isEmpty() || !isMatchingPair(stack.pop(), ch)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String expression = "[{({[]})}]";
        boolean isBalanced = isBalanced(expression);
        if (isBalanced) {
            System.out.println("Expression is balanced...");
        } else {
            System.out.println("Expression is not balanced...");
        }
    }
}