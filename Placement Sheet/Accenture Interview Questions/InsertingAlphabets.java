import java.util.ArrayList;
import java.util.Scanner;

public class InsertingAlphabets {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = input.nextInt();
        input.close();

        ArrayList<ArrayList<Character>> result = interestingPattern(num);

        if (result != null) {
            for (ArrayList<Character> row : result) {
                for (Character ch : row) {
                    System.out.print(ch);
                }
                System.out.println();
            }
        }
    }

    private static ArrayList<ArrayList<Character>> interestingPattern(int num) {
        if (num <= 0 || num > 26) {
            return null;
        }

        ArrayList<ArrayList<Character>> resultList = new ArrayList<>();

        for (int i = 1; i <= num; i++) {
            ArrayList<Character> tempArr = new ArrayList<>();

            int startPos = num - i;

            for (int j = 0; j < i; j++) {
                char currentChar = (char) ('A' + startPos + j);
                tempArr.add(currentChar);
            }

            resultList.add(tempArr);
        }

        return resultList;
    }
}
