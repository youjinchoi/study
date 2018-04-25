package hackerrank;

import java.util.Scanner;

/*
* https://www.hackerrank.com/challenges/drawing-book/problem
* */
public class DrawingBook {

	static int solve(int n, int p){
		int pagesFromFirst = p/2;
		int pagesFromLast = n/2 - pagesFromFirst;
		return pagesFromFirst < pagesFromLast ? pagesFromFirst : pagesFromLast;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int p = in.nextInt();
		int result = solve(n, p);
		System.out.println(result);
	}
}