// Jordan Stein
package pa3;

public class TreeNode {
	int val; // data for each node
	TreeNode left, right; // children to each node
	
	public TreeNode() // default constructor
	{
		
	}
	public TreeNode(int val) // constructor with data
	{
		this.val = val;
	}
	public void readVal() // reads the value of the current node
	{
		System.out.println(this.val);
	}
}