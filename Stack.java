// Write your code
public class Stack{
	private Node top;

	public Stack(){
		top = null;
	}

	public boolean isEmpty(Object stack){
    if(top == null){
      return true;
    }else{
      return false;
    }
	}

	public void push (Object newItem){
		top = new Node(newItem, top);

	//OR it can be written as:

	//Node n = new Node(newItem, top);
	//top = n;
	}

	public Object pop(){
		if(isEmpty(top) == true){
			System.out.println("Stack is empty at the moment. Nothing to pop.");
      return null;
		}else{
      Node temp = top;
      top = top.next;
    	return temp.info;
    }
	}
  
  public Object peek(){
    return top.info;
  }
}