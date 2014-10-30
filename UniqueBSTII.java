import java.util.ArrayList;
import java.util.List;


public class UniqueBSTII
{
	public List<TreeNode> generateTrees(int n)
	{
		return generateTrees(1,n);
	}
	
	public List<TreeNode> generateTrees(int start,int end)
	{
		List<TreeNode> result = new ArrayList<TreeNode>();
		if (start > end)
		{
			result.add(null);
			return result;
		}
		for (int i = start; i <= end; i++)
		{
			List<TreeNode> left =  generateTrees(start, i-1);
			List<TreeNode> right = generateTrees(i+1, end);
			for (int j = 0; j < left.size(); j++)
			{
				for (int k = 0; k < right.size(); k++)
				{
					TreeNode root = new TreeNode(i);
					root.left = left.get(j);
					root.right = right.get(k);
					result.add(root);
				}
			}
		}
		return result;
	}

}
