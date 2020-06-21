package com.sorting;

public class SelectionSort {


	private static int[] selectionSort(int[] arr) {

		
		
		for(int i = 0; i < arr.length; i++) {//i is selected position for each iteration
			
			int j = i; int k = j+1; int temp;
			
			while(k < arr.length) {
				if(arr[j] > arr[k]) {
					j = k; //point j to minimum
				}
				k++;
			}
			//Swap minimum with selected position
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			
			//shift for next selection position
			  j = i;
			  k = j+1;
			
		}
		return arr;
	}



	public static void main(String[] args) {
		int[] arr = {8,5,3,7,6,2};

		System.out.print("Array before selection sort  :: ");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(" "+arr[i]);
		}

		arr = selectionSort(arr);
		
		System.out.print("\n Array after selection sort  :: ");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(" "+arr[i]);
		}
	}



}
