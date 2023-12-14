public class activity11{
	public static void main (String[] args){
		System.out.println("Testing Validate Method: ");
    	System.out.println("abba is: " + validate("abba"));
    	System.out.println();
    	System.out.println("abdba is: " + validate("abdba"));
    	System.out.println();
    	System.out.println("red is: " + validate("red"));
    	System.out.println();
   		System.out.println ("aabbaa is: " + validate("aabbaa"));
    	System.out.println();
    	System.out.println("cccc is: " + validate("cccc"));
    	System.out.println();
    	System.out.println("aqa is: " + validate("aqa"));
    	System.out.println();
    	System.out.println("cdcd is: " + validate("cdcd"));
    	System.out.println();
    	System.out.println ("sssx is: " + validate("sssx"));
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