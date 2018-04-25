package hackerrank;

import java.util.Scanner;

/*
* https://www.hackerrank.com/challenges/the-great-xor/problem
* */
public class TheGreatXOR {
	
	static long theGreatXor(long x){
		String str = Long.toBinaryString(x);
		int count = 0;
		char[] arr = str.toCharArray();
		for (int i=0;i<arr.length;i++) {
			if (arr[i] == '0') {
				count += Math.pow(2, str.length() - (i + 1));
			}
		}
		return count;
    }

    public static void main(String[] args) {
    		Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            long x = in.nextLong();
            long result = theGreatXor(x);
            System.out.println(result);
        }
    }
}