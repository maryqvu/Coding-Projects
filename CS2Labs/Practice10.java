class Practice10{
  public static void main (String[] args){
    
    Stack aStack = new Stack();
    aStack.push(10);
    aStack.push(8);
    aStack.push(3);
    aStack.push(12);
    aStack.push(6);
    aStack.push(15);
    
    System.out.println(aStack.pop());
    System.out.println(aStack.pop());
    
    Stack bStack = new Stack();
    bStack.push("green");
    bStack.push("blue");
    bStack.push("yellow");
    bStack.push("red");
    bStack.push("purple");
    
    Stack tempStack = new Stack();
    
    tempStack.push(bStack.pop());
    tempStack.push(bStack.pop());
    tempStack.push(bStack.pop());
    tempStack.push(bStack.pop());
    tempStack.push(bStack.pop());
    System.out.println();
    
    System.out.println(tempStack.peek());
    bStack.push(tempStack.pop());
    System.out.println(tempStack.peek());
    bStack.push(tempStack.pop());
    System.out.println(tempStack.peek());
    bStack.push(tempStack.pop());
    bStack.push(tempStack.pop());
    bStack.push(tempStack.pop());
    System.out.println();

    System.out.println(bStack.pop());
    System.out.println(bStack.pop());
    System.out.println(bStack.pop());
    System.out.println(bStack.pop());
    System.out.println(bStack.pop());

    System.out.println();
    System.out.println("Testing Validate Method: ");
    System.out.println("abba is: " + validate("abba"));
    System.out.println("abdba is: " + validate("abdba"));
    System.out.println("red is: " + validate("red"));
    System.out.println ("aabbaa is: " + validate("aabbaa"));
    System.out.println("cccc is: " + validate("cccc"));
    System.out.println("aqa is: " + validate("aqa"));
    System.out.println("cdcd is: " + validate("cdcd"));
    System.out.println ("sssx is: " + validate("sssx"));
    System.out.println();

  }
  
	public static boolean validate(String input){
		if(input.length() == 0){
			return true;
		}

		Stack myStack = new Stack();
    
		for(int i = 0; i < input.length(); i++){
			myStack.push(input.charAt(i));
		}

		while(!myStack.isEmpty(myStack))
			for(int i = 0; i < input.length(); i++){
				if((Character)myStack.peek() == input.charAt(i)){
          myStack.pop();
				}else{
					return false;
				}
			}
			return true;
		}  
	}