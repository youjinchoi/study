import java.util.Scanner;
import java.util.TreeSet;

/*
* https://www.hackerrank.com/challenges/manasa-and-stones/problem
* */
public class ManasaAndStones {

	static int[] stones(int n, int a, int b) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int i=0; i<n; i++) {
			int lastNumber = a * i + b * (n-1-i);
			set.add(lastNumber);
		}

		return set.stream().mapToInt(Integer::intValue).toArray();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int a0 = 0; a0 < T; a0++){
			int n = in.nextInt();
			int a = in.nextInt();
			int b = in.nextInt();
			int[] result = stones(n, a, b);
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
			}
			System.out.println("");


		}
		in.close();
	}
}