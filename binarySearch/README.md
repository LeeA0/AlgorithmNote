# 이진 트리(BinaryTree)

```java
package final_algo.data_structure;

class Tree{
	class Node{
		int data;
		Node left;
		Node right;
		Node (int data){
			this.data = data;
		}
	}
	Node root;
	public void makeTree(int[] a) {
		root = makeTreeR(a, 0, a.length -1);
	}
	
	public void seachBTree (Node n, int find) {
		if (find < n.data) {
			System.out.println("Data is smaller than " + n.data);
			seachBTree(n.left, find);
		}else if (find > n.data) {
			System.out.println("Data is bigger than " + n.data);
			seachBTree(n.right, find);
			
		}else {
			System.out.println("Data found!!");
		}
	}
	public Node makeTreeR(int[] a, int start, int end) {
		if(start > end) return null;
		int mid = (start + end) / 2;
		Node node = new Node(a[mid]);
		node.left = makeTreeR(a, start, mid - 1);
		node.right = makeTreeR(a,mid + 1, end);
		return node;
	}
}




public class BinaryTree {

	public static void main(String[] args) {
		int [] a = new int [10];
		for(int i = 0; i<a.length; i++) {
			a[i] = i;
		}
		
		Tree t = new Tree();
		t.makeTree(a);
		t.seachBTree(t.root, 2);
	}
}

```

![image](https://user-images.githubusercontent.com/70404643/107872563-822a1580-6eee-11eb-983b-7557f5113f18.png)

![image](https://user-images.githubusercontent.com/70404643/107872578-95d57c00-6eee-11eb-8731-0b6315b3672d.png)
