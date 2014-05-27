class BST
{
	Node root;
	
	public void add(int data)
	{
		Node node = new Node(data);
		
		System.out.println("Adding " + data);
		
		if(root == null)
			root = node;
		else
			add(root, new Node(data));
	}
	
	private void add(Node root, Node nodeToAdd)
	{
		if(nodeToAdd.data == root.data)
		{
			System.out.println("Already have node with data: " + root.data);
			return;
		}
		else if(nodeToAdd.data < root.data)
		{
			if(root.left != null)
				add(root.left, nodeToAdd);
			else
				root.left = nodeToAdd;
		}
		else if(nodeToAdd.data > root.data)
		{
			if(root.right != null)
				add(root.right, nodeToAdd);
			else
				root.right = nodeToAdd;
		}
	}
	
	public void delete(int data)
	{
		// case 1: node has no children = easy
		// case 2: node has one child = medium
		// case 3: node has 2 children = hard
		System.out.println("Deleting node with data: " + data);
		
		Node nodeToBeDeleted = find(data);
		Node parent = findParent(data);
		
		if(nodeToBeDeleted == null)
		{
			System.out.println("Could not find node to delete with data: " + data);
			return;
		}
		else // we found the node to delete and set it to nodeToBeDeleted
		{
			// case 1, has no children. node must be at leaf level so simply delete it.
			if(nodeToBeDeleted.left == null && nodeToBeDeleted.right == null)
			{
				System.out.println("Case 1 for deletion.");
				deleteCase1(parent, nodeToBeDeleted);
			}
			// case 3, has both children
			else if(nodeToBeDeleted.left != null && nodeToBeDeleted.right != null)
			{
				System.out.println("Case 3 for deletion.");
				deleteCase3(parent, nodeToBeDeleted);
			}
			// case 2, has at least one child. 
			else if(nodeToBeDeleted.left != null)
			{
				System.out.println("Case 2 for deletion.");
				deleteCase2(parent, nodeToBeDeleted);
			}
			// case 2, has at least one child. 
			else if(nodeToBeDeleted.right != null)
			{
				System.out.println("Case 2 for deletion.");
				deleteCase2(parent, nodeToBeDeleted);
			}
		}
	}
	
	private void deleteCase1(Node parent, Node nodeToBeDeleted)
	{
		// node to be deleted has no children
		if(parent.left == nodeToBeDeleted)
			parent.left = null;
		else if(parent.right == nodeToBeDeleted)
			parent.right = null;
	}
	
	private void deleteCase2(Node parent, Node nodeToBeDeleted)
	{
		// node to be deleted has one child
		if(parent.left == nodeToBeDeleted)
		{
			if(nodeToBeDeleted.left != null)
				parent.left = nodeToBeDeleted.left;
			else if(nodeToBeDeleted.right != null)
				parent.left = nodeToBeDeleted.right;
				
		}
		else if(parent.right == nodeToBeDeleted)
		{
			if(nodeToBeDeleted.left != null)
				parent.right = nodeToBeDeleted.left;
			else if(nodeToBeDeleted.right != null)
				parent.right = nodeToBeDeleted.right;
		}
	}
	
	private void deleteCase3(Node parent, Node nodeToBeDeleted)
	{
		Node replacement = findMin(nodeToBeDeleted.right);
		
		// since replacement can only be case 1 or case 2, it is safe to call delete here
		delete(replacement.data);
		
		replacement.left = nodeToBeDeleted.left;
		replacement.right = nodeToBeDeleted.right;
		
		// in this case we are deleting the root
		if(parent == null)
		{
			this.root = replacement;
		}
		else
		{
			if(parent.left == nodeToBeDeleted)
				parent.left = replacement;
			else if(parent.right == nodeToBeDeleted)
				parent.right = replacement;
		}
	}
	
	public Node find(int data)
	{
		System.out.println("Trying to find and return Node with data: " + data);
		return find(root, data);
	}
	
	private Node find(Node root, int data)
	{
		if(root == null)
		{
			System.out.println("Could not find the node with data: " + data + ", returning null.");
			return null;
		}
		else if(root.data == data)
		{
			System.out.println("Found node with data: " + data + ", returning Node.");
			return root;
		}
		else
		{
			if(root.left != null && data < root.data)
				return find(root.left, data);
			else if(root.right != null && data > root.data)
				return find(root.right, data);
		}
		
		return null;
	}
	
	public Node findParent(int data)
	{
		System.out.println("Finding the parent of the node that contains data: " + data);
		return findParent(root, data);
	}
	
	private Node findParent(Node root, int data)
	{
		if(root == null)
		{
			System.out.println("Could not find Node with data: " + data);
			return null;
		}
		else if(root.data == data)
		{
			System.out.println("Node that contains data: " + data + " has no parent.");
			return null;
		}
		else
		{
			if(data < root.data && root.left != null)
			{
				if(root.left.data == data)
				{
					System.out.println("Node that contains data: " + data + " has parent with data: " + root.data);
					return root;
				}
				else
					return findParent(root.left, data);
			}
			else if(data > root.data && root.right != null)
			{
				if(root.right.data == data)
				{
					System.out.println("Node that contains data: " + data + " has parent with data: " + root.data);
					return root;
				}
				else
					return findParent(root.right, data);
			}
			else
			{
				System.out.println("Could not find Node with data: " + data);
				return null;
			}
		}
	}
	
	public Node findMin()
	{
		System.out.println("Searching for minimum.");
		return findMin(root);
	}
	
	private Node findMin(Node node)
	{
		if(node == null)
		{
			System.out.println("Tree is empty. Cannot find min.");
			return null;
		}
		else if(node.left == null)
		{	
			System.out.println("Minimum node found with data: " + node.data);
			return node;
		}
		else
			return findMin(node.left);
	}
	
	public Node findMax()
	{
		System.out.println("Searching for maximum.");
		return findMax(root);
	}
	
	private Node findMax(Node node)
	{
		if(node == null)
		{
			System.out.println("Tree is empty. Cannot find max.");
			return null;
		}
		else if(node.right == null)
		{	
			System.out.println("Maximum node found with data: " + node.data);
			return node;
		}
		else
			return findMax(node.right);
	}
	
	public Node findClosestCommonAncestor(int value1, int value2)
	{
		System.out.format("Finding closest common ancestor of values (%d,%d).\n", value1, value2);
		
		// check if either value is the root data
		// if yes there is no ancestor to root, return null
		
		if(root.data == value1 || root.data == value2)
		{
			System.out.println("Root node of tree has one of the values specified.\nNo ancestor, returning null.");
			return null;
		}
		
		Stack<Node> ancestors = new Stack<Node>();
		findClosestCommonAncestor(root, ancestors, value1, value2);
		
		if(ancestors.empty())
		{
			System.out.println("Could not find values in the tree, returning null.");
			return null;
		}
		
		Node peek = ancestors.peek();
		System.out.println("Closest common ancestor has data: " + peek.data);
			
		return ancestors.pop();
	}
	
	private void findClosestCommonAncestor(Node root, Stack<Node> ancestors, int value1, int value2)
	{
		
		// check if current tree contains value1 and value2
		// if yes add tree root to stack
		// if no return
		// if left child of root exists, call function again on subtree root.left
		// if right child of root exists, call function again on subtree root.right
		// repeat 
		
		if(find(root, value1) != null && find(root, value2) != null)
		{
			if(root.data == value1 || root.data == value2)
				ancestors.push(findParent(root.data));
			else
				ancestors.push(root);
				
			findClosestCommonAncestor(root.left, ancestors, value1, value2);
			findClosestCommonAncestor(root.right, ancestors, value1, value2);	
		}
	}
	
	public void preOrderTraversal()
	{
		System.out.println("Pre-Order Traversal: ");
		preOrderTraversal(root);
	}
	
	private void preOrderTraversal(Node node)
	{
		if(node != null)
		{
			System.out.println(node.data);
			
			if(node.left != null)
				preOrderTraversal(node.left);
			
			if(node.right != null)
				preOrderTraversal(node.right);
		}
	}

	public void inOrderTraversal()
	{
		System.out.println("In-order Traversal: ");
		inOrderTraversal(root);
	}
	
	private void inOrderTraversal(Node node)
	{
		if(node != null)
		{
			if(node.left != null)
				inOrderTraversal(node.left);
			
			System.out.println(node.data);
			
			if(node.right != null)
				inOrderTraversal(node.right);
		}
		
	}
	
	public void postOrderTraversal()
	{
		System.out.println("Post-order Traversal: ");
		postOrderTraversal(root);
	}
	
	private void postOrderTraversal(Node node)
	{
		if(node != null)
		{
			if(node.left != null)
				postOrderTraversal(node.left);
			
			if(node.right != null)
				postOrderTraversal(node.right);
			
			System.out.println(node.data);
		}
	}
	
}