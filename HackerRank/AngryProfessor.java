import java.util.Scanner;

/*
* https://www.hackerrank.com/challenges/angry-professor/problem
* */
public class AngryProfessor {

	static String angryProfessor(int k, int[] a) {
		int count = 0;
		for (int time : a) {
			if (time <= 0) {
				count++;
			}
		}
		return count < k ? "YES" : "NO";
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			int n = in.nextInt();
			int k = in.nextInt();
			int[] a = new int[n];
			for(int a_i = 0; a_i < n; a_i++){
				a[a_i] = in.nextInt();
			}
			String result = angryProfessor(k, a);
			System.out.println(result);
		}
		in.close();
	}
}