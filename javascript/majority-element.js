/**
 * https://leetcode.com/problems/majority-element/
 * 
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
    nums.sort();
    return nums[nums.length / 2 + 1];
};