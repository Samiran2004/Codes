import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Make_Unique_Array {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            System.out.printf("Enter %d number element of the list: ", i + 1);
            arr.add(input.nextInt());
        }
        input.close();
        System.out.println(minElementsToRemove(arr));
    }

    private static int minElementsToRemove(ArrayList<Integer> arr) {
        if (arr.isEmpty()) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < arr.size(); i++) {
            int currElm = arr.get(i);
            if (set.contains(currElm)) {
                count++;
                continue;
            }
            set.add(currElm);
        }
        return count;
    }
}
