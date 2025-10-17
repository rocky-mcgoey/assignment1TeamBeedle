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
	
	
	
// helper method to save time for swapping
private static <T> void swap(T[] arr, int j, int i)
{
	T temp = arr[i];
	arr[i] = arr [j];
	arr[j] = temp;
}
}