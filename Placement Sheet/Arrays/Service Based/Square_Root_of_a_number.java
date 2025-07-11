import java.util.Scanner;

public class Square_Root_of_a_number {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number: ");
        long number = input.nextLong();
        input.close();
        System.out.println("Result: " + sqrtN(number));
    }

    private static int sqrtN(long n) {
        int count = 0;
        int i = 1;
        long currVal = n;
        while (currVal != 0 && i <= currVal) {
            currVal -= i;
            i += 2;
            count++;
        }

        return count;
    }
}
