package leetcode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
* https://leetcode.com/problems/merge-intervals/
* 
* */
public class MergeIntervals {
	public static void main(String[] args) {
		int[][] arr = new int[5][2];
		arr[0] = new int[] {2, 3};
		arr[1] = new int[] {4, 5};
		arr[2] = new int[] {6, 7};
		arr[3] = new int[] {8, 9};
		arr[4] = new int[] {1, 10};
		
		merge(arr);
	}
	
	static int[][] merge(int[][] intervals) {
		List<int[]> list = new ArrayList<int[]>();
		Set<Integer> set = new HashSet<Integer>();
		
		for (int i=0; i<intervals.length; i++) {
			if (set.contains(i)) {
				continue;
			}
			
			set.add(i);
			int[] arr = intervals[i];
			for (int j=i+1; j<intervals.length; j++) {
				if (set.contains(j)) {
					continue;
				}
				if (isOverlapping(arr, intervals[j])) {
					set.add(j);
					arr = mergeTwo(arr, intervals[j]);
				}
			}
			list.add(arr);
		}
		
		int[][] result = new int[list.size()][2];
		for (int i=0; i<list.size(); i++) {
			result[i] = list.get(i);
		}
		
		return result;
    }
	
	static boolean isOverlapping(int[] arr1, int[] arr2) {
		if (arr1[0] <= arr2[0] && arr2[0] <= arr1[1]) {
			return true;
		}
		
		if (arr1[0] <= arr2[1] && arr2[1] <= arr1[1]) {
			return true;
		}
		
		if (arr1[0] <= arr2[0] && arr2[0] <= arr1[1]) {
			return true;
		}
		
		if (arr1[0] <= arr2[1] && arr2[1] <= arr1[1]) {
			return true;
		}
		
		if (arr2[0] <= arr1[0] && arr1[0] <= arr2[1]) {
			return true;
		}
		
		if (arr2[0] <= arr1[1] && arr1[1] <= arr2[1]) {
			return true;
		}
		
		return false;
	}
	
	static int[] mergeTwo(int[] arr1, int[] arr2) {
		int min = Math.min(arr1[0], arr2[0]);
		int max = Math.max(arr1[1], arr2[1]);
		return new int[] {min, max};
	}
}