package com.sorting;

public class InsertionSort {

	private static int[] insertionSort(int[] arr) {
		int n = arr.length;
		
		for(int i = 1; i < n; i++) {//n-1 times
			int j = i - 1;// here Gap is 1 like shell short
			int x = arr[i];
			while(j > -1 && arr[j] > x) { //n * k times
				//shift and insert
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j+1] = x;
		}
		return arr;
	}
	
public static void main(String[] args) {
		
		int[] arr = {8,5,3,7,6,2};
		
		System.out.print("Array before Insertion sort  :: ");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(" "+arr[i]);
		}
		
		arr = insertionSort(arr);
		
		System.out.print("\n Array after Insertion sort  :: ");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(" "+arr[i]);
		}

	}

}
