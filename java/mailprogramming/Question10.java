package mailprogramming;

import java.util.HashMap;
import java.util.Map;

/**
* String이 주어지면, 중복된 char가 없는 가장 긴 서브스트링 (substring)의 길이를 찾으시오.
*
* 예제)
* Input: “aabcbcbc”
* Output: 3 // “abc”
*
* Input: “aaaaaaaa”
* Output: 1 // “a”
*
* Input: “abbbcedd”
* Output: 4 // “bced”
*/
public class Question10 {
    public static void main(String[] args) {
		System.out.println(longestSubstringLength("aabcbcbc"));
    }

	/**
	 * 풀이.
	 * 이 문제는 해쉬맵을 사용하여 char와 char의 인덱스를 저장하여 풀면 됩니다.
	 * string의 각 char를 보면서 해쉬맵에 있다면 substring 시작점을 char의 인덱스+1 로 두면 됩니다.
	 * 그리고 현재 char의 인덱스와 시작점의 거리를 계속 계산하여 가장 큰 값을 리턴하면 됩니다.
	 *
	 * 시간 복잡도: O(n)
	 * 공간 복잡도: O(n)
	 */
	static int longestSubstringLength(String s) {
		int ret = 0;
		int start = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				start = Math.max(map.get(s.charAt(i)), start);
			}
			ret = Math.max(ret, i - start + 1);
			map.put(s.charAt(i), i + 1); // 캐릭터 인덱스 저장
		}
		return ret;
	}
}