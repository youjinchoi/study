package mailprogramming;

import java.util.HashMap;

/**
* 정수로된 배열이 주어지면, 각 원소가 자신을 뺀 나머지 원소들의 곱셈이 되게하라.
* 단, 나누기 사용 금지, O(n) 시간복잡도
*
* 예제)
* input: [1, 2, 3, 4, 5]
* output: [120, 60, 40, 30, 24]
*/
public class Question12 {
    public static void main(String[] args) {
		solve(new int[] {1, 2, 3, 4, 5});
    }

	/**
	 * 풀이.
	 * 여기서 중요한것은 나누기 사용이 안된다는것과 O(n) 시간 복잡도여야 한다는 겁니다.
	 *
	 * 여기 input 예제를 보면
	 * Input a = [a[0], a[1], a[2], a[3], a[4]]
	 * output =
	 * [
	 * a[1]*a[2]*a[3]*a[4],
	 * a[0]*a[2]*a[3]*a[4],
	 * a[0]*a[1]*a[3]*a[4],
	 * a[0]*a[1]*a[2]*a[4],
	 * a[0]*a[1]*a[2]*a[3]
	 * ]
	 *
	 * 그럼 여기서 두개의 배열을 만들어줍니다. O(n)*2 = O(n)
	 * array one 과 array two 의 각 원소들을 서로 곱해주면 array output 이 나옵니다.
	 *
	 * 총 시간 복잡도 = O(n) + O(n) + O(n) = O(3n) = O(n)
	 */
	static void solve(int[] arr) {
		int length = arr.length;
		int[] one = new int[length];
		int product = 1;
		for(int i = 0; i < length; i++) {
			one[i] = product;
			product *= arr[i];
		}
		int[] two = new int[length];
		product = 1;
		for(int i = length-1; i >= 0; i--) {
			two[i] = product;
			product *= arr[i];
		}
		int[] output = new int[length];
		for(int i = 0; i < length; i++) {
			output[i] = one[i]*two[i];
		}
		System.out.println(output);
	}
}