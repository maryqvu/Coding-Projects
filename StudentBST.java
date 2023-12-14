/**
 * create a binary search tree of students
 * using the student Id as the main key
 */
class StudentBST {
    private Student root;

    StudentBST() {
    }
  
  public boolean isEmpty(){
    if(root == null){
      return true;
    }else{
      return false;
    }
  }
  
  /*
  return true if the object is added to the tree
  */
  
  public boolean add(Student newStudent){
    if(root == null){
      root = newStudent;
      return true;
    }else{
      if(root.getStudentId() > newStudent.getStudentId()){
        root.setLeft(newStudent);
        return true;
      }else if(root.getStudentId() < newStudent.getStudentId()){
        root.setRight(newStudent);
        return true;
      }
    }
    return false;
  }

}