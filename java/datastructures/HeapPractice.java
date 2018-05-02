package datastructures;

public class HeapPractice {
    public static void main(String args[]) throws Exception {
        Heap h = new Heap(10);
        h.insert(1);
        h.insert(3);
        h.insert(8);
        h.insert(4);
        h.traverse();

        int data = h.delete();
        System.out.println(data);
        h.traverse();
    }
}

class Heap {
    int[] arr;
    int size;

    Heap(int length) {
        this.arr = new int[length];
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean isFull() {
        return size == arr.length;
    }

    void clear() {
        arr = null;
    }

    void insert(int data) throws Exception {
        if (isFull()) {
            throw new Exception("Heap is full.");
        } else {
            int index = size;
            arr[size] = data;
            size++;

            while (true) {
                int parentIndex = getParentIndex(index);
                if (parentIndex < 0 || arr[index] < arr[parentIndex]) {
                    break;
                }
                swap(arr, index, parentIndex);
            }
        }
    }

    int delete() throws Exception {
        if (isEmpty()) {
            throw new Exception("Heap is empty.");
        }

        int data = arr[0];
        int lastDataIndex = size - 1;
        int lastData = arr[lastDataIndex];
        arr[0] = lastData;
        arr[lastDataIndex] = 0;
        size--;
        fixRoot();
        return data;
    }

    void fixRoot() {
        int index = 0;
        while (true) {
            int leftChildIndex = getLeftChildIndex(index);
            int rightChildIndex = getRightChildIndex(index);
            if (arr[index] >= arr[leftChildIndex] && arr[index] >= arr[rightChildIndex]) {
                break;
            }
            if (arr[leftChildIndex] > arr[rightChildIndex]) {
                swap(arr, index, leftChildIndex);
                index = leftChildIndex;
            } else {
                swap(arr, index, rightChildIndex);
                index = rightChildIndex;
            }
        }
    }

    int getParentIndex(int index) {
        if (index == 0) {
            return -1;
        }
        return (index - 1) / 2;
    }

    int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }

    int getRightChildIndex(int index) {
        return index * 2 + 2;
    }

    void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    void traverse() {
        for (int data : arr) {
            if (data == 0) {
                continue;
            }
            System.out.print(data + " ");
        }
        System.out.println();
    }
}
