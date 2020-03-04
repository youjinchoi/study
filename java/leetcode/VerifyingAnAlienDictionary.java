package leetcode;
import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.com/problems/verifying-an-alien-dictionary/
*  
* */
public class VerifyingAnAlienDictionary {
	public static void main(String[] args) {
		String[] words = new String[] {"word","world","row"};
		String order = "worldabcefghijkmnpqstuvxyz";
		isAlienSorted(words, order);
	}
	
	static boolean isAlienSorted(String[] words, String order) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char[] orderArray = order.toCharArray();
		for (int i=0; i<orderArray.length; i++) {
			map.put(orderArray[i], i);
		}
		
		for (int i=0; i<words.length-1; i++) {
			String word1 = words[i];
			String word2 = words[i+1];
			
			if (!isSorted(word1, word2, map)) {
				return false;
			}
		}
		
		return true;
    }
	
	static boolean isSorted(String word1, String word2, Map<Character, Integer> map) {
		int length1 = word1.length();
		int length2 = word2.length();
		for (int i=0; i<Math.min(length1, length2); i++) {
			int order1 = map.get(word1.charAt(i));
			int order2 = map.get(word2.charAt(i));
			if (order1 < order2) {
				return true;
			} else if (order1 > order2) {
				return false;
			}
		}
		return length1 <= length2;
	}
}