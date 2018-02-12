import java.util.Arrays;
import java.util.Scanner;

/*
* https://www.hackerrank.com/challenges/electronics-shop/problem
* */
public class ElectronicsShop {

	static int getMoneySpent(int[] keyboards, int[] drives, int s){
		Arrays.sort(keyboards);
		Arrays.sort(drives);
		if (keyboards[0] + drives[0] > s) {
			return -1;
		}

		int maxSum = 0;
		for (int i=0; i<keyboards.length; i++) {
			for (int j=0; j<drives.length; j++) {
				int sum = keyboards[i] + drives[j];
				if (sum > s) {
					continue;
				}
				maxSum = Math.max(maxSum, sum);
				if (maxSum == s) {
					return s;
				}
			}
		}
		return maxSum;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int n = in.nextInt();
		int m = in.nextInt();
		int[] keyboards = new int[n];
		for(int keyboards_i=0; keyboards_i < n; keyboards_i++){
			keyboards[keyboards_i] = in.nextInt();
		}
		int[] drives = new int[m];
		for(int drives_i=0; drives_i < m; drives_i++){
			drives[drives_i] = in.nextInt();
		}
		//  The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
		int moneySpent = getMoneySpent(keyboards, drives, s);
		System.out.println(moneySpent);
	}
}