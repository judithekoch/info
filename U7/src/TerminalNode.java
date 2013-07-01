
public class TerminalNode<T> extends TreeNode<T>{
	
	private T element;
	private TreeNode<T> parent;

	public TerminalNode(T element){
		this.element = element;
	}
	public TerminalNode(T element, TreeNode<T> parent){
		this.element = element;
		this.parent = parent;
	}
	
	public T getElement(){
		return element;
	}
	
	public void setParent(TreeNode<T> parent){
		this.parent = parent;
	}
}
