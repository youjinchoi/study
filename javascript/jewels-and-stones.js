/**
 * https://leetcode.com/problems/jewels-and-stones/
 * @param {string} J
 * @param {string} S
 * @return {number}
 */
var numJewelsInStones = function(J, S) {
    var count = 0;
    for (var i=0; i<S.length; i++){
        var character = S.substr(i, 1);
        if (J.indexOf(character) != -1) {
            count++;
        }
    }
    return count;
};