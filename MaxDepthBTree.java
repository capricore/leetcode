
//class TreeNode
//{
//	int val;
//	TreeNode left;
//	TreeNode right;
//	TreeNode(int x)
//	{
//		val = x;
//	}
//}

public class MaxDepthBTree
{
	public int maxDepth(TreeNode root)
	{
		if (root == null)
		{	
			return 0;
		}
		
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		
		return max(left, right) + 1;
	}
	
	int max(int x, int y)
	{
		return x > y ? x : y;
	}
	
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(2);
		MaxDepthBTree depth = new MaxDepthBTree();
		System.out.println(depth.maxDepth(root));
	}
}
