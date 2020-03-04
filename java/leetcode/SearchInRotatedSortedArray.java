package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
* https://leetcode.com/problems/search-in-rotated-sorted-array/
*  
* */
public class SearchInRotatedSortedArray {
	public static void main(String[] args) {
		int[] nums = new int[] {4, 5, 6, 7, 0, 1, 2};
		int target = 0;
		search(nums, target);
	}
	
	static int search(int[] nums, int target) {
		if (nums.length == 0) {
			return -1;
		}
        return search(nums, 0, nums.length-1, target);
    }
	
	static int search(int[] nums, int startIndex, int endIndex, int target) {
		if (startIndex == endIndex || startIndex + 1 == endIndex) {
			if (nums[startIndex] == target) {
				return startIndex;
			} else if (nums[endIndex] == target) {
				return endIndex;
			} else {
				return -1;
			}
		}
		
		int middleIndex = (endIndex + startIndex + 1) / 2;
		
		if (nums[startIndex] < nums[middleIndex]) {
			if (nums[startIndex] <= target && target <= nums[middleIndex]) {
				return search(nums, startIndex, middleIndex, target);
			} else {
				return search(nums, middleIndex, endIndex, target);
			}
		} else {
			if (nums[middleIndex] <= target && target <= nums[endIndex]) {
				return search(nums, middleIndex, endIndex, target);
			} else {
				return search(nums, startIndex, middleIndex, target);
			}
		}
	}
}