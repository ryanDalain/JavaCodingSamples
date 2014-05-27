public class BSTDriver
{

	public static void main(String[] args)
	{	
		Node root = new Node(new Integer(5));
		BST bst = new BST();
		
		bst.add(50);
		bst.add(10);
		bst.add(75);
		bst.add(12);
		bst.add(9);
		bst.add(55);
		bst.add(60);
		// tree should look like the following:
		//           50
		//        10     75
		//       9  12 55
		//               60
		
		bst.find(9);
		bst.find(99); // should not find 99
		
		bst.findParent(50); // should not find parent, root case.
		bst.findParent(12);
		
		// case 1, both values exist in the tree
		// case 2, one or two values do not exit in the tree
		// case 3, one of the values is the root node, no ancestor to root
		// case 4, both values are the same node
		bst.findClosestCommonAncestor(60, 55);
		bst.findClosestCommonAncestor(12, 99);
		bst.findClosestCommonAncestor(50, 9);
		bst.findClosestCommonAncestor(55, 55);
		
		bst.findMin();
		bst.findMax();
		
		bst.preOrderTraversal();
		bst.inOrderTraversal();
		bst.postOrderTraversal();
		
		bst.delete(50); // deleting root, special case / case 3(two children)
		bst.preOrderTraversal();
		bst.delete(9); // deleting leaf, case 1(no children)
		bst.preOrderTraversal();
		bst.delete(10); // deleting node with case 2(1 child)
		bst.preOrderTraversal();
		bst.delete(99); // should not be successful 
		bst.preOrderTraversal();
		// tree should look like the following:
		//           55
		//        12     75
		//             60
		
	}

}