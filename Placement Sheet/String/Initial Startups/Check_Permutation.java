import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Check_Permutation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 1st string: ");
        String str1 = input.next();
        System.out.print("Enter 2nd string: ");
        String str2 = input.next();
        input.close();
        System.out.println(areAnagram(str1, str2));
    }

    private static boolean areAnagram(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0
                || str1.length() != str2.length()) {
            return false;
        }

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        char[] str1Arr = str1.toCharArray();
        char[] str2Arr = str2.toCharArray();

        for (int i = 0; i < str1Arr.length; i++) {
            map1.put(str1Arr[i], map1.getOrDefault(str1Arr[i], 0) + 1);
            map2.put(str2Arr[i], map2.getOrDefault(str2Arr[i], 0) + 1);
        }

        return map1.equals(map2);
    }
}
