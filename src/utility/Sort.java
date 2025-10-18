package utility;

import java.util.Comparator;

public class Sort
{
	// 2 different versions for each sort as methods
	/**
	 * Bubble sort Algorithm
	 * repeatedly steps  through the array, compares adjacent elements,
	 * and swaps them if they are in the wrong order.
	 * @param <T>
	 * @param arr
	 */
	// Bubblesort taken from Lab 2 
	public static <T extends Comparable<T>> void bubbleSort(T[] arr)
	{
		if (arr == null || arr.length < 2)
			return;
		for (int pass = 0; pass < arr.length - 1; pass++)
		{
			for (int j = 0; j < arr.length - 1 - pass; j++)
			{
				if (arr[j].compareTo(arr[j+1]) > 0)
				{
					swap(arr, j, j + 1);
				}
			}
		}
	}
	

	public static <T> void bubbleSort(T[]arr, Comparator<T> c)
	{
		if (arr == null || arr.length < 2)
			return;
		for (int pass = 0; pass < arr.length - 1; pass++)
		{
	        for (int j = 0; j < arr.length - 1 - pass; j++)
	        {
	            if (c.compare(arr[j], arr[j + 1]) > 0) 
	            {
	                swap(arr, j, j + 1);
	            }
	        }
		}
	}
	/**
	 * Insertion Sort Algorithm
	 * Builds the sorted portion of the array one element at a time.
	 * each new element is compared with the sorted part and inserted into the correct position
	 * 
	 * @param <T>
	 * @param arr
	*/
	// Insertion sort
	public static <T extends Comparable<T>> void insertionSort(T[] arr)
	{
        if (arr == null || arr.length < 2) 
        	return;
        for (int i = 1; i < arr.length; i++) 
        {
            T key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(key) > 0) 
            {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
	}
	
	public static <T> void insertionSort(T[]arr, Comparator<T> c)
	{
        if (arr == null || arr.length < 2) 
        	return;
        for (int i = 1; i < arr.length; i++) 
        {
            T key = arr[i];
            int j = i - 1;
            while (j >= 0 && c.compare(arr[j], key) > 0) 
            {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
	}
	
	/**
	 * Selection Sort Algorithm
	 * finds the smallest (or largest) element in the unsorted portion of the array
	 * and swaps it with the first unsorted position
	 * 
	 * @param <T>
	 * @param arr
	*/
	// Selection sort
	public static <T extends Comparable<T>> void selectionSort(T[] arr)
	{
        if (arr == null || arr.length < 2) 
        	return;
        for (int i = 0; i < arr.length - 1; i++)
        {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) 
            {
                if (arr[j].compareTo(arr[minIndex]) < 0) 
                {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
	}
	
	public static <T> void selectionSort(T[]arr, Comparator<T> c)
	{
        if (arr == null || arr.length < 2) 
        	return;
        for (int i = 0; i < arr.length - 1; i++)
        {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++)
            {
                if (c.compare(arr[j], arr[minIndex]) < 0)
                {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
	}
	
	/**
	 * Merge Sort Algorithm
	 * Splits the array into halves, recursively sorts each half, 
	 * and then merges the sorted halves back together.
	 * 
	 * @param <T>
	 * @param arr
	*/
	// Merge sort
	public static <T extends Comparable<T>> void mergeSort(T[] arr)
	{
		if (arr == null || arr.length < 2)
			return;
		T[] left = (T[]) new Object[arr.length / 2];
		T[] right = (T[]) new Object[arr.length - left.length];
		
		// Divide array into two halves
		for (int i = 0; i < left.length; i++) left[i] = arr[i];
		for (int i = 0; i < right.length; i++) right[i] = arr[left.length + 1];
		
		// Recursively sort both halves
		mergeSort(left);
		mergeSort(right);
		
		//Merge the sorted halves
		int i = 0, j = 0, p = 0;
		while (i < left.length && j < right.length)
		{
			if (left[i].compareTo(right[j]) <= 0) arr[p++] = left[i++];
			else arr[p++] = right[j++];
		}
		while (i < left.length) arr[p++] = left[i++];
		while (j < left.length) arr[p++] = right[j++];
	}
	
	public static <T> void mergeSort(T[]arr, Comparator<T> c)
	{
		if (arr == null || arr.length < 2)
			return;
		T[] left = (T[]) new Object[arr.length / 2];
		T[] right = (T[]) new Object[arr.length - left.length];
		
		// Divide array into two halves
		for (int i = 0; i < left.length; i++) left[i] = arr[i];
		for (int i = 0; i < right.length; i++) right[i] = arr[left.length + 1];
		
		mergeSort(left, c);
		mergeSort(right, c);
		
		int i = 0, j = 0, p = 0;
		while (i < left.length && j < right.length)
		{
			if (c.compare(left[i], right[j]) <= 0) arr[p++] = left[i++];
			else arr[p++] = right[j++];
		}
		while (i < left.length) arr[p++] = left[i++];
		while (j < left.length) arr[p++] = right[j++];
	}
	
	/**
	 * Quick Sort Algorithm
	 * Selects a pivot element and partitions the array so that elements smaller than the pivot
	 * are on one side and larger elements are on the other.
	 * then it recursively sorts both sides
	 * 
	 * @param <T>
	 * @param arr
	*/
	// Quick sort
	public static <T extends Comparable<T>> void quickSort(T[] arr)
	{
		if ( arr == null || arr.length < 2)
			return;
		quickComparable(arr, 0, arr.length - 1);
	}
	
	private static <T extends Comparable<T>> void quickComparable(T[] arr, int low, int high)
	{
		if (low < high)
		{
			T pivot = arr[high];
			int i = low - 1;
			for (int j = low; j < high; j++)
			{
				if (arr[j].compareTo(pivot) <= 0)
				{
					i++;
					swap (arr, i, j);
				}
				
				swap (arr, i +1, high);
				int p = i +1; 
				
				quickComparable(arr, low, p -1);
				quickComparable(arr, p + 1, high);
			}
		}
		// TODO Auto-generated method stub
		
	}


	public static <T> void quickSort(T[]arr, Comparator<T> c)
	{
		if ( arr == null || arr.length < 2)
			return;
		quickComparator(arr, 0, arr.length - 1, c);
	}
	
	private static <T> void quickComparator(T[] arr, int low, int high, Comparator<T> c)
	{
		if (low < high)
		{
			T pivot = arr[high];
			int i = low - 1;
			for (int j = low; j < high; j++)
			{
				if (c.compare(arr[j], pivot) <= 0)
				{
					i++;
					swap (arr, i, j);
				}
				
				swap (arr, i +1, high);
				int p = i +1; 
				
				quickComparator(arr, low, p -1, c);
				quickComparator(arr, p + 1, high, c);
			}
		}
			// TODO Auto-generated method stub
			
	}
	
	/**
	 * Heap Sort Algorithm
	 * Builds a max-heap from the array and repeatedly swaps the root (largest value)
	 * with the last element in the heap, then reduces the heap size and restores heap order.
	 * 
	 * @param <T>
	 * @param arr
	*/
	// Heap sort
	public static <T extends Comparable<T>> void heapSort(T[] arr)
	{
		if (arr == null || arr.length < 2)
			return;
		int n = arr.length;
		//Build max heap
		for (int start = n / 2 - 1; start <= 0; start--)
		{
			int i = start;
			while (true)
			{
				int left = 2 * i + 1;
				int right = left + 1;
				int largest = i;
				
				if(left < n && arr[left].compareTo(arr[largest]) > 0)
					largest = left;
				if(right < n && arr[right].compareTo(arr[largest]) > 0)
					largest = right;
				if(largest == i)
					break;
				
				swap(arr, i, largest);
				i = largest;
			}
		}
		
		//Extract max to end and re-sift
		
		for(int end = n - 1; end > 0; end--)
		{
			swap(arr, 0, end);
			int size = end;
			int i = 0;
			while(true)
			{
				int left = 2 * i + 1;
				int right = left + 1;
				int largest = i;
				
				if (left < size && arr[left].compareTo(arr[largest]) > 0)
					largest = left;
				if(right < size && arr[right].compareTo(arr[largest]) > 0)
					largest = right;
				if (largest == i)
					break;
				
				swap(arr, i, largest);
				i = largest;
			}
		}
		
	}

	public static <T> void heapSort(T[]arr, Comparator<T> c)
	{
		if (arr == null || arr.length < 2)
			return;
		int n = arr.length;
		
		for (int start = n / 2 - 1; start <= 0; start--)
		{
			int i = start;
			while (true)
			{
				int left = 2 * i + 1;
				int right = left + 1;
				int largest = i;
				
				if(left < n && c.compare(arr[left], arr[largest]) > 0)
					largest = left;
				if(left < n && c.compare(arr[right], arr[largest]) > 0)
					largest = right;
				if (largest == i )
					break;
				
				swap(arr, i, largest);
				i = largest;
				
			}
		}
		
		for(int end = n - 1; end > 0; end--)
		{
			swap(arr, 0, end);
			int size = end;
			int i = 0;
			while(true)
			{
				int left = 2 * i + 1;
				int right = left + 1;
				int largest = i;
				
				
				if(left < size && c.compare(arr[left], arr[largest]) > 0)
					largest = left;
				if(left < size && c.compare(arr[right], arr[largest]) > 0)
					largest = right;
				if (largest == i )
					break;
				
				swap(arr, i, largest);
				i = largest;
			}
		}
	}

// Helper method to save time for swapping in sorts
private static <T> void swap(T[] arr, int j, int i)
{
	T temp = arr[i];
	arr[i] = arr [j];
	arr[j] = temp;
}
}