import java.util.Scanner;

public class SumOfLCM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number: ");
        long num = input.nextLong();
        input.close();
        System.out.println(lcmSum(num));
    }

    private static long lcmSum(long n) {
        if (n == 0) {
            return n;
        }

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += lcm(i, (int) n);
        }

        return sum;
    }

    private static int gcd(int u, int v) {
        if (u == 0) {
            return v;
        }
        return gcd(v % u, u);
    }

    private static int lcm(int u, int v) {
        return (u / gcd(u, v)) * v;
    }
}
