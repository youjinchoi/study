public class SortPractice {

    public static void main(String args[]) {
        int[] arr = {3, 8, 1, 5};

        //bubbleSort(arr);
        //selectionSort(arr);
        //insertionSort(arr);
        mergeSort(arr);
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /*
    * Time Complexity: O(n^2)
    * */
    public static void bubbleSort(int[] arr) {
        for (int i=arr.length-1; i>0; i--) {
            for (int j=0; j<i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    /*
    * Time Complexity: O(n^2)
    * */
    public static void selectionSort(int[] arr) {
        for (int i=0; i<arr.length-1; i++) {
            int minIndex = i;
            for (int j=i+1; j<arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    /*
    * Time Complexity: O(n^2)
    * */
    public static void insertionSort(int[] arr) {
        int i, j, dataToInsert;
        for (i=1; i<arr.length; i++) {
            dataToInsert = arr[i];
            for (j=i-1; j>=0; j--) {
                if (arr[j] > dataToInsert) {
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j+1] = dataToInsert;
        }
    }

    /*
    * Time Complexity: O(nlog(2)(n))
    * */
    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length-1);
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            conquer(arr, left, mid, right);
        }
    }

    public static void conquer(int[] arr, int left, int mid, int right) {
        int leftIndex = left;
        int rightIndex = mid+1;

        int[] sortedArr = new int[right+1];
        int index = left;
        while(leftIndex <= mid && rightIndex <= right) {
            if (arr[leftIndex] < arr[rightIndex]) {
                sortedArr[index] = arr[leftIndex];
                leftIndex++;
            } else {
                sortedArr[index] = arr[rightIndex];
                rightIndex++;
            }
            index++;
        }

        while (leftIndex <= mid) {
            sortedArr[index] = arr[leftIndex];
            index++;
            leftIndex++;
        }

        while (rightIndex <= right) {
            sortedArr[index] = arr[rightIndex];
            index++;
            rightIndex++;
        }

        for (int i=0; i<arr.length; i++) {
            if (i >= left && i <= right) {
                arr[i] = sortedArr[i];
            }
        }
    }

    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
    }

    public void quickSort(int[] arr, int left, int right) {
        int pivot = partition(arr, 0, arr.length-1);
        quickSort(arr, left, pivot-1);
        quickSort(arr, pivot+1, right);
    }

    public int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int low = left+1;
        int high = right;

        while(low <= high) {
            while(pivot >= arr[low] && low <= right) {
                low++;
            }

            while(pivot <= arr[high] && high >= left+1) {
                high--;
            }

            if (low <= high) {
                swap(arr, low, high);
            }
        }
        swap(arr, left, high);
        return high;
    }

    public void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
