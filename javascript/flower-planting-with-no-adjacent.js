/**
 * @param {number} N
 * @param {number[][]} paths
 * @return {number[]}
 */
var gardenNoAdj = function(N, paths) {
    var result = [];
    for (var i=1; i<=N; i++) {
        result.push(0);
    }
    
    var map = {};
    paths.forEach(arr => {
        var garden1 = arr[0];
        var garden2 = arr[1];
        if (!map[garden1]) {
            map[garden1] = {};
        }
        map[garden1][garden2] = true;;
        if (!map[garden2]) {
            map[garden2] = {};
        }
        map[garden2][garden1] = true;
    });
    
    for (var i=1; i<=N; i++) {
        var flowerTypes = [0, 0, 0, 0];
        Object.keys(map[i]).forEach(adjacent => {
            if (result[adjacent-1] != 0) {
                flowerTypes[result[adjacent-1]-1] = 1;
            }
        });
        var flower = 0;
        for (var j=0; j<4; j++) {
            if (flowerTypes[j] == 0) {
                flower = j+1;
                break;
            }
        }
        result[i-1] = flower;
    }
    return result;
};

console.log(gardenNoAdj(3, [[1,2], [2,3], [3,1]]))