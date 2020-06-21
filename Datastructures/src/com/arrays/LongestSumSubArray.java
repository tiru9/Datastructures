package com.arrays;

public class LongestSumSubArray {

 //Find sum 0f 15 longest sub array
 public static void main(String args[]) {
	int arr[] = {1,2,3,4,5,0,0,0,6,7,8,9,10};
	 //int arr[] = {1,2,3,7,5};
	 longestSubArrayBySum(arr);
 }

private static void longestSubArrayBySum(int[] arr) {
	int range[] = {-1, -1};
	int start = 0;int end = 0;
	int cur_sum = 0;
	final int SUM = 15;
	for(int i = 0; i< arr.length;i++) {
		if(cur_sum < SUM) {
			cur_sum = cur_sum+arr[end];
			end++;
		}
		if(cur_sum > SUM) {
			cur_sum = cur_sum - arr[start];
			start++;
		}
		if(cur_sum == SUM) {
			cur_sum = cur_sum+arr[end];
			if((range[1] - range[0]) < (end - start)) {
				range[0] = start;
			    range[1] = end - 1;	
			}
			end++;
		}
	}
	System.out.println("index range of longest sub array by sum : " +range[0]+","+range[1]);
}
}
