class recursiveLL{
	public static void main (String[] args){
		Node testCase1 = new Node(15);
		Node testCase2 = new Node(30);
		Node testCase3 = new Node(45);

		testCase1.next = testCase2;
		testCase2.next = testCase3;
		testCase3.next = null;

		System.out.println(sumOfNodes(testCase1));

	}

	public static int sumOfNodes (Node head){
		if(head == null){
			return 0;
		}

		int currentValue = head.getValue();
		int nextValue = sumOfNodes(head.next);
		int sum = currentValue + nextValue;

		return sum;
	}
}