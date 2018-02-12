/**
*
* 피보나치 배열은 0과 1로 시작하며, 다음 피보나치 수는 바로 앞의 두 피보나치 수의 합이 된다. 정수 N이 주어지면, N보다 작은 모든 짝수 피보나치 수의 합을 구하여라.
*
* 예제)
* Input: N = 12
* Output: 10 // 0, 1, 2, 3, 5, 8 중 짝수인 2 + 8 = 10.
*
*/
public class Question2 {

	static int solution(int n) {
		int[] arr = new int[n];
		arr[0] = 0;
		arr[1] = 1;

		int sum = 0;
		for (int i=2; i<n; i++) {
			arr[i] = arr[i-1] + arr[i-2];
			if (arr[i] >= n) {
				break;
			}
			if (arr[i] % 2 == 0) {
				sum += arr[i];
			}
		}
		return sum;
	}
	
    public static void main(String[] args) {
		int n = 12;
        System.out.println(solution(n));
    }

	/**
	 * 풀이.
	 * 이 문제는 N보다 클때까지 피보나치의 수를 구하며 짝수인 피보나치 수를 다 더해주면 됩니다.
	 * 여기서 피보나치 수가 0이 아니고 1부터 시작하는 이유는 x가 0일 경우 sum에 더해도 도움이 되지 않기 때문입니다.
	 */
	static int evenFibSum(int N) {
		int sum = 0;
		int x = 1;
		int y = 2;
		while (x <= N) {
			if (x % 2 == 0) {
				sum += x;
			}
			int z = x + y;
			x = y;
			y = z;
		}
		return sum;
	}
}