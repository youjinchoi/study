package hackerrank;

import java.util.Scanner;

/*
* https://www.hackerrank.com/challenges/find-digits/problem
* */
public class FindDigits {

	static int findDigits(int n) {
		int numberOfDigits = (int)Math.log10((double)n) + 1;
		int m = n;
		int count = 0;
		for (int i=0; i<numberOfDigits; i++) {
			int num = m % 10;
			if (num != 0 && n % num == 0) {
				count++;
			}
			m = m/10;
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			int n = in.nextInt();
			int result = findDigits(n);
			System.out.println(result);
		}
		in.close();
	}
}