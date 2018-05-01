package datastructures;

public class GraphPractice {
    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 8);
        //g.dfs();
        //g.bfs();
        g.dfsR();
    }
}

class Graph {
    class Node {
        int data;
        java.util.LinkedList<Node> adjacent;
        boolean marked;
        Node(int data) {
            this.data = data;
            this.marked = false;
            adjacent = new java.util.LinkedList<Node>();
        }
    }
    Node[] nodes;
    Graph(int size) {
        nodes = new Node[size];
        for (int i=0; i<size; i++) {
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }

    void dfs() {
        dfs(0);
    }

    void dfs(int index) {
        Node root = nodes[index];
        java.util.Stack<Node> stack = new java.util.Stack<Node>();
        stack.push(root);
        root.marked = true;
        while(!stack.isEmpty()) {
            Node r = stack.pop();
            for (Node n : r.adjacent) {
                if (!n.marked) {
                    n.marked = true;
                    stack.push(n);
                }
            }
            visit(r);
        }
    }

    void visit(Node n) {
        System.out.print(n.data + " ");
    }

    void bfs() {
        bfs(0);
    }

    void bfs(int index) {
        Node root = nodes[index];
        java.util.Queue<Node> queue = new java.util.LinkedList<Node>();
        queue.add(root);
        root.marked = true;
        while(!queue.isEmpty()) {
            Node r = queue.poll();
            for (Node n : r.adjacent) {
                if (!n.marked) {
                    n.marked = true;
                    queue.add(n);
                }
            }
            visit(r);
        }
    }

    void dfsR(Node r) {
        if (r == null) {
            return;
        }
        r.marked = true;
        visit(r);
        for (Node n : r.adjacent) {
            if (!n.marked) {
                dfsR(n);
            }
        }
    }

    void dfsR() {
        dfsR(0);
    }

    void dfsR(int index) {
        Node r = nodes[index];
        dfsR(r);
    }
}
