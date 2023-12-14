public class Runner {
    public static void main(String args[]) {
      //Objects
      
      BTNode a = new BTNode(5);
      
      BTNode b = new BTNode(3);
      BTNode c = new BTNode(9);
      
      BTNode d = new BTNode(4);
      BTNode e = new BTNode(7);
      BTNode f = new BTNode(11);
              
      a.left = b;
      a.right = c;
      b.right = d;
      c.left = e;
      c.right = f;
      
      System.out.println(smallestBST(a));
      
    }
    
    static int smallestBST(BTNode node){
      if(node == null){
        return -111;
    	}
      
      while(node.left != null){
        node = node.left;
      }
      return node.data;
    }
}