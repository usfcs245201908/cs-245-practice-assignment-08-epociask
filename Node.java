class Node<T extends Comparable<T>>{
	
	public T data; 
	public Node<T> left, right;

	public Node(Object data){

	this.data = (T) data; 
	left = right = null;
	}

}