class QueueAct11 {
        private Node front, rear;
    
        public Queue() {
            front = rear = null;
        }

        //dequeue, enqueue methods

        /**
         * Removes the last element in the queue (do not SOP anything)
         * Consider: if the queue is empty; if the queue has one element only; if the queue has more than one element
         * Queue state after the method: The queue without the last element
         * Returns: Nothing (void)
         */
        public void removeLast(){
            Node current = front;

            if(testQueue.isEmpty()){
                return;
            }else if(testQueue.size() == 1){
                testQueue.dequeue();
            }

            while(current.next != rear){
                current = current.next;
                if(current.next == rear){
                    rear = current;
                    current.next = null;
                }
            }

        }
    }