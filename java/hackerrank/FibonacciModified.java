package hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

/*
* https://www.hackerrank.com/challenges/fibonacci-modified/problem
* */
public class FibonacciModified {

	static BigInteger fibonacciModified(int t1, int t2, int n) {
		BigInteger result = BigInteger.ZERO;
		BigInteger n_minus_2 = BigInteger.valueOf(t1);
		BigInteger n_minus_1 = BigInteger.valueOf(t2);
		for (int i=3; i<=n; i++) {
			result = n_minus_1.multiply(n_minus_1).add(n_minus_2);
			n_minus_2 = n_minus_1;
			n_minus_1 = result;
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t1 = in.nextInt();
		int t2 = in.nextInt();
		int n = in.nextInt();
		BigInteger result = fibonacciModified(t1, t2, n);
		System.out.println(result);
		in.close();
	}
}