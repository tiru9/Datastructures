package com.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {

	static class Node{
		Node left;
		Node right;
		int data;

		public Node(int value) {
			this.data = value;
			this.left = null;
			this.right= null;
		}
	}

	private Node root; 


	private Node addRecursive(Node current, int value) {
		if (current == null) {
			return new Node(value);
		}

		if (value < current.data) {
			current.left = addRecursive(current.left, value);
		} else if (value > current.data) {
			current.right = addRecursive(current.right, value);
		} else {
			// value already exists
			return current;
		}

		return current;
	}

	public void add(int value) {
		//first time add method pases root node only.
		this.root = addRecursive(this.root, value);
	}



	public Node getRoot() {
		return this.root;
	}

	public void traverseLevelOrder() {
		if (root == null) {
			return;
		}

		Queue<Node> nodes = new LinkedList<>();
		nodes.add(root);

		while (!nodes.isEmpty()) {

			Node node = nodes.remove();

			System.out.print(" " + node.data);

			if (node.left != null) {
				nodes.add(node.left);
			}

			if (node.right != null) {
				nodes.add(node.right);
			}
		}
	}

	public void traverseInOrder(Node node) {

		if (node != null) {
			traverseInOrder(node.left);
			System.out.print(" " + node.data);
			traverseInOrder(node.right);
		}
	}

	public void traversePostOrder(Node node) {
		if (node != null) {
			traversePostOrder(node.left);
			traversePostOrder(node.right);
			System.out.print(" " + node.data);
		}
	}

	public void traversePreOrder(Node node) {
		if (node != null) {
			System.out.print(" " + node.data);
			traversePreOrder(node.left);
			traversePreOrder(node.right);

		}
	}

	public int height(Node n) {
		int x =0; int y = 0;
		if(n == null)
			return 0;
		else {
			x = height(n.left);
			y = height(n.right);
			return x > y? x + 1: y+1;
		}
	}

	public Node inPred(Node n) {
		//Gives predecessor of a root in inorder traversal of a node
		if(n == null)
			return n;
		else {
			while(n.right != null) {
				n = n.right;
			}
			return n;
		}
	}

	public Node inSucc(Node n) {
		//Gives succesor of a root in inorder traversal of a node
		if(n == null)
			return n;
		else {
			while(n.left != null) {
				n = n.left;
			}
			return n;
		}
	}


	public static BinaryTree createBinaryTree() {
		BinaryTree bt = new BinaryTree();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of nodes to be inserted");
		int i = sc.nextInt();
		while(i != 0) {
			System.out.println("Enter value of "+(i - (i-1)) +"th node to be inserted");
			int val = sc.nextInt();
			bt.add(val);
			i--;
		}
		sc.close();
		return bt;

	}

	public Node search(Node root, int key) {
		if(root == null)
			return null;

		if(key == root.data)
			return root;
		if(key < root.data) {
			return search(root.left, key);
		}else {
			return search(root.right, key);
		}
	}

	/*
	 * public void deleteNode(Node daNode[]) {
	 * 
	 * if(daNode[0] != null) { if(daNode[1] == null && daNode[2] == null) { //delete
	 * node with no swaps daNode[0] = null; }else if(!(daNode[1] == null) &&
	 * !(daNode[2] == null)) { //swap nearest height one Node temp =
	 * height(daNode[1]) < height(daNode[2])? daNode[1] : daNode[2]; daNode[0].data
	 * = temp.data; if(temp == daNode[1]) daNode[1] = null; else daNode[2] = null;
	 * temp = null;
	 * 
	 * }else {//swap with non null node if((daNode[1] != null)) { Node temp =
	 * daNode[1]; daNode[0].data = temp.data; daNode[1] = null; temp = null; }else
	 * if(daNode[2] != null) { Node temp = daNode[2]; daNode[0].data = temp.data;
	 * daNode[2] = null; temp = null; } }
	 * 
	 * } }
	 */

	public Node delete(int value) {
		root = deleteRecursive(root, value);
		return root;
	}

	private Node deleteRecursive(Node current, int value) {

		if (current == null) {
			return null;
		}

		if (value == current.data) {
			// Node to delete found
			// ... code to delete the node will go here
			if (current.left == null && current.right == null) {
				return null;
			}

			//Now let's continue with the case when the node has one child:
			else if(current.right == null || current.left == null) {
				if (current.right == null) {
					return current.left; //replace with predecessor
				}

				if (current.left == null) {
					return current.right;//replace with successor
				}

			}else if(current.left != null && current.right != null) {
				int leftValue = height(current.left);
				int rightValue = height(current.right);
				
				Node temp = rightValue < leftValue? current.right : current.left;
				current = temp;
				current.right = deleteRecursive(current.right, current.data);
				return current;
			}

		} 

		if (value < current.data) {
			current.left = deleteRecursive(current.left, value);
			return current;
		}
		
		current.right = deleteRecursive(current.right, value);
		return current;
	}

	public static void main(String args[]) {
		BinaryTree  bt = createBinaryTree();

		//System.out.print("level order traversal : ");
		//bt.traverseLevelOrder();
		System.out.print("\n inOrder traversal : ");
		bt.traverseInOrder(bt.getRoot());
		//System.out.print("\n preOrder traversal : ");
		//bt.traversePreOrder(bt.getRoot());
		//System.out.print("\n postOrder traversal : ");
		//bt.traversePostOrder(bt.getRoot());

		//System.out.println("\n height of the root "+ bt.height(bt.getRoot()));
		System.out.println("\n is 30 ispresent : "+ (bt.search(bt.getRoot(), 30) != null));

		//Node dNode = bt.search(bt.getRoot(), 30);
		//Node daNode[] = {dNode, bt.inPred(dNode.left), bt.inSucc(dNode.right)};

		bt.root = bt.delete(30);

		System.out.print("\n inOrder traversal : ");
		bt.traverseInOrder(bt.getRoot());
	}
}
