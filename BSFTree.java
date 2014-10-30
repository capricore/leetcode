
class TreeNode
{
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode (){};
	public TreeNode (int x){ val = x; }
}

public class BSFTree
{
	public TreeNode insertNode (TreeNode root, int x)
	{
		TreeNode p = new TreeNode(x);
		p.left = null;
		p.right = null;
		if (root == null)
		{
			root = p;
		}
		else if( x < root.val)
		{
			root.left = insertNode(root.left, x);
		}
		else {
			root.right = insertNode(root.right, x);
		}
		return root;
	}
	
	public void publishTree(TreeNode root)
	{
		if (root != null)
		{
			publishTree(root.left);
			System.out.println(root.val);
			publishTree(root.right);
		}
	}
	
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(5);
		BSFTree tree = new BSFTree();
		tree.insertNode(root, 4);
		tree.insertNode(root, 7);
		tree.insertNode(root, 3);
		tree.publishTree(root);
		
		
	}
}
