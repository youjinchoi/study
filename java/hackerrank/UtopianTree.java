package hackerrank;

import java.util.Scanner;

/*
* https://www.hackerrank.com/challenges/utopian-tree/problem
* */
public class UtopianTree {

	static int utopianTree(int n) {
		int growth = 1;
		for (int i=1; i<=n; i++) {
			if (i % 2 == 1) {
				growth *= 2;
			} else {
				growth += 1;
			}
		}
		return growth;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			int n = in.nextInt();
			int result = utopianTree(n);
			System.out.println(result);
		}
		in.close();
	}
}