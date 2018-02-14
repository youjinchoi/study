import java.util.Scanner;

/*
* https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem
* */
public class BeautifulDaysAtTheMovies {

	static int beautifulDays(int i, int j, int k) {
		int count = 0;
		for (int day=i; day<=j; day++) {
			if ((day - reverse(day)) % k == 0) {
				count++;
			}
		}
		return count;
	}

	static int reverse(int number) {
		return Integer.valueOf(new StringBuffer(String.valueOf(number)).reverse().toString()).intValue();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int i = in.nextInt();
		int j = in.nextInt();
		int k = in.nextInt();
		int result = beautifulDays(i, j, k);
		System.out.println(result);
		in.close();
	}
}