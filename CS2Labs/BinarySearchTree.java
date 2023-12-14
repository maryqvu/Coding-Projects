
class BinarySearchTree {
  BTNode root; // The root of the Binary tree
  int count; // Number of elements currently in the Binary tree

  /**
   * Constructors of the Binary Tree class
   * 
   */
  BinarySearchTree() {
  }

  BinarySearchTree(int value) {
    root = new BTNode(value);
  }

  /**
   * @return Number of nodes in the binary
   *         tree.
   */
  public int size() {
    return count;
  }

  /**
   * Insert the value in the Binary Search Tree.
   * Also increase the count of nodes after insertion.
   * 
   * @param value
   * @return true if insertion is successful.
   */

  public boolean insertBST(int value) {
    BTNode newNode = new BTNode(value);

    if (root == null) {
        root = newNode;
        return true;
    }

    BTNode current = root;
    BTNode parent = null;

    while (current != null) {
        parent = current;
        if (value < current.data) {
            current = current.left;
        } else if (value > current.data) {
            current = current.right;
        } else {
            return false;
        }
    }

    // Insert the new node
    if (value < parent.data) {
        parent.left = newNode;
    } else {
        parent.right = newNode;
        count += 1;
    }

    return true;
  }


  /**
   * Delete node in the Binary search tree for the given value.
   * 
   * @param key
   * @return level of the key, -1 if the key is not in the tree
   *         level starts at 0, that is, the root is at level 0.
   */

  public void delete(int key) {
    root = delete(root, key, 0);
  }

  private BTNode delete(BTNode root, int key, int level) {
    if (root == null) {
      return root;
    }
    if (key < root.data) {
      root.left = delete(root.left, key, level + 1);
    }else if(key > root.data){
      root.right = delete(root.right, key, level + 1);
    }else{
      if (root.left == null) {
        return root.right;
      }else if(root.right == null) {
        return root.left;
      }
      root.data = minimumVal(root.right);
      root.right = delete(root.right, root.data, level + 1);
    }
    return root;
  }

  private int minimumVal(BTNode root){
    int minimumVal = root.data;
    while (root.left != null) {
        minimumVal = root.left.data;
          root = root.left;
      }
    return minimumVal;
  }



  /**
   * Print the binary tree using inorder traversal
   * 
   */

  public void printInorder() {
    printInorder(root);
  }

  private void printInorder(BTNode node){
    if(node == null){
      return;
    }
    if(node != null){
      printInorder(node.left);
      System.out.print(node.data + " ");
      printInorder(node.right);
    }
  }

  /**
   * Print the binary tree using preorder traversal
   * 
   */

  public void printPreorder() {
    printPreorder(root);   
  }

  private void printPreorder(BTNode node) {
    if(node == null){
      return;
    }
    System.out.print(node.data + " ");
    printPreorder(node.left);
    printPreorder(node.right);     
  }

  /**
   * Print the binary tree using postorder traversal
   * 
   */

  public void printPostorder() {
    printPostorder(root);
  }

  private void printPostorder(BTNode node) {
    if(node == null){
      return;
    }
    if(node != null){
      printPostorder(node.left);
      printPostorder(node.right);
      System.out.print(node.data + " ");
    }
  }
  /**
   * Search the Binary search tree for the given value.
   * 
   * @param key
   * @return level of the key, -1 if the key is not in the tree.
   *         Level starts at 0, that is, the root is at level 0.
   */

  public int searchLevel(int key) {
    int level = 0;
    BTNode current = root;

    while(current != null){
      if(current.data == key){
        return level;
      }else if(key > current.data){
        current = current.right;
        level += 1;
      }else if(key < current.data){
        current = current.left;
        level += 1;
      }else{
        return level;
      }
    }
    return -1;
  }

  /**
   * Return the number of leafs of the binary
   * tree. A leaf node has no children.
   * 
   * @return number of leaf nodes in the tree (BT or BST).
   */

  public int numberOfLeaf() {
    return numberOfLeaf(root);
    }

  private int numberOfLeaf(BTNode node){
    int leafCount = 0;

    if(node == null){
      return leafCount;
    }

    if(node.left == null && node.right == null){
      System.out.print(node.data + " ");
      return leafCount += 1;
    }
    return numberOfLeaf(node.left) + numberOfLeaf(node.right);
  }

  /**
   * Return the count of all the nodes that
   * have exactly two children in the binary tree.
   * 
   * @return number of nodes with 2 child in the tree (BT or BST).
   */

  public int countNodeWithLeftRight() {
    return countNodeWithLeftRight(root);
  }


  private int countNodeWithLeftRight(BTNode node) {
    int countWithChildren = 0;

    if(node == null){
      return countWithChildren;
    }

    if(node.left != null && node.right != null){
      System.out.print(node.data + " ");
      return (countWithChildren += 1) + countNodeWithLeftRight(node.left) + countNodeWithLeftRight(node.right);
    }
    return countWithChildren;
  }


  /**
   * Return the heigth of the binary tree
   * The furthest leaf node from the root has a height of 0.
   * Every level before that has increasing heights, with the root
   * having the most height.
   * 
   * @return the height of the tree (BT or BST).
   */

  public int treeHeight() {
    return treeHeight(root);

  }

  private int treeHeight(BTNode node){
    int treeHeight = 1;
    if(node == null){
      return -1;
    }
    int leftHeight = treeHeight(node.left);
    int rightHeight = treeHeight(node.right);

    if(leftHeight > rightHeight){
      treeHeight = leftHeight + 1;
    }

    if(rightHeight > leftHeight){
      treeHeight = rightHeight + 1;
    }

  return treeHeight;
  }

  /**
   * Compute the sum of all the data fields of
   * all the nodes in the Binary search tree.
   * 
   * @return the sum of all the values in the binary search tree.
   */

  public int sumBT() {
    return sumBT(root);
  }

  private int sumBT(BTNode node){
    if(node == null){
      return 0;
    }
    return (node.data + sumBT(node.left) + sumBT(node.right));
  }
}
