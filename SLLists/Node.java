class Node
{
	public char data;
	public Node next;
	
	public Node(char data, Node next)
	{
		this.data = data;
		this.next = next;
	}
	
	public Node(char data)
	{
		this(data, null);
	}
	
	public void print()
	{
		System.out.format("%c->", this.data);
	}
}