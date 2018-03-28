/**
 * Created by youjin on 2018. 3. 24..
 */
public class QueuePractice {

    public static void main(String args[]) {
        //ArrayQueue queue = new ArrayQueue(5);
        ArrayCQueue queue = new ArrayCQueue(5);


        queue.enQueue('a');
        queue.enQueue('b');
        queue.enQueue('c');
        queue.enQueue('d');
        queue.enQueue('e');
        queue.printQueue();

        queue.deQueue();
        queue.printQueue();

        queue.deQueue();
        queue.printQueue();

        queue.deQueue();
        queue.printQueue();

        queue.deQueue();
        queue.printQueue();

        queue.deQueue();
        queue.printQueue();

    }
}

interface Queue {
    boolean isEmpty();
    void enQueue(char data);
    char deQueue();
    void delete();
}

class ArrayQueue implements Queue {
    private int front;
    private int rear;
    private int size;
    private char[] array;

    public ArrayQueue(int size) {
        this.front = -1;
        this.rear = -1;
        this.size = size;
        this.array = new char[size];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return rear == this.size -1;
    }

    public void enQueue(char data) {
        if (this.isFull()) {
            System.out.println("ArrayQueue is full.");
        } else {
            this.array[++rear] = data;
        }
    }

    public char deQueue() {
        if (this.isEmpty()) {
            System.out.println("ArrayQueue is empty.");
            return 0;
        } else {
            return array[++front];
        }
    }

    public void delete() {
        if (this.isEmpty()) {
            System.out.println("ArrayQueue is empty.");
        } else {
            ++front;
        }
    }

    public char peek() {
        if (this.isEmpty()) {
            System.out.println("ArrayQueue is empty.");
            return 0;
        } else {
            return array[front + 1];
        }
    }

    public void printQueue() {
        if (this.isEmpty()) {
            System.out.println("ArrayQueue is empty.");
        } else {
            System.out.print("ArrayQueue >> ");
            for (int i=front+1; i<=rear; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }
}


class ArrayCQueue implements Queue {
    private int front;
    private int rear;
    private int size;
    private char[] array;

    public ArrayCQueue(int size) {
        this.front = 0;
        this.rear = 0;
        this.size = size;
        this.array = new char[size];
    }

    public boolean isEmpty() {
        return this.front == this.rear;
    }

    public boolean isFull() {
        return (this.rear + 1) % this.size == this.front;
    }

    public void enQueue(char data) {
        if (this.isFull()) {
            System.out.println("ArrayCQueue is full.");
        } else {
            this.rear = (this.rear + 1) % this.size;
            array[this.rear] = data;
        }
    }

    public char deQueue() {
        if (this.isEmpty()) {
            System.out.println("ArrayCQueue is empty.");
            return 0;
        } else {
            this.front = (this.front + 1) % this.size;
            return this.array[this.front];
        }
    }

    public void delete() {
        if (this.isEmpty()) {
            System.out.println("ArrayCQueue is empty.");
        } else {
            this.front = (this.front + 1) % this.size;
        }
    }

    public char peek() {
        if (this.isEmpty()) {
            System.out.println("ArrayCQueue is empty.");
            return 0;
        } else {
            return this.array[(this.front + 1) % this.size];
        }
    }

    public void printQueue() {
        if (this.isEmpty()) {
            System.out.println("ArrayCQueue is empty.");
        } else {
            System.out.print("ArrayCQueue >> ");
            for (int i=(this.front + 1) % this.size; i!=(this.rear + 1) % this.size; i=++i % this.size) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }

}

class QNode {
    char data;
    QNode next;
}

class LinkedQueue implements Queue {
    QNode front;
    QNode rear;

    public LinkedQueue() {
        front = null;
        rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enQueue(char data) {
        QNode newNode = new QNode();
        newNode.data = data;

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public char deQueue() {
        if (isEmpty()) {
            System.out.println("LinkedQueue is empty.");
            return 0;
        } else {
            char data = front.data;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            return data;
        }
    }

    public void delete() {
        if (isEmpty()) {
            System.out.println("LinkedQueue is empty.");
        } else {
            front = front.next;
            if (front == null) {
                rear = null;
            }
        }
    }

    public char peek() {
        if (isEmpty()) {
            System.out.println("LinkedQueue is empty.");
            return 0;
        } else {
            return front.data;
        }
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("LinkedQueue is empty.");
        } else {
            QNode temp = front;
            System.out.print("LinkedQueue >> ");
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
}