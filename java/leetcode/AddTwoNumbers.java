package leetcode;
/*
* https://leetcode.com/problems/add-two-numbers/
* 
* Definition for singly-linked list.
* public class ListNode {
*     int val;
*     ListNode next;
*     ListNode(int x) { val = x; }
* }
* 
* */
public class AddTwoNumbers {
	static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		long sum = convertToNum(l1) + convertToNum(l2);
		ListNode result = new ListNode((int)sum % 10);
		sum /= 10;
		
		ListNode current = result;
				
		while (sum > 0) {
			current.next = new ListNode((int)sum % 10);
			sum /= 10;
			current = current.next;
		}
		
		return result;
	}
	
	static long convertToNum(ListNode ln) {
		int powerOf = 0;
		int sum = 0;
		while (ln != null) {
			sum += ln.val * Math.pow(10, powerOf);
			powerOf++;
			ln = ln.next;
		}
		return sum;
	}
	
	static int getVal(ListNode ln) {
		return ln == null ? 0 : ln.val;
	}
	
	static ListNode getNext(ListNode ln) {
		return ln == null ? null : ln.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(9);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(9);
		l2.next.next = new ListNode(9);
		
		addTwoNumbers(l1, l2);
	}
}

class ListNode {
	 int val;
	 ListNode next;
	 ListNode(int x) { val = x; }
}