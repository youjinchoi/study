/*
* https://leetcode.com/problems/move-zeroes/
* */
public class MoveZeroes {

	static void moveZeroes(int[] nums) {
		for (int i=0; i<nums.length; i++) {
			// skip if i-th element is not zero
			if (nums[i] != 0) {
				continue;
			}
			int current = i;
			// check every element after i-th element, and swap if it's not zero
			for (int j=i+1; j<nums.length; j++) {
				if (nums[j] != 0) {
					int temp = nums[j];
					nums[j] = nums[current];
					nums[current] = temp;
					current = j;
				}
			}
		}
		System.out.println(nums);
		
	}

	public static void main(String[] args) {
		int[] arr = new int[] {0,1,0,3,12};
		moveZeroes(arr);
	}
}