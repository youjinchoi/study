package hackerrank;

import java.util.Scanner;

/*
* https://www.hackerrank.com/challenges/restaurant/problem
* */
public class Restaurant {

	static int solve(int n1, int n2) {
		int gcd = gcd(n1, n2);
		return (n1 * n2) / (gcd * gcd);
	}

	static int gcd(int n1, int n2) {
		int m, n;
		if (n1 >= n2) {
			m = n1;
			n = n2;
		} else {
			m = n2;
			n = n1;
		}

		int gcd = 1;
		while(true) {
			int r = m % n;
			if (r == 0) {
				gcd = n;
				break;
			} else {
				m = n;
				n = r;
			}
		}
		return gcd;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int a0 = 0; a0 < T; a0++){
			int n1 = in.nextInt();
			int n2 = in.nextInt();
			int result = solve(n1, n2);
			System.out.println(result);
		}
	}
}