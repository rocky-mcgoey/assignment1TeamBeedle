package utility;

import java.util.Comparator;

public class Sort
{
	// 2 different versions for each sort as methods
	
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
	
	public static <T> void SelectionSort(T[]arr, Comparator<T> c)
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
	
// Helper method to save time for swapping in sorts
private static <T> void swap(T[] arr, int j, int i)
{
	T temp = arr[i];
	arr[i] = arr [j];
	arr[j] = temp;
}
}