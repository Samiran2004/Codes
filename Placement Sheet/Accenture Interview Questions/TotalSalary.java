import java.util.Scanner;

public class TotalSalary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter basic salary: ");
        int basicSalary = input.nextInt();
        System.out.print("Enter grade: ");
        char grade = input.next().charAt(0);
        input.close();

        System.out.println("Total salary: " + calculateTotalSalary(basicSalary, grade));
    }

    private static int calculateTotalSalary(int basic, char grade) {
        if (basic == 0) {
            return 0;
        }

        int allowance = 0;

        if (grade == 'A' || Character.toUpperCase(grade) == 'A') {
            allowance = 1700;
        } else if (grade == 'B' || Character.toUpperCase(grade) == 'B') {
            allowance = 1500;
        } else {
            allowance = 1300;
        }

        double hra = basic * 0.20;
        double da = basic * 0.50;
        double pf = basic * 0.11;

        int totalSalary = (int) Math.round(basic + hra + da + allowance - pf);
        return totalSalary;
    }
}
