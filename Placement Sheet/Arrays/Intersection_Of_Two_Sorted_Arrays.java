import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Intersection_Of_Two_Sorted_Arrays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the first array: ");
        int size1 = input.nextInt();

        ArrayList<Integer> arr1 = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            System.out.printf("Enter %d number element of the array: ", i + 1);
            arr1.add(input.nextInt());
        }

        System.out.print("Enter the size of the second array: ");
        int size2 = input.nextInt();

        ArrayList<Integer> arr2 = new ArrayList<>();
        for (int i = 0; i < size2; i++) {
            System.out.printf("Enter %d number element of the array: ", i + 1);
            arr2.add(input.nextInt());
        }
        input.close();

        ArrayList<Integer> result = findIntersection(arr1, size1, arr2, size2);

        printArrayList(result);
    }

    private static void printArrayList(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
    }

    private static ArrayList<Integer> findIntersection(ArrayList<Integer> arr1, int size1, ArrayList<Integer> arr2,
            int size2) {
        ArrayList<Integer> resultArr = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        if (arr1.size() == 0 || arr2.size() == 0) {
            return resultArr;
        }

        for (int i = 0; i < size2; i++) {
            map.put(arr2.get(i), map.getOrDefault(arr2.get(i), 0) + 1);
        }

        System.out.println(map);

        for (int i = 0; i < size1; i++) {
            int currVal = arr1.get(i);
            System.out.println(currVal);
            if (map.getOrDefault(currVal, 0) > 0) {
                resultArr.add(currVal);
                map.replace(currVal, map.get(currVal) - 1);
            }
        }

        return resultArr;
    }
}
