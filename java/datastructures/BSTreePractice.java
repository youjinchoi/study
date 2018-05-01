package datastructures;

public class BSTreePractice {
    public static void main(String[] args) {
        BSTree bsTree = new BSTree();
        bsTree.insert(5);
        bsTree.insert(1);
        bsTree.insert(7);
        bsTree.insert(3);
        bsTree.insert(6);

        bsTree.inorderTraverse();
        System.out.println();

        bsTree.delete(6);
        bsTree.inorderTraverse();
        System.out.println();

        System.out.println(bsTree.search(5).data);
    }
}

class BSTree {
    class Node {
        int data;
        Node left;
        Node right;
    }
    Node root;

    Node search(int data) {
        return search(root, data);
    }

    Node search(Node root, int data) {
        if (root == null || root.data == data) {
            return root;
        }
        if (root.data > data) {
            return search(root.left, data);
        } else {
            return search(root.right, data);
        }
    }

    void insert(int data) {
        root = insert(root, data);
    }

    Node insert(Node parent, int data) {
        if (parent == null) {
            parent = new Node();
            parent.data = data;
            return parent;
        }

        if (data == parent.data) {
            return parent;
        }

        if (data < parent.data) {
            parent.left = insert(parent.left, data);
        } else {
            parent.right = insert(parent.right, data);
        }
        return parent;
    }

    void delete(int data) {
        root = delete(root, data);
    }

    Node delete(Node parent, int data) {
        if (parent == null) {
            return null;
        }

        if (data < parent.data) {
            parent.left = delete(parent.left, data);
        } else if (parent.data < data){
            parent.right = delete(parent.right, data);
        } else {
            if (parent.left == null && parent.right == null) {
                return null;
            } else if (parent.left == null) {
                return parent.right;
            } else if (parent.right == null) {
                return parent.left;
            } else {
                parent.data = findMin(parent.right);
                parent.right = delete(parent.right, parent.data);
            }

        }
        return parent;
    }

    int findMin(Node parent) {
        int min = parent.data;
        while(parent.left != null) {
            min = parent.left.data;
            parent = parent.left;
        }
        return min;
    }

    void inorderTraverse() {
        inorderTraverse(root);
    }

    void inorderTraverse(Node node) {
        if (node == null) {
            return;
        }
        inorderTraverse(node.left);
        System.out.print(node.data + " ");
        inorderTraverse(node.right);
    }
}
