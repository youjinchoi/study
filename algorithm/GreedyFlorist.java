import java.util.Arrays;
import java.util.Scanner;

/*
* https://www.hackerrank.com/challenges/greedy-florist/problem
* */
public class GreedyFlorist {
	static int getMinimumCost(int n, int k, int[] c){
		Arrays.sort(c);
		int totalCost = 0;
		int alreadyPurchasedCount = 0;
		int turn = k;

		for (int i=c.length-1; i>-1; i--) {
			totalCost += (alreadyPurchasedCount + 1) * c[i];
			turn--;
			if (turn == 0) {
				turn = k;
				alreadyPurchasedCount++;
			}
		}
		return totalCost;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] c = new int[n];
		for(int c_i=0; c_i < n; c_i++){
			c[c_i] = in.nextInt();
		}
		int minimumCost = getMinimumCost(n, k, c);
		System.out.println(minimumCost);
	}
}