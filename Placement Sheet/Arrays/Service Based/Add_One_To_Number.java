import java.util.ArrayList;
import java.util.Scanner;

public class Add_One_To_Number {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();
        ArrayList<Integer> arr = new ArrayList<>(size);
        for(int i = 0; i<size; i++) {
            System.out.printf("Enter %d number element of the array: ", i+1);
            arr.add(input.nextInt());
        }
        input.close();

        System.out.println("Result: "+ addOneToNumber(arr));
    }

    private static ArrayList<Integer> addOneToNumber(ArrayList<Integer> arr)
    {
        // Write your code here.

		if(arr.size() == 0) {
			return null;
		}

		int num = arr.get(0);
		for(int i = 1; i<arr.size(); i++) {
			num = num * 10 + arr.get(i);
		}

		int sum = num + 1;
		ArrayList<Integer> resultArr = new ArrayList<>();
		
		while(sum != 0) {
			int rem = sum % 10;
			resultArr.add(0, rem);
			sum = sum / 10;
		}

		return resultArr;
    }
}