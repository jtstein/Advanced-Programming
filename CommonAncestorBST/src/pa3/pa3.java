/*
 * Jordan Stein
 * CSCI 3320-001 FALL 2015
 * 
 * Time Complexity: The time complexity of this program is O(n). This is because searching the binary tree has to check every node in the tree for the given value.
 * Space Complexity: The space complexity of this program is also O(n) where n is the number of integer values we add into the tree.
 * 
 */
package pa3;

import java.util.*;

public class pa3 {
	public static void main(String args[])
	{
		Tree tree = new Tree();
		
		// add nodes with values into the tree
		// assume all values added are unique
		tree.add(50);
		tree.add(25);
		tree.add(75);
		tree.add(10);
		tree.add(8);
		tree.add(21);
		tree.add(82);
		tree.add(60);
		
		System.out.println("Below are the contents of the binary tree (in order)");
		tree.readInOrder(); // reads the contents of the tree through an in-order traversal.
		
		int val1, val2;
		Scanner sc = new Scanner(System.in);
		System.out.println("\nWhich two nodes would you like to find the common ancestor of?");
		System.out.print("Please enter node 1: ");
		val1 = sc.nextInt(); // node1 to be searched
		System.out.print("Please enter node 2: ");
		val2 = sc.nextInt(); // node2 to be searched
		sc.close();

		TreeNode ancestor = tree.findCommonAncestor(tree.root, tree.find(val1), tree.find(val2)); //tree.find returns the TreeNode which has the passed value
		
		System.out.println("The common ancestor of " + val1 + " and " + val2 + " is: " + ancestor.val);	// outputs common ancestor of two nodes.
	}
}
