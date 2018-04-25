package hackerrank;

import java.util.Scanner;

/*
* https://www.hackerrank.com/challenges/lisa-workbook/problem
* */
public class LisasWorkbook {

	static int workbook(int n, int k, int[] arr) {
		int page = 1;
		int problemsPerOnePage = 0;
		int specialCount = 0;
		for (int i : arr) {
			for (int j=1; j<=i; j++) {
				problemsPerOnePage++;
				if (page == j) {
					specialCount++;
				}
				if (problemsPerOnePage == k) {
					problemsPerOnePage = 0;
					page++;
				}
			}
			if (problemsPerOnePage != 0) {
				page++;
				problemsPerOnePage = 0;
			}
		}
		return specialCount;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] arr = new int[n];
		for(int arr_i = 0; arr_i < n; arr_i++){
			arr[arr_i] = in.nextInt();
		}
		int result = workbook(n, k, arr);
		System.out.println(result);
		in.close();
	}
}