import java.util.Arrays;
import java.util.Scanner;

public class StringSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = input.next();
        System.out.println("Unsorted string: " + str);
        System.out.println("Sorted string: " + sortString(str));
        input.close();
    }

    private static String sortString(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char[] charArr = str.toCharArray();

        Arrays.sort(charArr);

        return new String(charArr);
    }
}