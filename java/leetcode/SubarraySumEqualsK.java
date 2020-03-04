package leetcode;

/*
* https://leetcode.com/problems/subarray-sum-equals-k/
*  
* */
public class SubarraySumEqualsK {
	public static void main(String[] args) {
		int[] nums = new int[] {1, 1, 1};
		int k = 2;
		subarraySum(nums, k);
	}
	
	static int subarraySum(int[] nums, int k) {
		int count = 0;
		for (int i=0; i<nums.length; i++) {
			int j = i;
			int sum = 0;
			while (j < nums.length) {
				sum += nums[j];
				if (sum == k) {
					count++;
				}
				j++;
			}
		}
        return count;
    }
}