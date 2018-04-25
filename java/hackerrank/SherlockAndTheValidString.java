package hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
* https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
* */
public class SherlockAndTheValidString {

	static String isValid(String s){
		Map<Character, Integer> charAndCount = new HashMap<Character, Integer>();
		for (char ch : s.toCharArray()) {
			Integer count = charAndCount.get(ch);
			count = count == null ? 1 : count+1;
			charAndCount.put(ch, count);
		}
		
		Integer[] counts = charAndCount.values().toArray(new Integer[charAndCount.size()]);
		Arrays.sort(counts);
		Integer first = counts[0];
		Integer last = counts[counts.length-1];
		if (first.intValue() == last.intValue()) {
			return "YES";
		}
		
		if (last - first == 1) {
			if (counts[1] == last.intValue() || counts[counts.length-2] == first.intValue()) {
				return "YES";
			}
		}
		
		if (first.intValue() == 1 && counts[1] == last.intValue()) {
			return "YES";
		}
		
		return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = isValid(s);
        System.out.println(result);
    }
}