public class Lab3 {

    public static void main(String[] args) {
        
        System.out.println("--------------------------------------------");
        System.out.println("CamelCase");
        String caseIterative = camelCaseIterative("Welcome to CS 2");
        String caseRecursive = camelCaseRecursive("Welcome to CS 2");
        System.out.println("Recursive: " + caseRecursive + " \nIterative: " + caseIterative);
        
        caseIterative = camelCaseIterative("Elementary Data Structure and Algorithms");
        caseRecursive = camelCaseRecursive("Elementary Data Structure and Algorithms");
        System.out.println("Recursive: " + caseRecursive + " \nIterative: " + caseIterative);
        
        caseIterative = camelCaseIterative("Strings are important and immutable");
        caseRecursive = camelCaseRecursive("Strings are important and immutable");
        System.out.println("Recursive: " + caseRecursive + " \nIterative: " + caseIterative);
        
        System.out.println("--------------------------------------------");
        
        System.out.println("CleanString");
        String cleanIterative = stringCleanIterative("abbbcdd");
        String cleanRecursive = stringCleanRecursive("abbbcdd");
        System.out.println("Recursive: " + cleanRecursive + " \nIterative: " + cleanIterative);
        
        cleanIterative = stringCleanIterative("Bees look cool");
        cleanRecursive = stringCleanRecursive("Bees look cool");
        System.out.println("Recursive: " + cleanRecursive + " \nIterative: " + cleanIterative);
        
        cleanIterative = stringCleanIterative("A cook book");
        cleanRecursive = stringCleanRecursive("A cook book");
        System.out.println("Recursive: " + cleanRecursive + " \nIterative: " + cleanIterative);
        
        System.out.println("--------------------------------------------");
        
        System.out.println("CountHello");
        int helloIterative = countHelloIterative("xhelloxhellox");
        int helloRecursive = countHelloRecursive("xhelloxhellox");
        System.out.println("Recursive: " + helloRecursive + " \nIterative: " + helloIterative);

        helloIterative = countHelloIterative("helloxhelloabcdhelloijklo");
        helloRecursive = countHelloRecursive("helloxhelloabcdhelloijklo");
        System.out.println("Recursive: " + helloRecursive + " \nIterative: " + helloIterative);
         
    }
    

    /**
     * This method will produce a camel case iteratively.
     * @param word a string to modify.
     * @return a camel case string.
     */
    public static String camelCaseIterative(String word){
      String camelCase = " ";
      for(int i = 0; i < word.length(); i++){
        if(i % 2 == 0){
          char lower = Character.toLowerCase(word.charAt(i));
          camelCase += Character.toString(lower);
        }else if(i % 2 == 1){
          char upper = Character.toUpperCase(word.charAt(i));
          camelCase += Character.toString(upper);
        }
      }
    return camelCase;
    }


    /**
     * This method will produce a camel case recursively.
     * @param word a string to modify.
     * @return a camel case string.
     */
  public static String camelCaseRecursive(String word){
    char convertedChar;

    if(word.isEmpty()){      
      return " ";
    }
    char firstChar = Character.toLowerCase(word.charAt(0));
    if(word.length() % 2 == 1){
      convertedChar = Character.toLowerCase(firstChar);
    }else{
      convertedChar = Character.toUpperCase(firstChar);
    }

    String camelCaseSentence = camelCaseRecursive(word.substring(1));
    return convertedChar + camelCaseSentence;

  }


    /**
     * This method will produce a clean string iteratively.
     * @param word a string to produce.
     * @return a clean string.
     */
  public static String stringCleanIterative(String word){
      String clean = word.substring(0,1);
    for(int i = 1; i < word.length(); i++){
      char charPlaceHolder = word.charAt(i);
        if(word.charAt(i-1) != charPlaceHolder){
            clean += Character.toString(word.charAt(i));
        }
    }
    return clean;
  }

    /**
     * This method will produce a clean string recursively.
     * @param word a string to produce.
     * @return a clean string.
     */
  public static String stringCleanRecursive(String word){
    if (word.length() <= 1) {
      return word;
    }

    char currentChar = word.charAt(0);
    char nextChar = word.charAt(1);

    if (currentChar != nextChar) {
        return currentChar + stringCleanRecursive(word.substring(1));
    } else {
        return stringCleanRecursive(word.substring(1));
    }
  }

    /**
     * This method will count the number of "Hello" words iteratively.
     * @param word a string to produce.
     * @return a int of how many times a word appear.
     */
  public static int countHelloIterative(String word){
    int count = 0;
    for(int i = 0; i < word.length()-5; i++){
      if(word.substring(i,i+5).equalsIgnoreCase("Hello")){
        count++;
      }
    }
    return count;
  }


    /**
     * This method will count the number of "Hello" words recursively.
     * @param word a string to produce.
     * @return a int of how many times a word appear.
     */
  public static int countHelloRecursive(String word){
    if(word.length() < 5){
      return 0;
    }

    if(word.substring(0,5).equalsIgnoreCase("hello")){
      return 1 + countHelloRecursive(word.substring(5));
    }else{
      return countHelloRecursive(word.substring(1));
    }
  }
}
