package com.sorting;

import java.util.Arrays;

class IterativeMergeSort
{
	// Merge two sorted sub-arrays arr[from .. mid] and arr[mid + 1 .. to]
	public static void merge(int[] arr, int[] temp, int from, int mid, int to)
	{
		int k = from, i = from, j = mid + 1;

		// loop till there are elements in the left and right runs
		while (i <= mid && j <= to) {
			if (arr[i] < arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}

		// Copy remaining elements
		while (i < arr.length && i <= mid) {
			temp[k++] = arr[i++];
		}
		// copy back to the original array to reflect sorted order
		for (i = from; i <= to; i++) {
			arr[i] = temp[i];
		}
	}

	// Iteratively sort array arr[low..high] using temporary array
	public static void mergesort(int[] arr)
	{
		int low = 0;
		int high = arr.length - 1;

		// sort array arr[] using temporary array temp
		int[] temp = Arrays.copyOf(arr, arr.length);

		// divide the array into blocks of size m
		for (int m = 1; m <= high - low; m = 2*m)//partitioning loop
		{
			
			for (int i = low; i < high; i += 2*m)
			{
				int from = i;
				int mid = i + m - 1;
				int to = Integer.min(i + 2 * m - 1, high);

				merge(arr, temp, from, mid, to); //sort and merge partitions.
			}
		}
	}
	
	// Iterative Implementation of Mergesort algorithm
	public static void main(String[] args)
	{
		int[] arr = { 5, 7, -9, 3, -4, 2, 8 };

		System.out.println("Original Array : " + Arrays.toString(arr));
		mergesort(arr);
		System.out.println("Modified Array : " + Arrays.toString(arr));
	}
}