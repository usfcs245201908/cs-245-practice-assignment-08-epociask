public class BST<T extends Comparable<T>>{

	private Node<T> root;

	public BST(){

		root = null;

	}

	public boolean find(T item){

		return find(root, item);
	}


	private boolean find(Node<T> node, T item){

		if(node == null){
			return false;
		}
		if(item.compareTo(node.data) == 0){

			return true;
		}

		if(item.compareTo(node.data)<0){
			return find(node.left, item);

		}else{
			return find(node.right, item);
		}
	}

	private Node<T> insert(Node<T> node, T item){


		//int compareResult = item.compareTo(node.data);
		if(node == null){
			return new Node<T>(item);

		}else if(item.compareTo(node.data) < 0){
			node.left = insert(node.left, item);
		
		}else{
			node.right = insert(node.right, item);
		}


		return node;
	}


	public void insert(T data){
		root = insert(this.root, data);

	}

	public void print(){
		print(this.root);
	}

	private void print(Node node){

		if(node != null){
			print(node.left);
			System.out.println(node.data);
			print(node.right);

		}
	}


	public Node<T> findSmallest(Node<T> root){

		while(root.left != null){

			root = root.left;
		}

		return root;

	}

	public void delete(T data){

		root = delete(this.root, data);

	}

	public Node<T> delete(Node<T> node, T data){

		if(node == null){
			return node;
		
		}else if(data.compareTo(node.data)<0){
			delete(node.left, data);

		}else if(data.compareTo(node.data)>0){
			delete(node.right, data);

		}else{

		//NO CHILD CASE #1
		if(node.left == null && node.right == null){	

			node = null;
		//ONE CHILD CASE #2
		}else if(node.left == null){
			node = node.right;
		//ONE CHILD CASE #2
		}else if(node.right == null){
			node = node.left;
	
		//CASE #3
		}else{

			Node<T> tempMin = findSmallest(node);
			node = tempMin;
			node = delete(node.right, data);
		}
		}
			return node;
	}


}