package hackerrank;

import java.util.HashMap;
import java.util.Scanner;

/*
* https://www.hackerrank.com/challenges/birthday-cake-candles/problem
* */
public class BirthdayCakeCandles {

	static int birthdayCakeCandles(int n, int[] ar) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = 0;
		for (int i : ar) {
			if (i >= max) {
				max = i;
				Integer count = map.get(i);
				if (count == null) {
					count = 1;
				} else {
					count++;
				}
				map.put(i, count);
			}
		}

		return map.get(max);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for(int ar_i = 0; ar_i < n; ar_i++){
			ar[ar_i] = in.nextInt();
		}
		int result = birthdayCakeCandles(n, ar);
		System.out.println(result);
	}
}