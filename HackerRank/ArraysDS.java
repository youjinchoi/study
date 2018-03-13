import java.util.Scanner;

/*
* https://www.hackerrank.com/challenges/arrays-ds/problem
* */
public class ArraysDS {

	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int n = Integer.parseInt(scan.nextLine().trim());

		int[] arr = new int[n];

		String[] arrItems = scan.nextLine().split(" ");

		for (int arrItr = 0; arrItr < n; arrItr++) {
			int arrItem = Integer.parseInt(arrItems[arrItr].trim());
			arr[arrItr] = arrItem;
		}

		for (int i = arr.length-1; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}
}