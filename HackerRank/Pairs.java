import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

/*
* https://www.hackerrank.com/challenges/pairs/problem
* */
public class Pairs {
	static TreeSet<Integer> set = new TreeSet<Integer>();

	static int pairs(int k, int[] arr) {
		int pairCount = 0;
		Arrays.sort(arr);
		int lastValue = arr[arr.length-1];
		for (int i : arr) {
			if (i + k > lastValue) {
				break;
			}
			if (set.contains(Integer.valueOf(i + k))) {
				pairCount++;
			}
		}
		return pairCount;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] arr = new int[n];

		for(int arr_i = 0; arr_i < n; arr_i++){
			int i = in.nextInt();
			arr[arr_i] = i;
			set.add(Integer.valueOf(i));
		}
		int result = pairs(k, arr);
		System.out.println(result);
		in.close();
	}
}