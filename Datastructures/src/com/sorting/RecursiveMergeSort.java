package com.sorting;

import java.util.Arrays;

public class RecursiveMergeSort {

	private static void merge(int[] arr, int low, int mid, int high) {
			int k = low, i = low, j = mid + 1;
			int[] temp = Arrays.copyOf(arr, arr.length);
			// loop till there are elements in the left and right runs
			while (i <= mid && j <= high) {
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

			// don't need to copy second half
			// copy back to the original array to reflect sorted order
			for (i = low; i <= high; i++) {
				arr[i] = temp[i];
			}
		}
	
	
	private static void recursiveMergeSort(int[] arr, int low, int high) {
		
		int mid = (low + high)/2;
		
		while(low < mid) {
			recursiveMergeSort(arr, low, mid);//sort left
			recursiveMergeSort(arr, mid+1, high);//sort right
			merge(arr, low, mid, high);
			low++;
		}
		
	}

	public static void main(String[] args)
	{
		int[] arr = { 5, 7, -9, 3, -4, 2, 8 };

		System.out.println("Original Array : " + Arrays.toString(arr));
		recursiveMergeSort(arr, 0, arr.length -1);
		System.out.println("Modified Array : " + Arrays.toString(arr));
	}

	

}
