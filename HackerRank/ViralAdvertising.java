import java.util.Scanner;

/*
* https://www.hackerrank.com/challenges/strange-advertising/problem
* */
public class ViralAdvertising {

	static int viralAdvertising(int n) {
		int start = 5;
		int total = 0;
		for (int i=1; i<=n; i++) {
			int half = start/2;
			total += half;
			start = half * 3;
		}
		return total;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int result = viralAdvertising(n);
		System.out.println(result);
		in.close();
	}
}