package datastructures;

public class LinkedListPractice {
	public static void main(String args[]) {
		LinkedList linkedList = new LinkedList();

		linkedList.insertNext("a");
		linkedList.insertNext("b");
		linkedList.insertNext("c");

		linkedList.deleteMiddle("b");

		linkedList.printList();
	}
}

class LinkedList {
	private Node head;

	public LinkedList() {
		this.head = null;
	}

	public void insertMiddle(Node pre, String data) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = pre.next;
		pre.next = newNode;
	}

	public void insertNext(String data) {
		Node newNode = new Node();
		newNode.data = data;
		if (this.head == null) {
			this.head = newNode;
		} else {
			Node temp = this.head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}

	public void deleteMiddle(String data) {
		if (this.head == null) {
			return;
		} else {
			Node before = head;
			Node current = head.next;
			while(current != null) {
				if (data == current.data) {
					Node after = current.next;
					before.next = after;
					return;
				}
				before = current;
				current = current.next;
			}
		}
	}

	public void deleteLast() {
		if (this.head == null) {
			return;
		}

		if (this.head.next == null) {
			this.head = null;
		} else {
			Node pre = this.head;
			Node temp = this.head.next;
			while(temp.next != null) {
				pre = temp;
				temp = temp.next;
			}
			pre.next = null;
		}

	}

	public Node search(String data) {
		Node temp = this.head;
		while (temp != null) {
			if (data.equals(temp.data)) {
				return temp;
			} else {
				temp = temp.next;
			}
		}
		return null;
	}

	public void reverseList() {
		Node after = head;
		Node current = null;
		Node before = null;

		while(after != null) {
			before = current;
			current = after;
			after = after.next;
			current.next = before;
		}

		head = current;
	}

	public void printList() {
		Node temp = this.head;
		System.out.print("L = (");
		while(temp != null) {
			System.out.print(temp.data);
			temp = temp.next;
			if (temp != null) {
				System.out.print(", ");
			}
		}
		System.out.println(")");
	}
}

class Node {
	public String data;
	public Node next;

	public String toString() {
		return "data: " + (this.data == null ? null : this.data) + ", next: " + (this.next == null ? null : this.next.data);
	}
}