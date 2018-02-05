import java.util.Scanner;

/*
* https://www.hackerrank.com/challenges/camelcase/problem
* */
public class CamelCase {

	static int camelcase(String s) {
		int count = 1;
		for (char ch : s.toCharArray()) {
			if (Character.isUpperCase(ch)) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int result = camelcase(s);
		System.out.println(result);
		in.close();
	}
}