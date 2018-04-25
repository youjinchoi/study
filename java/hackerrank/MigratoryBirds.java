package hackerrank;

import java.util.Scanner;

/*
* https://www.hackerrank.com/challenges/migratory-birds/problem
* */
public class MigratoryBirds {

	static int migratoryBirds(int n, int[] ar) {
		int[] countByType = new int[5];
		int maxCount = 0;
		for (int type : ar) {
			int index = type - 1;
			int count = countByType[index];
			count++;
			countByType[index] = count;
			if (maxCount < count) {
				maxCount = count;
			}
		}

		for (int i=0; i<5; i++) {
			if (countByType[i] == maxCount) {
				return i+1;
			}
		}

		return 1;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for(int ar_i = 0; ar_i < n; ar_i++){
			ar[ar_i] = in.nextInt();
		}
		int result = migratoryBirds(n, ar);
		System.out.println(result);
	}
}