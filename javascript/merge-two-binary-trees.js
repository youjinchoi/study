/**
 * https://leetcode.com/problems/merge-two-binary-trees/
 */

function TreeNode(val, left, right) {
    this.val = (val===undefined ? 0 : val)
    this.left = (left===undefined ? null : left)
    this.right = (right===undefined ? null : right)
}

/**
 * @param {TreeNode} t1
 * @param {TreeNode} t2
 * @return {TreeNode}
 */
var mergeTrees = function(t1, t2) {
    if (!t1 && !t2) {
        return null;
    }
    const node = new TreeNode();
    node.val = ((t1 && t1.val) || 0) + ((t2 && t2.val) || 0);
    node.left = mergeTrees((t1 && t1.left), (t2 && t2.left));
    node.right = mergeTrees((t1 && t1.right), (t2 && t2.right));
    return node;
};

const t1_3 = {
    val: 5,
    left: null,
    right: null
};

const t1_2 = {
    val: 2,
    left: null,
    right: null
};

const t1_1 = {
    val: 3,
    left: t1_3,
    right: null
};

const t1_0 = {
    val: 1,
    left: t1_1,
    right: t1_2
};

const t2_6 = {
    val: 7,
    left: null,
    right: null
};

const t2_4 = {
    val: 4,
    left: null,
    right: null
};

const t2_2 = {
    val: 3,
    left: null,
    right: t2_6
};

const t2_1 = {
    val: 1,
    left: null,
    right: t2_4
};

const t2_0 = {
    val: 2,
    left: t2_1,
    right: t2_2
};

const printTrees = (node) => {
    if (!node) {
        return;
    }
    console.log(node.val);
    printTrees(node.left);
    printTrees(node.right);
}

const merged = mergeTrees(t1_0, t2_0);
console.log(printTrees(merged));