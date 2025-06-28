import java.util.Scanner;

public class Beautiful_String {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = input.next();
        input.close();
        System.out.println(makeBeautiful(str));
    }

    private static String generateChoice(String str, boolean isZero) {
        int n = str.length();
        String ans = "";
        if (n == 0)
            return ans;
        if (isZero) {
            ans += "0";
        } else {
            ans += "1";
        }

        while (n > 0) {
            if (ans.endsWith("1")) {
                ans += "0";
            } else {
                ans += "1";
            }
            n--;
        }
        return ans;
    }

    private static int getDiff(String str, String s) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != s.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    private static int makeBeautiful(String str) {
        String g1 = generateChoice(str, false);
        int diff1 = getDiff(str, g1);

        String g2 = generateChoice(str, true);
        int diff2 = getDiff(str, g2);

        return Integer.min(diff1, diff2);
    }
}
