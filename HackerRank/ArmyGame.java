import java.util.Scanner;

/*
* https://www.hackerrank.com/challenges/game-with-cells/problem
* */
public class ArmyGame {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		System.out.println((n/2 + n%2) * (m/2 + m%2));
	}
}