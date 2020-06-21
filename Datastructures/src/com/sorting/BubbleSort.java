package com.sorting;

public class BubbleSort {
	
	private static int[] bubbleSort(int[] A, int n) {
		
		for(int i = 0; i < n-1; i++) {
			for(int j = 0; j < (n - 1 - i); j++) {
				if(A[j] < A[j+1]) {
					int temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
				}
			}
		}
		return A;
	}
	
	
	public static void main(String args[]) {
		int A[] = {8,5,7,3,2};
		
		A = bubbleSort(A, A.length);
		
		System.out.println("After Sorting.. :");
		for(int i = 0; i < A.length; i++) {
			System.out.print(A[i]+ " ");
		}
	}
}
