/**
 * https://leetcode.com/problems/find-the-town-judge/
 * 
 * @param {number} N
 * @param {number[][]} trust
 * @return {number}
 */
var findJudge = function(N, trust) {
    if (N == 1 && trust.length == 0) {
        return 1;
    }
    if (trust.length < N-1) {
        return -1;
    }
    
    var trustMap = {};
    var trustedMap = {};
    trust.forEach((arr) => {
        var person = arr[0];
        var trusted = arr[1];
        if (!trustedMap[trusted]) {
            trustedMap[trusted] = [];
        }
        trustedMap[trusted].push(person);
        if (!trustMap[person]) {
            trustMap[person] = [];
        }
        trustMap[person].push(trusted);
    });
    
    var result = -1;
    for (const [key, value] of Object.entries(trustedMap)) {
        if (value.length == N - 1 && !trustMap[key]) {
            result = key;
            break;
        }
    }     
    return result;
};