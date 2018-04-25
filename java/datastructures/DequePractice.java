package datastructures;

public class DequePractice {
    public static void main(String args[]) {
        Deque deque = new Deque();
        deque.insertFront('C');
        deque.printDeque();

        deque.insertRear('D');
        deque.printDeque();

        deque.insertFront('B');
        deque.printDeque();

        deque.insertRear('E');
        deque.printDeque();

        deque.deleteFront();
        deque.printDeque();

        deque.deleteRear();
        deque.printDeque();
    }
}

class DQNode {
    char data;
    DQNode prev;
    DQNode next;
}

class Deque {
    DQNode front;
    DQNode rear;

    public Deque() {
        front = null;
        rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void insertFront(char data) {
        DQNode newNode = new DQNode();
        newNode.data = data;

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            front.prev = newNode;
            newNode.next = front;
            front = newNode;
        }
    }

    public void insertRear(char data) {
        DQNode newNode = new DQNode();
        newNode.data = data;

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }
    }

    public char deleteFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return 0;
        } else {
            char data = front.data;
            if (front.next == null) {
                front = null;
                rear = null;
            } else {
                front = front.next;
                front.prev = null;
            }
            return data;
        }
    }

    public char deleteRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return 0;
        } else {
            char data = rear.data;
            if (rear.prev == null) {
                front = null;
                rear = null;
            } else {
                rear = rear.prev;
                rear.next = null;
            }
            return data;
        }
    }

    public void removeFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
        } else {
            if (front.next == null) {
                front = null;
                rear = null;
            } else {
                front = front.next;
                front.prev = null;
            }
        }
    }

    public void removeRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
        } else {
            if (rear.prev == null) {
                front = null;
                rear = null;
            } else {
                rear = rear.prev;
                rear.next = null;
            }
        }
    }

    public char peekFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return 0;
        } else {
            return front.data;
        }
    }

    public char peekRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return 0;
        } else {
            return rear.data;
        }
    }

    public void printDeque() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
        } else {
            DQNode temp = front;
            System.out.print("Deque >> ");
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
}
