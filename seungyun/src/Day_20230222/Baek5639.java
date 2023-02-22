package Day_20230222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek5639 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String treeNum;
		
		Node node = new Node(Integer.parseInt(br.readLine()));
		while(true) {
			treeNum = br.readLine();
			if(treeNum == null || treeNum.equals("")) {
				break;
			}
			node.insert(Integer.parseInt(treeNum));
		}
		postOrder(node);
	}
	public static void postOrder(Node node) {
		if(node != null) {
			if(node.left != null) {
				postOrder(node.left);
			}
			if(node.right != null) {
				postOrder(node.right);
			}
			System.out.println(node.root);
		}
	}
	
}
class Node{
	int root;
	Node left, right;
	
	public Node(int root) {
		this.root = root;
	}
	
	public Node(int root, Node left, Node right){
		this.root = root;
		this.left = left;
		this.right = right;
	}
	
	public void insert(int n) {
		if(this.root > n) {
			if(this.left == null) {
				this.left = new Node(n);
			} else {
				this.left.insert(n);
			}
		} else {
			if(this.right == null) {
				this.right = new Node(n);
			} else {
				this.right.insert(n);
			}
		}
	}
}
