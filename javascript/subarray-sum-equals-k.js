/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 * 
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var subarraySum = function(nums, k) {
    let count = 0;
    let sum = 0;
    nums.forEach((_, index) => {
        for (let i=index; i<nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                count++;
            }
        }
        sum = 0;
    });
    return count;
};