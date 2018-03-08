/*
 Node is defined as
 var Node = function(data) {
 this.data = data;
 this.left = null;
 this.right = null;
 }
 */

// This is a "method-only" submission.
// You only need to complete this method.

function postOrder(root) {
    if (!root) {
        return;
    }
    postOrder(root.left);
    postOrder(root.right);
    process.stdout.write(root.data + " ");
}