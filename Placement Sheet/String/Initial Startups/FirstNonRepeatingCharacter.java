import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = input.next();
        input.close();
        System.out.println(firstNonRepeatingCharacter(str));
        System.out.println(firstNonRepeatingCharacter2(str));
    }

    private static char firstNonRepeatingCharacter(String str) {
        if (str.length() == 0) {
            return ' ';
        }
        char[] strArr = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : strArr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : strArr) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return ' ';
    }

    // With out hashmap
    private static char firstNonRepeatingCharacter2(String str) {
        if(str.length() == 0 || str == null) {
            return ' ';
        }

        int[] freq = new int[256];

        for(char c : str.toCharArray()){
            freq[c]++;
        }

        for(char c : str.toCharArray()) {
            if(freq[c] == 1 ) {
                return c;
            }
        }
        return ' ';
    }
}
