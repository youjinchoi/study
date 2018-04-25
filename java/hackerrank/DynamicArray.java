package hackerrank;

import java.util.ArrayList;
import java.util.Scanner;

/*
* https://www.hackerrank.com/challenges/dynamic-array/problem
* */
public class DynamicArray {

	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scan.nextInt();
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<n; i++) {
			list.add(new ArrayList<Integer>());
		}
		int lastAnswer = 0;

		int numberOfQueries = scan.nextInt();
		for (int i=0; i<numberOfQueries; i++) {
			int type = scan.nextInt();
			int x = scan.nextInt();
			int y = scan.nextInt();

			int seq = (x^lastAnswer) % n;
			if (type == 1) {
				ArrayList<Integer> arr = list.get(seq);
				arr.add(y);
			} else if (type == 2) {
				ArrayList<Integer> arr = list.get(seq);
				lastAnswer = arr.get(y % arr.size());
				System.out.println(lastAnswer);
			}
		}
	}
}