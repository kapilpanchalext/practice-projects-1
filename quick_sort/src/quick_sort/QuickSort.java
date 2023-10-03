package quick_sort;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuickSort {

	public static void main(String[] args) {
		
        int[] arr = new int[1000];
        Random rand = new Random();
        
        for (int i = 0; i < 1000; i++) {
            arr[i] = rand.nextInt(1000) + 1;
        }
		
//		int[] arr1 = {2,3,1,5};
        long startTime = System.nanoTime();
        quickSort(arr, 0, arr.length - 1);
        
        long quickSortTime = System.nanoTime() - startTime;
        System.err.println("Sorted array: " + Arrays.toString(arr));
//        
//        startTime = System.nanoTime();
//        bubbleSort(arr.clone());
//        long bubbleSortTime = System.nanoTime() - startTime;
// 
//        startTime = System.nanoTime();
//        selectionSort(arr.clone());
//        long selectionSortTime = System.nanoTime() - startTime;
// 
//        startTime = System.nanoTime();
//        insertionSort(arr.clone());
//        long insertionSortTime = System.nanoTime() - startTime;
// 
//        System.err.println("Bubble Sort time(ms): " + bubbleSortTime/1000000.0);
//        System.err.println("Selection Sort time(ms): " + selectionSortTime/1000000.0);
//        System.err.println("Insertion Sort time(ms): " + insertionSortTime/1000000.0);
        System.err.println("Quick Sort time(ms): " + quickSortTime/1000000.0);
        
        
        

	}
	
	public static void quickSort(int[] arr, int low, int high) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		CountDownLatch latch = new CountDownLatch(2);
		if (low < high) {
            // Partition the array, and get the pivot index
            int pivotIndex = partition(arr, low, high);
//            System.err.println("PIVOT INDEX: " + pivotIndex);
            
            // Recursively sort the two partitions
            
//            CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
//            	quickSort(arr, low, pivotIndex - 1);
////                System.err.println("Task 1 executed in thread: " + Thread.currentThread().getName());
//            });
//
//            CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
//            	quickSort(arr, pivotIndex + 1, high);
////                System.err.println("Task 2 executed in thread: " + Thread.currentThread().getName());
//            });
//
//            // Wait for both tasks to complete
//            CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2);
//            combinedFuture.join(); // Block until all tasks are completed
            
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    
    public static int partition(int[] arr, int low, int high) {
        // Choose the rightmost element as the pivot
        int pivot = arr[high];
        
        // Index of the smaller element
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            // If the current element is smaller than or equal to the pivot
//        	System.err.println("PARTITION: " + j);
            if (arr[j] <= pivot) {
                i++;
                
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        // Swap arr[i+1] and arr[high] (pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        return i + 1; // Return the pivot index
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
 
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
 
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }    
}