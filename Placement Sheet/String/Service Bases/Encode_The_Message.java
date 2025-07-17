import java.util.Scanner;

public class Encode_The_Message {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = input.next();
        input.close();
        System.out.println("Real message: " + str);
        System.out.println("Encoded message: " + encode(str));
    }

    private static String encode(String message) {
        if (message == null || message.isBlank()) {
            return null;
        }

        StringBuilder builder = new StringBuilder();
        char[] strArr = message.toCharArray();

        int i = 0;

        while (i < strArr.length) {
            char currElm = strArr[i];
            int count = 1;
            while (i + 1 < strArr.length && strArr[i + 1] == currElm) {
                count++;
                i++;
            }
            builder.append(currElm + String.valueOf(count));
            i++;
        }

        return builder.toString();
    }
}
