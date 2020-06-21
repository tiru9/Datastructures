package com.sorting;

import java.util.Arrays;

public class BucketOrBinSort {

	static class Bucket{
		int data;
		Bucket next;
		Bucket(int data){
			this.data = data;
			this.next = null;
		}
	}


	private static void bucketSort(int[] arr) {
		int max = findmax(arr);
		Bucket[] bin = new Bucket[max+1];

		//insert to buckets
		int j = 0;
		for(int i = 0; i < arr.length; i++) {
			if(bin[arr[i]] == null)
				bin[arr[i]] =  new Bucket(arr[i]);
			else{
				//create new bucket and swap/link with existing bucket 
				Bucket temp = bin[arr[i]];
				bin[arr[i]] = new Bucket(arr[i]);
				bin[arr[i]].next = temp;
			}
		}

		//now copy from bin/buckets to original array from left to right
		int m = 0; int n = 0;
		while(m < max) {
			while(bin[m] != null) {
				arr[n++] =  bin[m].data;
				bin[m] = bin[m].next;
			}
			m++;
		}

	}

	private static int findmax(int[] arr) {
		int x = arr[0];
		for(int i =1; i < arr.length; i++) {
			if(x < arr[i])
				x = arr[i];
		}
		return x;
	}

	public static void main(String[] args) {

		int[] arr = {10, 5, 5, 5, 7, 11, 12};

		System.out.println("Original Array : " + Arrays.toString(arr));
		bucketSort(arr);
		System.out.println(" Sorted Array : " + Arrays.toString(arr));

	}

	/*
	 * sortMixed(arr[], n)
		1) Split array into two parts 
		   create two Empty vector Neg[], Pos[] 
		   (for negative and positive element respectively)
		   Store all negative element in Neg[] by converting
		   into positive (Neg[i] = -1 * Arr[i] )
		   Store all +ve in pos[]  (pos[i] =  Arr[i])
		2) Call function bucketSortPositive(Pos, pos.size())
		   Call function bucketSortPositive(Neg, Neg.size())
	 * */

}
