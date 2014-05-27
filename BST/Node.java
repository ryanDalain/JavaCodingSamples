class Node
{
	int data;
	Node left;
	Node right;

	Node(int data)
	{
		this(data, null, null);
	}
	
	Node(int data, Node l, Node r)
	{
		this.data = data;
		this.left = l;
		this.right = r;
	}
	
	public void print()
	{
		System.out.println("Node has data: " + data);
	}
	
}