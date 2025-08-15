import java.util.Scanner;

public class DimondOfStars {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of stars: ");
        int num = input.nextInt();
        input.close();
        printStar(num);
    }

    private static void printStar(int num) {
        if (num == 0) {
            return;
        }

        for (int i = 0; i <= num / 2; i++) {

            for (int j = num / 2; j >= i + 1; j--)

                System.out.print(" ");

            for (int k = 0; k <= i * 2; k++)

                System.out.print("*");

            System.out.println();

        }

        for (int i = (num / 2) - 1; i >= 0; i--) {

            for (int j = num / 2; j >= i + 1; j--)

                System.out.print(" ");

            for (int k = 0; k <= i * 2; k++)

                System.out.print("*");

            System.out.println();

        }
    }
}