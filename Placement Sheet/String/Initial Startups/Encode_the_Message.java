import java.util.Scanner;

public class Encode_the_Message {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the message: ");
        String str = input.next();
        input.close();
        System.out.println(encode(str));
    }

    private static String encode(String message) {
        if (message.length() == 0) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        char[] chars = message.toCharArray();
        int i = 0;
        while (i < chars.length) {
            int count = 1;
            char currElm = chars[i];
            while (i + 1 < chars.length && currElm == chars[i + 1]) {
                count++;
                i++;
            }
            String newStr = currElm + String.valueOf(count);
            builder.append(newStr);
            i++;
        }
        return builder.toString();
    }
}
