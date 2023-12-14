public class Node{

	Object info;
	Node next;
	private int value;

	Node(Object info, Node next){
		this.info = info;
		this.next = next;
	}

	public Node(){
	}

	public Node(int enteredValue){
		value = enteredValue;
	}

	public void setValue(int enteredValue){
		value = enteredValue;
	}

	public int getValue(){
		return value;
	}
	
}