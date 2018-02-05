import java.util.Scanner;

/*
* https://www.hackerrank.com/challenges/tower-breakers-1/problem
* */
public class TowerBreakers {

	static int towerBreakers(int n, int m) {
		if (m == 1) {
			return 2;
		}
		return n % 2 == 1 ? 1 : 2;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			int n = in.nextInt();
			int m = in.nextInt();
			int result = towerBreakers(n, m);
			System.out.println(result);
		}
		in.close();
	}
}