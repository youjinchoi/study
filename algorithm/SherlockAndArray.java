import java.util.Scanner;
/*
* https://www.hackerrank.com/challenges/sherlock-and-array/problem
* */
public class SherlockAndArray {

	static String solve(int[] a){
		int sumLeft = 0;
		int sumRight = 0;
		for (int element : a) {
			sumRight += element;
		}
		for (int i=0;i<a.length;i++) {
			int element = a[i];
			sumRight -= element;
			if (sumLeft == sumRight) {
				return "YES";
			}
			sumLeft += element;
		}
		return "NO";
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int a0 = 0; a0 < T; a0++){
			int n = in.nextInt();
			int[] a = new int[n];
			for(int a_i=0; a_i < n; a_i++){
				a[a_i] = in.nextInt();
			}
			String result = solve(a);
			System.out.println(result);
		}
	}
}