import java.util.Scanner;

public class Reverse_String_Word_Wise {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = input.nextLine();
        input.close();
        System.out.println("Original string: " + str);
        System.out.println("Reverse string: " + reverseStringWordWise(str));
    }

    private static String reverseStringWordWise(String str) {
        if (str.length() == 0) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        String[] words = str.split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            builder.append(words[i]);
            if (i != 0) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }
}
