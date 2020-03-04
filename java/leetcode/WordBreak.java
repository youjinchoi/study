package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
* https://leetcode.com/problems/word-break/
* 
* failed
*  
* */
public class WordBreak {
	public static void main(String[] args) {
		String s = "aaaaaaa";
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("aaaa");
		wordDict.add("aaa");
		wordBreak(s, wordDict);
	}
	
	static boolean wordBreak(String s, List<String> wordDict) {
		Set<String> set = new HashSet<String>();
		for (String word : wordDict) {
			set.add(word);
		}
		return wordBreak(s.toCharArray(), 0, set);
    }
	
	static boolean wordBreak(char[] arr, int index, Set<String> wordSet) {
		String sum = "";
		for (int i=index; i<arr.length; i++) {
			sum += Character.toString(arr[i]);
			if (wordSet.contains(sum)) {
				if (i+1 == arr.length) {
					return true;
				}
				return wordBreak(arr, i+1, wordSet);
			}
		}
		return false;
	}
}