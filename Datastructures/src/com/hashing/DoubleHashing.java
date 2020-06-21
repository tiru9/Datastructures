package com.hashing;

import java.util.Arrays;

public class DoubleHashing {


	private static int doubleHashing(int val, int[] hash) {
		int h1=  val % 10;
		int h2=  7 - (val % 7);
		int i = 0;
		int indx = Math.abs((h1 + (i * h2)) % (hash.length));

		//System.out.println("Arranged elements in linear probing : "+Arrays.toString(hash));
		if(hash[indx] == -1)
			return indx;
		else {
			i++;
			while(hash[indx] != -1) {
				indx = Math.abs((h1 + (i * h2)) % (hash.length)); //some times index can give negative. Here while inserting 9
				i++;
			}
			return indx;
		}

	}


	private static void hashvalues(int[] val, int[] hash) {
		for(int i = 0; i < val.length; i++) {
			//int index = linearProbeFunc(val[i], hash);
			int index = doubleHashing(val[i], hash);
			hash[index] = val[i];
		}
	}

	private static void doubleHashSearch(int val, int[] hash) {
		boolean b = false;
		int h1=  val % 10;
		int h2=  7 - (val % 7);
		int i = 0;
		int indx = Math.abs((h1 + (i * h2)) % (hash.length));

		//System.out.println("Arranged elements in linear probing : "+Arrays.toString(hash));
		if(hash[indx] == -1)
			b = false;
		else {
			i++;
			while(hash[indx] != -1) {
				if(hash[indx] == val) {
					b = true;
					break;
				}else {
					indx = Math.abs((h1 + (i * h2)) % (hash.length)); //some times index can give negative. Here while inserting 9				
					i++;
				}
			}
		}
		
		if(b) System.out.println(val+" found at "+(indx)+"th bucket");
		else System.out.println(val+" Not found!");
	}


	public static void main(String[] args) {
		int val[] = {25, 24, 22, 43, 90, 45, 73, 19, 72, 9, 1};
		int hash[] = new int[17]; // load factor o.5 is recommended or size should be prime number

		//initialize hash default values to negative
		for(int i = 0; i < hash.length; i++) {
			hash[i] = -1;
		}

		hashvalues(val, hash);

		System.out.println("Arranged elements in linear probing : "+Arrays.toString(hash));

		doubleHashSearch(45, hash);
		doubleHashSearch(72, hash);
		doubleHashSearch(500, hash);
	}






}
