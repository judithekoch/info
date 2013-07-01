



public class MyParser {

	private MyScanner scanner;
	private Character[] charArray;
	private int index = 0;
//	private final char END = '\000';
//	private char current = END;
	private TreeNode<Character> parentNode = new TreeNode<Character>();
	private TreeNode<Character> terminal = new TreeNode<Character>(); 
	
	public MyParser(MyScanner scanner){
		this.scanner = scanner;
		scanner.scan();
		charArray = scanner.getCharArray();
		//parse();
	}
	
	private void next(){
		index++;
//		if (index < charArray.length){
//			current = (char)charArray[index];
//		} else {
//			current = END;
//		}
	}
	
	private void skip(int number){
		index += number;
//		if(index<charArray.length){
//			current = (char)charArray[index];
//		} else {
//			current = END;
//		}
	}
	
	private	boolean isBracket(char c){
		return "()[]{}".indexOf(c) >= 0;
	}
	
	private boolean isOpeningBracket(char c)
	{
		return "([{".indexOf(c) >= 0;
	}
	
	public TreeNode<Character> parse(){
		TreeNode<Character> left = term();
		if(isBracket(charArray[index])){
			next();
		} 
		
		if(index < charArray.length && operation(index)){
			Character symbol = charArray[index];
			next();
			TreeNode<Character> right = term();
			return parentNode = new TreeNode<Character>(symbol, left, right);
		} else {
			return parentNode = left;
		}
		
	}
	
	private TreeNode<Character> term(){
		if(isBracket(charArray[index])){
			next();
			term();
		} else {
			if(index + 1 < charArray.length && operation(index+1)){
				if(!isBracket(charArray[index+2])){
					if(index+3 < charArray.length && !multiplication(index+3) && !isBracket(charArray[index+3])){
						terminal = new TreeNode<Character>(charArray[index+1], new TerminalNode<Character>(charArray[index]), new TreeNode<Character>(charArray[index+3], new TerminalNode<Character>(charArray[index+2]), new TerminalNode<Character>(charArray[index+4])));
						skip(5);		
					} else {
						terminal = new TreeNode<Character>(charArray[index+1], new TerminalNode<Character>(charArray[index]), new TerminalNode<Character>(charArray[index+2]));
						skip(3);
					}
				} else {
					skip(2);
					terminal = new TreeNode<Character>((charArray[index-1]), new TerminalNode<Character>(charArray[index-2]), term());
				}
			} else {
				terminal = new TerminalNode<Character>(charArray[index]);
			}
		}
		return terminal;
	}
	
	private boolean operation(int index){
		return "+-*".indexOf(charArray[index]) >= 0;
	}

	private boolean multiplication(int index){
		return "*".indexOf(charArray[index]) >= 0;
	}
	
	/*public TreeNode<Character> parse(){	
		if(index >= charArray.length){
			return parentNode;
		} else {
		if(isBracket(charArray[index])){
			next();
			parse();
		} else {
			if (parentNode.getElement() == null){
				TreeNode<Character> childNode = new TreeNode<Character>((Character)charArray[index+1]);
				childNode.setLeft(new TerminalNode<Character>((Character)charArray[index], childNode));
				childNode.setRight(new TerminalNode<Character>((Character)charArray[index+2], childNode));
				skip(5);
				parentNode.setElement((Character)charArray[index-1]);
				parentNode.setLeft(childNode);
				parentNode.setRight(parse());
				return parentNode;
			} else if (isOpeningBracket(charArray[index+2])){
				skip(3);
				TreeNode<Character> subNode = new TreeNode<Character>();
				subNode.setData(charArray[index-2], new TerminalNode<Character>((Character)charArray[index-3], subNode), parse());
				return subNode;
			}  else {
				TreeNode<Character> node = new TreeNode<Character>();
				node.setData(charArray[index+1], new TerminalNode<Character>((Character)charArray[index], node), new TerminalNode<Character>((Character)charArray[index+2], node));
				return node;
			}
		}
		return getParentNode();
		}
	}*/
	
	public TreeNode<Character> getParentNode(){
		return parentNode;
	}
	
	public void printTreePreOrder(TreeNode<Character> parentNode){
		System.out.print(parentNode.getElement());
		
		if(parentNode.getLeft() != null){
			printTreePreOrder(parentNode.getLeft());
		}
		
		if(parentNode.getRight() != null){
			printTreePreOrder(parentNode.getRight());
		}
		
		
		/*if(parentNode.getLeft() != null){
			printTreePreOrder(parentNode.getLeft());
		} else {
			System.out.println(parentNode.getLeft().getElement());
			System.out.println(parentNode.getElement());
			if(parentNode.getRight() != null){
				printTreePreOrder(parentNode.getRight());
			} else {
				System.out.println(parentNode.getRight().getElement());
			}
		}*/
	}
	
	public void printTreeInOrder(TreeNode<Character> parentNode){
		if(parentNode.getLeft() != null){
			printTreeInOrder(parentNode.getLeft());
		}
		
		System.out.print(parentNode.getElement());
		
		if(parentNode.getRight() != null){
			printTreeInOrder(parentNode.getRight());
		}
	}
	
	public void printTreePostOrder(TreeNode<Character> parentNode){
		if(parentNode.getLeft() != null){
			printTreePostOrder(parentNode.getLeft());
		}
		
		if(parentNode.getRight() != null){
			printTreePostOrder(parentNode.getRight());
		}
		
		System.out.print(parentNode.getElement());
	}
	
	public String printTreePostOrder2(TreeNode<Character> parentNode){
		String result = "";
		
		if(parentNode.getLeft() != null){
			result += printTreePostOrder2(parentNode.getLeft());
		}
		
		if(parentNode.getRight() != null){
			result += printTreePostOrder2(parentNode.getRight());
		}
		
		result += parentNode.getElement();
		
		return result;
	}
	
	public String stringPostOrder(TreeNode<Character> parentNode){
		String result = "" + printTreePostOrder2(parentNode);
		
		return result;
	}
}
