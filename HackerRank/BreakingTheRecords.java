import java.util.Scanner;

/*
* https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem
* */
public class BreakingTheRecords {
	static int[] breakingRecords(int[] score) {
		int best = score[0];
		int bestIncresed = 0;
		int worst = score[0];
		int worstDecresed = 0;
		for (int i=0; i<score.length; i++) {
			if (score[i] > best) {
				best = score[i];
				bestIncresed++;
				continue;
			}
			if (score[i] < worst) {
				worst = score[i];
				worstDecresed++;
				continue;
			}
		}
		return new int[]{bestIncresed, worstDecresed};
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] score = new int[n];
		for(int score_i = 0; score_i < n; score_i++){
			score[score_i] = in.nextInt();
		}
		int[] result = breakingRecords(score);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
		}
		System.out.println("");


		in.close();
	}
}