import java.util.Scanner;

public class Square_Root_of_Number {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number to find square root: ");
        int num = input.nextInt();
        input.close();
        System.out.println("Square root of " + num + " is: " + findSquareRoot(num));
    }

    private static int findSquareRoot(int num) {
        int count = 0;
        int currVal = num;
        int i = 1;

        while (currVal != 0 && i <= currVal) {
            currVal = currVal - i;
            i += 2;
            count++;
        }

        return count;
    }
}
