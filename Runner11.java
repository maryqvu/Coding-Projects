public class Runner {
  
  public static void main (String[] args){
    Queue queue1 = new Queue();
    
    queue1.enqueue(30);
    queue1.enqueue(4);
    queue1.enqueue(9);
    queue1.enqueue(21);
    queue1.enqueue(76);
    queue1.enqueue(18);
    queue1.enqueue(35);
    
    findMax(queue1);
    System.out.println();
    System.out.println("The average of the queue is: " + findAvg(queue1));
    
  }
  public static void findMax(Queue q){
    Queue tempQueue = new Queue();
    
    if(q.isEmpty()){
      return;
    }
    
    int max = (int)q.peek();
    
    while(!q.isEmpty()){
      int current = (int)q.dequeue();
      tempQueue.enqueue(current);
      if(current > max){
        max = current;
      }
    }
    
    while(!tempQueue.isEmpty()){
      q.enqueue(tempQueue.dequeue());
    }
    System.out.println("Max value within the queue is: " + max);
  }
  
  public static double findAvg (Queue q){
    Queue tempQueue = new Queue();
    int total = 0;
    int count = 0;
    
    while(!q.isEmpty()){
      int current = (int)q.dequeue();
      count += 1;
      total += current;
      tempQueue.enqueue(current);
    }

    while(!tempQueue.isEmpty()){
      q.enqueue(tempQueue.dequeue());
    }
    
    return (double) total/count;
  }
}