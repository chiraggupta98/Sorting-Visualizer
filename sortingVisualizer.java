    import java.util.Arrays;

    public class sortingVisualizer {

        // Bubble Sort
        public static void bubbleSort(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                boolean flag = true;
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        swap(arr, j, j + 1);
                        flag = false;
                    }
                    printArray(arr);
                }
                if(flag == true){
                    break;
                }
            }
        }

        // Insertion Sort
        public static void insertionSort(int[] arr) {
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                    printArray(arr);
                }
                arr[j + 1] = key;
                printArray(arr);
            }
        }

        // Selection Sort
        public static void selectionSort(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;
                    }
                }
                swap(arr, i, minIndex);
                printArray(arr);
            }
        }

        // Merge Sort
        public static void mergeSort(int[] arr, int lb, int ub) {
            if (lb < ub) {
                int mid = (lb + ub) / 2;
                mergeSort(arr, lb, mid);
                mergeSort(arr, mid + 1, ub);
                merge(arr, lb, mid, ub);
                printArray(arr);
            }
        }

        private static void merge(int[] arr, int lb, int mid, int ub) {
            int n1 = mid - lb + 1;
            int n2 = ub - mid; 

            int[] leftArr = new int[n1];
            int[] rightArr = new int[n2];

            for (int i = 0; i < n1; i++) leftArr[i] = arr[lb + i];
            for (int i = 0; i < n2; i++) rightArr[i] = arr[mid + 1 + i];

            int i = 0, j = 0, k = lb;
            while (i < n1 && j < n2) {
                if (leftArr[i] <= rightArr[j]) {
                    arr[k++] = leftArr[i++];
                } else {
                    arr[k++] = rightArr[j++];
                }
            }

            while (i < n1) arr[k++] = leftArr[i++];
            while (j < n2) arr[k++] = rightArr[j++];
        }

        // Swap function
        private static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        // Print array
        private static void printArray(int[] arr) {
            System.out.println(Arrays.toString(arr));
        }

        public static void main(String[] args) {
            int[] arr = {5, 3, 8, 6, 2};

            System.out.println("Original Array: " + Arrays.toString(arr));

            System.out.println("\nBubble Sort:");
            bubbleSort(arr);
            System.out.println("Sorted Array: " + Arrays.toString(arr));

            // Reset array for next sort
            arr = new int[]{5, 3, 8, 6, 2};

            System.out.println("\nInsertion Sort:");
            insertionSort(arr);
            System.out.println("Sorted Array: " + Arrays.toString(arr));

            arr = new int[]{5, 3, 8, 6, 2};

            System.out.println("\nSelection Sort:");
            selectionSort(arr);
            System.out.println("Sorted Array: " + Arrays.toString(arr));

            arr = new int[]{5, 3, 8, 6, 2};

            System.out.println("\nMerge Sort:");
            mergeSort(arr, 0, arr.length - 1);
            System.out.println("Sorted Array: " + Arrays.toString(arr));
        }
    }
