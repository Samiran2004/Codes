import java.util.Scanner;

public class Character_of_Decrypted_String {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = input.next();
        System.out.print("Enter the K'th position: ");
        Long k = input.nextLong();
        input.close();
        System.out.println(kThCharaterOfDecryptedString(str, k));
    }

    private static char kThCharaterOfDecryptedString(String str, Long k) {
        if (str == null || str.length() == 0) {
            return ' ';
        }

        int i = 0;
        int processedChar = 0;

        while (i < str.length()) {

            StringBuilder subStringBuilder = new StringBuilder();
            while (i < str.length() && Character.isLetter(str.charAt(i))) {
                subStringBuilder.append(str.charAt(i));
                i++;
            }
            String subString = subStringBuilder.toString();

            StringBuilder countBuilder = new StringBuilder();
            while (i < str.length() && Character.isDigit(str.charAt(i))) {
                countBuilder.append(str.charAt(i));
                i++;
            }
            int count = Integer.parseInt(countBuilder.toString());

            int segmentLength = subString.length() * count;

            if (k <= processedChar + segmentLength) {
                int offSet = (int) (k - processedChar - 1);
                int posInSubString = offSet % subString.length();
                return subString.charAt(posInSubString);
            } else {
                processedChar += segmentLength;
            }
        }
        throw new IllegalArgumentException("K is out of bound.");

    }
}
