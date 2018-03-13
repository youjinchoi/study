import java.util.Scanner;

/*
* https://www.hackerrank.com/challenges/2d-array/problem
* */
public class _2DArraysDS {

	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int[][] arr = new int[6][6];
		for (int i=0; i<6; i++) {
			for (int j=0; j<6; j++) {
				arr[i][j] = scan.nextInt();
			}
		}

		int largestSum = Integer.MIN_VALUE;
		for (int i=0; i<4; i++) {
			for (int j=0; j<4; j++) {
				int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
				if (sum > largestSum) {
					largestSum = sum;
				}
			}
		}

		System.out.println(largestSum);
	}
}