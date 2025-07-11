import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Intersection_Of_Two_Sorted_Arrays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the size of the first array: ");
        int size = input.nextInt();
        ArrayList<Integer> arr1 = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            System.out.printf("Enter %d number element of the 1st array: ", i + 1);
            arr1.add(input.nextInt());
        }

        System.out.print("Enter the size of the 2nd array: ");
        size = input.nextInt();
        ArrayList<Integer> arr2 = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            System.out.printf("Enter %d number element of the 2nd array: ", i + 1);
            arr2.add(input.nextInt());
        }
        input.close();

        System.out.println("First array: "+ arr1);
        System.out.println("2nd array: "+ arr2);
        System.out.println("Result array: " + findArrayIntersection(arr1, arr2));
    }

    private static ArrayList<Integer> findArrayIntersection(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {

        ArrayList<Integer> resultArr = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        if (arr1.size() <= 0 || arr2.size() <= 0) {
            return resultArr;
        }

        for (int i = 0; i < arr2.size(); i++) {
            map.put(arr2.get(i), map.getOrDefault(arr2.get(i), 0) + 1);
        }

        for (int i = 0; i < arr1.size(); i++) {
            int currVal = arr1.get(i);

            if (map.getOrDefault(currVal, 0) > 0) {
                resultArr.add(currVal);
                map.replace(currVal, map.get(currVal) - 1);
            }
        }

        return resultArr;
    }
}
