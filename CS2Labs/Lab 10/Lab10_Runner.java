
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;


class Lab10_Runner{
  
  public static void main(String[] args) throws Exception{
    // Write your code  
    // Read from a file, process each line
    FileReader input = new FileReader("input.txt");
    BufferedReader br = new BufferedReader(input);

    String line = " ";
    line = br.readLine();

    // Complete the main method
    
  } 
  
  /**
   * The method should consider only left '(' and
   * right parentheses ')'. Other characters in the
   * parameter string expr should be ignored.
   * The method must use a Stack to determine
   * if the incoming string contains a balanced
   * expression or not. See
   * the assignment description for further details.   
   * @param expr
   * @return true if the expression in the String is balanced
   * otherwise, false.
   */
  static boolean isBalanced(String expr){
   // Write your code
    int open = 0;
    int close = 0;
    Stack aStack = new Stack();
    
    System.out.println("Now processing line: " + expr);
    
    for(int i = 1; i < expr.length(); i++){
      if(expr.charAt(0) == 'e' || expr.charAt(0) == 'b'){
      	aStack.push(expr.charAt(i));
      }else{
        System.out.println("The line does not start with either 'e' or 'b'.");
        return false;
      }
    }
    while(!aStack.isEmpty() && open >= close){
      if((Character)aStack.pop() == '('){
        open += 1;
      }else if((Character)aStack.pop() == ')'){
        close += 1;
      }
    }
    if(open == close){
      System.out.println("The expression is: balanced");
      return true;
    }
    System.out.println("The expression is: not balanced");
    return false;
  }

  /**
   * Evaluate the postfix expression in the incoming String.
   * Operators and operands are separated by spaces. See
   * the assignment description for further details.
   * @param postfix
   * @return the evaluated postfix value.
   */  
  static double evaluatePostfixExpression(String expression){
    // Write your code  
    Stack aStack = new Stack();
    return -1;

  }
  
   /**
   * The method returns the factorial of a number.
   * @param num
   * @return factorial of num
   */

  static double factorial(double num){
    // Write your code  
    return 1;
  } 
  
  /**
   * The method checks if a sting is a double 
   * precision number.
   * @param s
   * @return true if the param string is a double precision number
   *         false otherwise.
   */
  static boolean isNumber(String s){
    s = s.trim();
    if (s==null || s=="")
      return false;
    
    try{
      double num = Double.parseDouble(s);
    }catch(NumberFormatException excp){
      return false;
    }
    return true;
  }
}


