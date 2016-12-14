// Jordan Stein
package pa3;

public class Tree {
	
	TreeNode root;
	
	
	public TreeNode findCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) // returns common ancestor between two nodes
	{
		
		if (root == null) return null; // empty tree -> no common ancestors
		if (root == node1 || root == node2) return root; // root is equal to either node -> the root MUST be the common ancestor

		TreeNode leftNode = findCommonAncestor(root.left, node1, node2); // recursively calls for left side of tree
		TreeNode rightNode = findCommonAncestor(root.right, node1, node2); // recursively calls for right side of tree

		if (leftNode != null && rightNode != null) return root; // left and right both null -> root must be common ancestor
		if (leftNode != null) return leftNode; // left references a node, that is the common ancestor.
		else return rightNode; // otherwise right must be the common ancestor.
	}
	
	public void add(int val) // adds a value into the tree
	{
		TreeNode newNode = new TreeNode(val);
		
		if (root == null) // if the tree is empty, root is the node
			root = newNode;
		
		traverseAdd(root, newNode);
	}
	
	private void traverseAdd(TreeNode node, TreeNode newNode) //recursively adds left or right node based off value.
	{
		if (newNode.val < node.val) // if value is less than the node val, traverse left child, else right child
		{
			if (node.left == null) // if there is no left child, we need to add it in
				node.left = newNode;
			else traverseAdd(node.left, newNode); //otherwise, traverse the left node
		}
		else if (newNode.val > node.val)
		{
			if (node.right == null) // if there is no right child, we need to add it
				node.right = newNode;
			else traverseAdd(node.right, newNode); //otherwise, traverse the right node
		}
	}
	
	public TreeNode find(int val) // finds the node that holds a given value
	{
		if (val == root.val) // looking for the root -> return root
			return root;
		if (root != null)
			return findNode(root, new TreeNode(val)); 
		return null;
	}
	
	public TreeNode findNode(TreeNode search, TreeNode node) // recursively searches for the value
	{
		if (search == null)
			return null; // if root is null, we wont find anything.
		if (search.val == node.val)
			return search; // if we found the value, return the TreeNode
		else
		{
			TreeNode rNode = findNode(search.left, node); //searches the left side of the tree
			if (rNode == null)
				rNode = findNode(search.right, node); // searches the right side of the tree if we did not find the desired value on the left child.
			return rNode;
		}
	}
	
	public void readInOrder() // recursively traverses through the tree and reads the data
	{
		if (root != null) // nothing to traverse if root is null
		{
			TreeNode tNode = root; // tNode = node to traverse
			if (tNode.left == null && tNode.right == null) // has no children, output node.val
				{
					System.out.print(tNode.val + " ");
					
				}
			else inOrderTraverse(tNode); // otherwise, check left then right of each node and output node.val

		}
	}
	public void inOrderTraverse(TreeNode node) // recursively traverses through the tree
	{
		if (node.left != null)
			inOrderTraverse(node.left);

		System.out.print(node.val + " "); // prints last node traversed through
		
		if (node.right != null)
			inOrderTraverse(node.right);
	}
}