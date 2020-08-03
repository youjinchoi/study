/**
 * https://leetcode.com/problems/running-sum-of-1d-array/
 * @param {number[]} nums
 * @return {number[]}
 */
var runningSum = function(nums) {
    var result = [];
    var lastValue = nums.reduce((accumulator, currentValue) => {
        result.push(accumulator);
        return accumulator + currentValue;
    });
    result.push(lastValue);
    return result;
};