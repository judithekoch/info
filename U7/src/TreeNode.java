


public class TreeNode<T> {

	private T element;
	private TreeNode<T> left;
	private TreeNode<T> right;
	
	public TreeNode(){
		element = null;
		left = null;
		right = null;
	}
	
	public TreeNode(T element){
		this.element = element;
		this.left = null;
		this.right = null;
	}
	
	public TreeNode(T element, TreeNode<T> left, TreeNode<T> right){
		this.element = element;
		this.left = left;
		this.right = right;
	}
	
	public TreeNode(T element, TerminalNode<T> left, TerminalNode<T> right){
		this.element = element;
		this.left = left;
		this.right = right;
	}
	
	public T getElement(){
		return element;
	}
	
	public TreeNode<T> getLeft(){
		return left;
	}
	
	public TreeNode<T> getRight(){
		return right;
	}
	
	public void setElement(T element){
		this.element = element;
	}
	
	public void setLeft(TreeNode<T> left){
		this.left = left;
	}
	
	public void setRight(TreeNode<T> right){
		this.right = right;
	}
	
	public void setData(T element, TreeNode<T> left, TreeNode<T> right){
		this.element = element;
		this.left = left;
		this.right = right;
	}
	
	public boolean isEmpty(){
		if (element == null){
			return true;
		} else {
			return false;
		}
	}
}
