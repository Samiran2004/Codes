import java.util.ArrayList;
import java.util.Scanner;

public class Rotate_Array {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();
        ArrayList<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            System.out.printf("Enter %d number element of the list: ", i + 1);
            list.add(input.nextInt());
        }
        System.out.print("Enter the Kth value: ");
        int k = input.nextInt();
        input.close();
        System.out.println(rotateArray(list, k));
    }

    private static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int k) {
        if (arr.isEmpty() && arr.size() <= k) {
            return null;
        }

        ArrayList<Integer> tempList = new ArrayList<>();
        ArrayList<Integer> resultList = new ArrayList<>();

        int i = 0;
        while (i < k) {
            tempList.add(arr.get(i));
            i++;
        }

        while (i < arr.size()) {
            resultList.add(arr.get(i));
            i++;
        }

        for (int j = 0; j < tempList.size(); j++) {
            resultList.add(tempList.get(j));
        }

        return resultList;
    }
}
