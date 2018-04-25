package datastructures;

/**
 * Created by youjin on 2018. 3. 29..
 */
public class HeapPractice {
    public static void main(String args[]) {

    }
}

class Heap {
    private int size;
    private int[] arr;

    public Heap() {
        size = 0;
        arr = new int[50];
    }

    public void insertHeap(int data) {
        int i = ++size;
        while(i != 1 && data > arr[i/2]) {
            arr[i] = data;

        }
    }
}
