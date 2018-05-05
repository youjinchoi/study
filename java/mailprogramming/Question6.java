package mailprogramming;

import java.util.*;

/**
* 간격(interval)로 이루어진 배열이 주어지면, 겹치는 간격 원소들을 합친 새로운 배열을 만드시오.
* 간격은 시작과 끝으로 이루어져 있으며 시작은 끝보다 작거나 같습니다.
* 예제)
* Input: {{2,4}, {1,5}, {7,9}}
* Output: {{1,5}, {7,9}}
*
* Input: {{3,6}, {1,3}, {2,4}}
* Output: {{1,6}}
*/
public class Question6 {
    public static void main(String[] args) {
		List<Interval> list = new ArrayList<>();
		list.add(new Interval(2, 4));
		list.add(new Interval(1, 5));
		list.add(new Interval(7, 9));
        System.out.println(merge(list));
    }

	/**
	 * 풀이.
	 * 문제의 어려운 점은 간격 원소들이 무작위로 순서가 돼있는 것입니다.
	 * 주로 이런 경우엔, 자료구조를 써서 무작위의 원소들을 쉽게 정리하거나, 원소들을 정렬(sort) 하면 됩니다. 이 문제에선 간격 원소들을 정렬해보겠습니다.
	 *
	 * 간격 원소가 {start, end}로 나누어 있다고 가정하고, start로 정렬합니다.
	 * 정렬은 언어마다 있는 정렬 함수를 써도 되고, 아니면 직접 정렬 알고리즘을 써서 정렬해도 상관없습니다.
	 * 정렬된 원소들은 처음부터 하나씩 보면서 현재 원소의 end값과 다음 원소의 start값을 비교하여 겹치면 두 원소를 합치면 됩니다.
	 *
	 * 시간 복잡도: O(n*log(n))
	 * 공간 복잡도: O(n)
	 */
	static List<Interval> merge(List<Interval> intervals) {
		intervals.sort((Interval o1, Interval o2) -> (
			o1.start < o2.start ? -1 : o1.start == o2.start ? 0 : 1
		));

		LinkedList<Interval> solution = new LinkedList<>();
		solution.add(intervals.get(0));
		for (int i = 1; i < intervals.size(); i++) {
			Interval interval = intervals.get(i);
			if (solution.getLast().end < interval.start) {
				solution.add(interval);
			}
			else {
				solution.getLast().end = Math.max(solution.getLast().end, interval.end);
			}
		}
		return solution;
	}

	static class Interval {
		int start;
		int end;

		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "{" + start + "," + end + "}";
		}
	}
}