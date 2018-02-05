import java.util.Scanner;

/*
* https://www.hackerrank.com/challenges/apple-and-orange/problem
* */
public class AppleAndOrange {

	static int[] appleAndOrange(int s, int t, int a, int b, int[] apple, int[] orange) {
		int apple_standard_left = s - a;
		int apple_standard_right = t - a;
		int orange_standard_left = s - b;
		int orange_standard_right = t - b;

		int apple_count = 0;
		for (int apple_location : apple) {
			if (apple_location >= apple_standard_left && apple_location <= apple_standard_right) {
				apple_count++;
			}
		}

		int orange_count = 0;
		for (int orange_location : orange) {
			if (orange_location >= orange_standard_left && orange_location <= orange_standard_right) {
				orange_count++;
			}
		}

		int[] result = new int[2];
		result[0] = apple_count;
		result[1] = orange_count;
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int t = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		int m = in.nextInt();
		int n = in.nextInt();
		int[] apple = new int[m];
		for(int apple_i = 0; apple_i < m; apple_i++){
			apple[apple_i] = in.nextInt();
		}
		int[] orange = new int[n];
		for(int orange_i = 0; orange_i < n; orange_i++){
			orange[orange_i] = in.nextInt();
		}
		int[] result = appleAndOrange(s, t, a, b, apple, orange);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
		}
		System.out.println("");


		in.close();
	}
}