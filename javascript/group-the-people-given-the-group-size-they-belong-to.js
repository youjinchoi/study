/**
 * https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
 * @param {number[]} groupSizes
 * @return {number[][]}
 */
var groupThePeople = function(groupSizes) {
    var arrayObj = {};
    for (var i=0; i<groupSizes.length; i++) {
        var arraySize = groupSizes[i];
        if (arrayObj[arraySize]) {
            arrayObj[arraySize].push(i);
        } else {
            arrayObj[arraySize] = [i];
        }
    }
    var result = [];
    Object.keys(arrayObj).forEach(key => {
        var array = arrayObj[key];
        var length = Number(key);
        if (array.length == length) {
            result.push(array);
        } else {
            var numberOfArray = array.length / length;
            for (var i=0; i<numberOfArray; i++) {
                var begin = length * i;
                var end = begin + length;
                result.push(array.slice(begin, end));
            }
        }
    });
    return result;
};