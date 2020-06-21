package com.heap;

public class HeapCreation_Deletion {



	private static int[] insert(int[] arr, int n) {
		int i = n;
		int temp = arr[n];

		//for 2nd push/iteration only one swap should happen with parent hence  > 1 or no need to swap 1st child
		while(i > 1 && temp > arr[i/2]) {
			//parent is less swap it.
			arr[i] = arr[i/2];		
			arr[i/2] = temp;

			i = i/2;
		}
		arr[i] = temp;
		//System.out.println();System.out.println();
		//for(int j = 0; j < arr.length; j++) { System.out.print("\t"+arr[j]); }
		return arr;
	}

	private static int[] createMaxheap(int[] arr) {
		for(int i = 2; i < arr.length; i++) {//start insert from second element
			arr = insert(arr, i);
		}
		return arr;
	}

	private static int[] delete(int[] arr, int n) {
		// always deletion will be root element and move it to last index and re arrange
		int i, j, x;
		 n = n -1 ;
		x = arr[n];
		int val = arr[1];//deletion root node
		arr[1] = arr[n];
		arr[n] = val;
		
		i = 1; j = i * 2;
		//j - left child, j+1 right child.
		while(j <= n - 1) {
			if(j < n-1 && arr[j+1] > arr[j])
				j=j+1; //get greater of two childs.
			if(arr[i] < arr[j]){//if parent is less than child
				x=arr[i];
				arr[i]=arr[j];
				arr[j]=x;
				i=j;
				j=2*j;
			}
			else
				break; 
		}

		return arr;
	}

	public static void main(String args[]) {
		//Create max heap with given array input

		int arr[] = {0, 10, 20, 30, 25, 5,40, 35};
		//int arr[] = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17}; //insert 0 at begining

		arr = createMaxheap(arr);

		System.out.println("array after heapify");

		for(int i = 0; i < arr.length; i++) { System.out.print("\t"+arr[i]); }

		arr = delete(arr, arr.length);
		
		System.out.println("\n array after root deletion");
		for(int i = 0; i < arr.length; i++) { System.out.print("\t"+arr[i]); }
		
        arr = delete(arr, arr.length - 1);
		
		System.out.println("\n array after root deletion");
		for(int i = 0; i < arr.length; i++) { System.out.print("\t"+arr[i]); }

	}



}
