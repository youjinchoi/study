public class StackPractice {
    public static void main(String args[]) {
        ArrayStack stack = new ArrayStack(5);
        //LinkedStack stack = new LinkedStack();

        stack.push('A');
        stack.printStack();

        stack.push('B');
        stack.printStack();

        stack.push('C');
        stack.printStack();

        stack.push('D');
        stack.printStack();

        stack.push('E');
        stack.printStack();

        stack.push('F');
        stack.printStack();

        char deleted = stack.pop();
        stack.printStack();

        stack.pop();
        stack.printStack();

        stack.pop();
        stack.printStack();

        stack.pop();
        stack.printStack();

        stack.pop();
        stack.printStack();
    }
}

interface Stack {
    boolean isEmpty();
    void push(char data);
    char pop();
    void delete();
    char peek();
}

class ArrayStack implements Stack {
    public int top;
    public int size;
    public char[] array;

    public ArrayStack(int size) {
        this.top = -1;
        this.size = size;
        this.array = new char[size];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == this.size -1;
    }

    public void push(char data) {
        if (this.isFull()) {
            System.out.println("ArrayStack is full.");
        } else {
            array[++this.top] = data;
        }
    }

    public char pop() {
        if (this.isEmpty()) {
            return 0;
        } else {
            return array[this.top--];
        }
    }

    public void delete() {
        if (this.isEmpty()) {
            return;
        } else {
            this.top--;
        }
    }

    public char peek() {
        if (this.isEmpty()) {
            return 0;
        } else {
            return array[top];
        }
    }

    public void printStack() {
        if (this.isEmpty()) {
            System.out.println("ArrayStack is empty.");
        } else {
            System.out.print("ArrayStack >> ");
            for (int i=0; i<=top; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println("");
        }
    }
}

class StackNode {
    public char data;
    public StackNode below;
}

class LinkedStack implements Stack {
    private StackNode top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(char data) {
        StackNode newNode = new StackNode();
        newNode.data = data;
        newNode.below = this.top;
        this.top = newNode;
    }

    public char pop() {
        if (this.isEmpty()) {
            System.out.println("LinkedStack is empty.");
            return 0;
        } else {
            char data = this.top.data;
            this.top = top.below;
            return data;
        }
    }

    public void delete() {
        if (this.isEmpty()) {
            System.out.println("LinkedStack is empty.");
        } else {
            this.top = top.below;
        }
    }

    public char peek() {
        if (this.isEmpty()) {
            System.out.println("LinkedStack is empty.");
            return 0;
        } else {
            return this.top.data;
        }
    }

    public void printStack() {
        if (this.isEmpty()) {
            System.out.println("LinkedStack is empty.");
        } else {
            System.out.print("LinkedStack >> ");
            StackNode temp = this.top;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.below;
            }
            System.out.println();
        }
    }


}


