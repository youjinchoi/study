package hackerrank;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DataStructures_Tree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        TreeNode root = null;
        while(t-- > 0){
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }

    public static TreeNode insert(TreeNode root, int data) {
        if(root == null){
            return new TreeNode(data);
        }
        else {
            TreeNode cur;
            if(data <= root.data){
                cur = insert(root.left, data);
                root.left = cur;
            }
            else{
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    /**
     * Tree: Height of a Binary Tree
     * https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem
     */
    static int height(TreeNode root) {
        if (root == null) return 0;

        int left = 1 + height(root.left);
        int right = 1 + height(root.right);

        return left > right ? left:right;
    }

    /**
     * Tree : Top View
     * https://www.hackerrank.com/challenges/tree-top-view/problem
     */
    static void topView(TreeNode root) {
        if (root == null) {
            return;
        }

        leftView(root.left);
        System.out.print(root.data + " ");
        rightView(root.right);
    }

    static void leftView(TreeNode node) {
        if (node == null) {
            return;
        }

        leftView(node.left);
        System.out.print(node.data + " ");
    }

    static void rightView(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        rightView(node.right);
    }

    /**
     * Tree: Level Order Traversal
     * https://www.hackerrank.com/challenges/tree-level-order-traversal/problem
     */
    static void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.data + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    /**
     * Binary Search Tree : Insertion
     * https://www.hackerrank.com/challenges/binary-search-tree-insertion/problem
     */
    static TreeNode Insert(TreeNode root, int value) {
        TreeNode newNode = new TreeNode();
        newNode.data = value;

        if (root == null) {
            root = newNode;
            return root;
        }
        TreeNode node = root;
        while(true) {
            if (node.data < value) {
                if (node.right != null) {
                    node = node.right;
                } else {
                    node.right = newNode;
                    break;
                }
            } else {
                if (node.left != null) {
                    node = node.left;
                } else {
                    node.left = newNode;
                    break;
                }
            }

        }

        return root;
    }

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int data) {
            this.data = data;
        }
    }

    /**
     * Binary Search Tree : Lowest Common Ancestor
     * https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/problem
     */
    static Node lca(Node root,int v1,int v2) {
        Node temp = root; // not necessary, just use root, just a leftover from a different attempt.

        while (true) {
            if (temp.data > v1 && temp.data > v2) {
                temp = temp.left;
            } else if (temp.data < v1 && temp.data < v2) {
                temp = temp.right;
            } else {
                return temp;
            }
        }
    }

    static class Node {
        int data;
        Node left;
        Node right;
    }
}