package hackerrank;

import java.util.ArrayList;

public class DataStructures_LinkedList {
    public static void main(String[] args) {


    }

    class Node {
        int data;
        Node next;
    }

    /**
     * Print the Elements of a Linked List
     * https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list/problem
     */
    void Print(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.data);
        Print(head.next);
    }
    /**
     * Insert a Node at the Tail of a Linked List
     * https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list/problem
     */
    Node Insert(Node head,int data) {
        if (head == null) {
            head = new Node();
            head.data = data;
            return head;
        }

        Node node = head;
        while(true) {
            if (node.next == null) {
                break;
            } else {
                node = node.next;
            }
        }

        Node tail = new Node();
        tail.data = data;
        node.next = tail;
        return head;
    }

    /**
     * Insert a node at the head of a linked list
     * https://www.hackerrank.com/challenges/insert-a-node-at-the-head-of-a-linked-list/problem
     */
    Node InsertHead(Node head,int x) {
        Node node = new Node();
        node.data = x;
        node.next = head;
        return node;
    }

    /**
     * Insert a node at a specific position in a linked list
     * https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem
     */
    Node InsertNth(Node head, int data, int position) {
        if (position == 0) {
            Node newNode = new Node();
            newNode.data = data;
            newNode.next = head;
            return newNode;
        }

        Node previous = null;
        Node current = head;
        for (int i=1; i<=position; i++) {
            previous = current;
            current = current.next;
        }
        Node newNode = new Node();
        newNode.data = data;
        previous.next = newNode;
        newNode.next = current;
        return head;
    }

    /**
     * Delete a Node
     * https://www.hackerrank.com/challenges/delete-a-node-from-a-linked-list/problem
     */
    Node Delete(Node head, int position) {
        Node previous = null;
        Node current = head;
        if (position == 0) {
            Node newHead = head.next;
            head.next = null;
            return newHead;
        }

        for (int i=0; i<position; i++) {
            previous = current;
            current = current.next;
        }

        previous.next = current.next;
        current.next = null;
        return head;
    }

    /**
     * Print in Reverse
     * https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list-in-reverse/problem
     */
    void ReversePrint(Node head) {
        if (head == null) {
            return;
        }

        ArrayList<Integer> list = new ArrayList<>();
        Node node = head;
        while(node != null) {
            list.add(node.data);
            node = node.next;
        }

        int size = list.size();
        for (int i=size-1; i>=0; i--) {
            System.out.println(list.get(i));
        }

        /*if (head != null) {
            ReversePrint(head.next);
            System.out.println(head.data);
        }*/
    }

    /**
     * Reverse a linked list
     * https://www.hackerrank.com/challenges/reverse-a-linked-list/problem
     */
    Node Reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node previous = null;
        Node current = head;
        Node next = head.next;

        while(next != null) {
            Node temp = next.next;
            next.next = current;
            current.next = previous;

            previous = current;
            current = next;
            next = temp;
        }

        return current;
    }

    /**
     * Compare two linked lists
     * https://www.hackerrank.com/challenges/compare-two-linked-lists/problem
     */
    int CompareLists(Node headA, Node headB) {
        Node a = headA, b = headB;
        while(a != null && b != null) {
            if (a.data != b.data) {
                return 0;
            }
            a = a.next;
            b = b.next;
        }

        if (a != null || b != null) {
            return 0;
        }

        return 1;
    }

    /**
     * Merge two sorted linked lists
     * https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem
     */
    Node mergeLists(Node headA, Node headB) {
        if (headA == null) {
            return headB;
        }

        if (headB == null) {
            return headA;
        }

        Node newHead, a, b;
        if (headA.data < headB.data) {
            newHead = headA;
            a = headA.next;
            b = headB;
        } else {
            newHead = headB;
            a = headA;
            b = headB.next;
        }
        Node node = newHead;    // node = 1, a = 3, b = 2;
        while(a != null || b != null) {
            if (a == null) {
                node.next = b;
                b = b.next;
            } else if (b == null) {
                node.next = a;
                a = a.next;
            } else {
                if (a.data < b.data) {
                    node.next = a;
                    a = a.next;
                } else {
                    node.next = b;
                    b = b.next;
                }
            }
            node = node.next;
        }
        return newHead;
    }

    /**
     * Get Node Value
     * https://www.hackerrank.com/challenges/get-the-value-of-the-node-at-a-specific-position-from-the-tail/problem
     */
    int GetNode(Node head,int n) {
        Node node = head;
        ArrayList<Integer> list = new ArrayList<>();

        while (node != null) {
            list.add(node.data);
            node = node.next;
        }

        return list.get(list.size() - 1 - n);
    }

    /**
     * Delete duplicate-value nodes from a sorted linked list
     * https://www.hackerrank.com/challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list/problem
     */
    Node RemoveDuplicates(Node head) {
        if (head == null) {
            return null;
        }

        Node node = head;
        while (node != null) {
            if (node.next != null && node.data == node.next.data) {
                node.next = node.next.next;

            }  else {
                node = node.next;
            }
        }
        return head;
    }

    /**
     * Find Merge Point of Two Lists
     * https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists/problem
     */
    int FindMergeNode(Node headA, Node headB) {
        Node a = headA, b = headB;
        while(a != b) {
            if (a.next == null) {
                a = headB;
            } else {
                a = a.next;
            }

            if (b.next == null) {
                b = headA;
            } else {
                b = b.next;
            }
        }

        return a.data;
    }

    class DNode {
        int data;
        DNode next;
        DNode prev;
    }

    /**
     * Inserting a Node Into a Sorted Doubly Linked List
     * https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list/problem
     */
    DNode SortedInsert(DNode head,int data) {
        return null;
    }
}


