package com.tree;

import java.util.Stack;

public class GenerateBSTFromPreOrder {

	Node mainroot;

	public  void createBSTfromPreOrder(int[] pre) {
		Node root, p;
		Stack<Node> st = new Stack<Node>();
		int i = 0;

		root = new Node(pre[i++]); //important step
		p = root;
		mainroot = root;

		while(i < pre.length){
			if(pre[i] < p.data) {
				Node temp = new Node(pre[i++]);

				p.left = temp;
				st.push(p);
				p = temp;
			}else {
				if(pre[i] > p.data && (pre[i] < (st.isEmpty() ? 32768 : st.peek().data))) {
					Node temp = new Node(pre[i++]);
					p.right = temp;
				}else{
					p = st.peek();
					st.pop();
				}
			}

		}

	}

	public Node getRoot() {
		return mainroot;
	}
	
	public void traverseInOrder(Node node) {

		if (node != null) {
			traverseInOrder(node.left);
			System.out.print(" " + node.data);
			traverseInOrder(node.right);
		}
	}

	public static void main(String[] args) {
		int pre[] = {30,20,10,15,25,40,50,45};
		GenerateBSTFromPreOrder bst = new GenerateBSTFromPreOrder();
		bst.createBSTfromPreOrder(pre);
		System.out.println("In order : ");
		bst.traverseInOrder(bst.getRoot());
	}
}
