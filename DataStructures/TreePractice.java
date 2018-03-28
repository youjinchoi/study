public class TreePractice {
    public static void main(String args[]) {
        LinkedTree tree = new LinkedTree();
        TreeNode d = tree.makeBT(null, 'D', null);
        TreeNode c = tree.makeBT(null, 'C', null);
        TreeNode b = tree.makeBT(null, 'B', null);
        TreeNode a = tree.makeBT(null, 'A', null);
        TreeNode slash = tree.makeBT(c, '/', d);
        TreeNode star = tree.makeBT(a, '*', b);
        TreeNode dash = tree.makeBT(star, '-', slash);

        System.out.print("Preorder : ");
        tree.preorder(dash);
        System.out.println();

        System.out.print("Inorder : ");
        tree.inorder(dash);
        System.out.println();

        System.out.print("Postorder : ");
        tree.postorder(dash);
        System.out.println();
    }
}

class TreeNode {
    char data;
    TreeNode left;
    TreeNode right;
}

class LinkedTree {
    private TreeNode root;

    public TreeNode makeBT(TreeNode left, char data, TreeNode right) {
        root = new TreeNode();
        root.data = data;
        root.left = left;
        root.right = right;
        return root;
    }

    public void preorder(TreeNode root) {
        if (root == null) {
            return;
        } else {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        } else {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public void postorder(TreeNode root) {
        if (root == null) {
            return;
        } else {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }
}

class BinarySearchTree {
    private TreeNode root = new TreeNode();

    public TreeNode insertKey(TreeNode root, char data) {
        TreeNode p = root;
        TreeNode newNode = new TreeNode();
        newNode.data = data;
        newNode.left = null;
        newNode.right = null;

        if (p == null) {
            return newNode;
        } else if (newNode.data < p.data) {
            p.left = insertKey(p.left, data);
            return p;
        } else if (newNode.data > p.data) {
            p.right = insertKey(p.right, data);
            return p;
        } else {
            return p;
        }
    }

    public void insertBST(char data) {
        root = insertKey(root, data);
    }

    public TreeNode searchBST(char data) {
        TreeNode p = root;
        while(p != null) {
            if (data < p.data) {
                p = p.left;
            } else if (data > p.data) {
                p = p.right;
            } else {
                return p;
            }
        }
        return p;
    }

    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public void printBST() {
        inorder(root);
        System.out.println();
    }
}
