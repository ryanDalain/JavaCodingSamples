public class SLLDriver
{

	public static void main(String[] args)
	{
		Node head = new Node('A');
		SLL sll = new SLL(head);
		
		sll.add(new Node('B'));
		sll.add(new Node('C'));
		sll.add(new Node('D'));
		sll.add(new Node('E'));
		sll.add(new Node('F'));
		
		System.out.println("Linked list BEFORE the swaps");
		sll.print();
		
		Node firstNode = sll.head;
		Node secondNode = firstNode.next;
		Node tempNode = secondNode.next;
		secondNode.next = firstNode;
		firstNode.next = tempNode;
		
		sll.head = secondNode;
		
		Node iterationNode = firstNode;
		
		firstNode = firstNode.next;
		secondNode = firstNode.next;
		
		
		while(firstNode != null && secondNode != null)
		{
			tempNode = secondNode.next;
			secondNode.next = firstNode;
			firstNode.next = tempNode;
			
			iterationNode.next = secondNode;
			
			iterationNode = firstNode;
			
			firstNode = firstNode.next;
			if(firstNode == null)
				break;
			else
				secondNode = firstNode.next;
			
		}
		
		System.out.println("Linked list AFTER the swaps");
		sll.print();
		
		
	}
}