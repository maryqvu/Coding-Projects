public class Runner {
    public static void main(String args[]) {
      //Objects
      
      BTNode a = new BTNode(5);
      
      BTNode b = new BTNode(3);
      BTNode c = new BTNode(9);
      
      BTNode d = new BTNode(4);
      BTNode e = new BTNode(7);
      BTNode f = new BTNode(11);
              
      //build the tree

      a.left = b;
      a.right = c;
      b.right = d;
      c.left = e;
      c.right = f;
      
      System.out.println("Printing the BST in PreOrder: ");
      preOrder(a);
      System.out.println();
      System.out.println();
      System.out.println("Printing the BST in InOrder: ");
      inOrder(a);
      System.out.println();
      System.out.println();
      System.out.println("Printing the BST in PostOrder: ");
      postOrder(a);
      System.out.println();
      System.out.println();
      System.out.println("Printing the largest number in the BST: ");
      largestNumber(a);
      System.out.println();
      System.out.println();
      System.out.println("Printing the smallest number in the BST: ");
      smallestNumber(a);
      System.out.println();
      System.out.println();
      System.out.println("Printing the BST in descending order: ");
      printDesc(a);
      System.out.println();
      System.out.println();
      System.out.println("Printing the BST in ascending order: ");
      printAscend(a);
      
    }
    
    static void preOrder(BTNode node){
      //node, left, right
    	if(node==null)
            return;
      System.out.print(node.data + " ");
    	preOrder(node.left);
      preOrder(node.right);
       
    }
  	
  	static void inOrder(BTNode node){
      if(node == null){
        return;
      }
      if(node != null){
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
      }
    }
  	
  	static void postOrder(BTNode node){
      if(node != null){
        postOrder(node.left);
        postOrder(node.right);
      	System.out.print(node.data + " ");
      }
    }
  
  	static void printDesc(BTNode node){
      if(node == null){
        return;
      }
      if(node.right != null){
        printDesc(node.right);
      }
      System.out.print(node.data + " ");
      printDesc(node.left);
    }
  	
  	static void largestNumber(BTNode node){
			if(node == null){
        return;
      }
      if(node.right != null){
        largestNumber(node.right);
      }
      if(node.right == null){
      	System.out.print(node.data);
      }
    }
  
  	static void smallestNumber(BTNode node){
			if(node == null){
        return;
      }
      if(node.left != null){
        smallestNumber(node.left);
      }
      if(node.left == null){
      	System.out.print(node.data);
      }
    }
  
  	static void printAscend(BTNode node){
      if(node == null){
        return;
      }
      if(node.left != null){
        printAscend(node.left);
      }
      System.out.print(node.data + " ");
      printAscend(node.right);
    }
}