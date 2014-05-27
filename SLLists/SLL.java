class SLL
{

	public Node head;
	
	public SLL(Node head)
	{
		this.head = head;
	}
	
	public void add(Node node)
	{
		Node temp = this.head;
		
		while(temp.next != null)
			temp = temp.next;
			
		temp.next = node;
	}
	
	public void print()
	{
		Node temp = this.head;
		
		if(temp == null)
			System.out.println("List empty");
		
		while(temp != null)
		{
			temp.print();
			temp = temp.next;
		}
		System.out.println();
	}

}