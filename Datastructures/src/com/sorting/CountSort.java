package com.sorting;

public class CountSort {

	private static int findMAx(int[] arr) {
		int MAX = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++) {
			if(MAX < arr[i])
				MAX = arr[i];
		}
		return MAX;
	}

	private static int[] countSort(int[] arr) {

		int MAX = findMAx(arr);

		int cn[] = new int[MAX+1];

		for(int i = 0; i < MAX + 1; i++) {
			cn[i] = 0;
		}

		for(int i = 0; i < arr.length; i++) {
              cn[arr[i]]++;
		}
		
		int i = 0; int j = 0;
		
		while(j < MAX+1) {
			if(cn[j] > 0) {
				arr[i++] = j;
				cn[j]--;
			}else
				 j++;
		}
		return arr;
	}



	public static void main(String[] args) {
		int[] arr = {6,7,6,15,1,0,9,30,5,4,3,2,1,0,15,5};
		arr = countSort(arr);
		System.out.println(" After count sort :: ");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(" "+arr[i]);
		}
	}



}
