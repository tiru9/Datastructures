package com.hashing;

import java.util.Arrays;

public class LinearAndQuadraticProbing {

	private static int linearProbeFunc(int val, int[] hash){
		int j = 0;
		int idx = ((val) % 10) + j;

		if(hash[idx] == -1) {
			return idx;
		}else {
			while(j < hash.length && hash[idx] != -1) {//if filled move forward

				idx = ((val) % 10) + j;
				j++;
			}
			return idx;
		}
	}

	private static int quadraticProbeFunc(int val, int[] hash){
		int j = 0;
		int idx = ((val) % 10) + (j*j);

		if(hash[idx] == -1) {
			return idx;
		}else {
			while(j < hash.length && hash[idx] != -1) {//if filled move forward

				idx = ((val) % 10) + (j*j);
				j++;
			}
			return idx;
		}
	}

	private static void probeValues(int[] val, int[] hash) {
		for(int i = 0; i < val.length; i++) {
			//int index = linearProbeFunc(val[i], hash);
			int index = quadraticProbeFunc(val[i], hash);
			hash[index] = val[i];
		}

	}

	private static void searchlinearProbe(int val, int[] hash) {
		boolean b = false;
		int j = 0;
		while(!b && (j < hash.length)) {
			int current = hash[(val % 10) + j];
			if(current != -1 && (current == val)){
				b = true;
			}else if(current == -1) {
				b = false;
				break;
			}
			j++;
		}

		if(b) System.out.println(val+" found at "+((val % 10) +j - 1)+"th bucket");
		else System.out.println(val+" Not found!");

		//if we want to delete any element from hash, then we need to rehash i.e remove all elements and insert again using same hashing technique.
	}

	private static void searchQuadraticProbe(int val, int[] hash) {
		boolean b = false;
		int j = 0;
		while(!b && (j < hash.length)) {
			int current = hash[(val % 10) + (j * j)];
			if(current != -1 && (current == val)){
				b = true;
			}else if(current == -1) {
				b = false;
				break;
			}
			j++;
		}

		if(b) System.out.println(val+" found at "+((val % 10) +(j * j) - 1)+"th bucket");
		else System.out.println(val+" Not found!");

		//if we want to delete any element from hash, then we need to rehash i.e remove all elements and insert again using same hashing technique.
	}

	public static void main(String[] args) {
		int val[] = {25, 24, 22, 43, 90, 45, 73, 19, 72, 9, 1};
		int hash[] = new int[val.length * 2]; // load factor o.5 is recommended

		//initialize hash default values to negative
		for(int i = 0; i < hash.length; i++) {
			hash[i] = -1;
		}

		probeValues(val, hash);
		System.out.println("Arranged elements in linear probing : "+Arrays.toString(hash));

		//searchlinearProbe(19, hash);
		//searchlinearProbe(22, hash);

		searchQuadraticProbe(73, hash);
		searchQuadraticProbe(22, hash);
	}







}
