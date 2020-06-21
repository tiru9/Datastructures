package com.sorting;

import java.util.Arrays;

public class RadixShort {

	static class Bucket{
		int data;
		Bucket next;
		Bucket(int data){
			this.data = data;
			this.next = null;
		}
	}

	private static int findMax(int[] arr) {
		int max = arr[0];
		int i = 1;
		while(i < arr.length) {
			if(max < arr[i])
				max = arr[i];
			i++;
		}
		return max;
	}

	private static int countDigits(int max) {
		int count = 0;
		while(max != 0) {
			max = max/10;
			count++;
		}
		return count;
	}

	private static void insert(Bucket[] rad, int val, int binIdx) {

		//insert to radix/bin
		Bucket temp = new Bucket(val);
		
			if(rad[binIdx] == null)
				rad[binIdx] = temp;
			else {
				while (rad[binIdx].next != null){
					rad[binIdx] = rad[binIdx].next;
		        }
				rad[binIdx].next = temp;
			}
		

	}

	private static int getBinIndex(int val, int pass) {
		return (int)(val / Math.pow(10, pass)) % 10;   //division by 10 for first pass, by 100 for second pass,....
	}

	private static void initializeBins(Bucket[] rad) {
		for (int i=0; i< rad.length; i++){
			rad[i] = null;
		}
	}
	
	private static void radixShort(int[] arr) {
		Bucket[] rad = new Bucket[10];//radix array length should be 10 for decimals, 2 for binaries, 8 for octal numbers
		int max = findMax(arr);
		int npasses = countDigits(max);

		for(int pass = 0; pass < npasses; pass++) {
			// Update bins based on arr values
			for (int i=0; i< arr.length; i++){
				int binIdx = getBinIndex(arr[i], pass);
				insert(rad, arr[i], binIdx);
			}

			// Update arr with sorted elements from bin/radix
			int i = 0;
			int j = 0;
			while (i < rad.length){
				while (rad[i] != null){
					arr[j++] = rad[i].data; 
					rad[i] = rad[i].next;
				}
				i++;
			}
			// Initialize bins with null again
			initializeBins(rad);
		}
	}
	
	public static void main(String[] args) {
		int[] arr= {999, 321,221,420,105,99};
		//System.out.println("original array : "+Arrays.toString(arr));
		radixShort(arr);
		System.out.println("  sorted array : "+Arrays.toString(arr));
	}



}
