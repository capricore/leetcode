package Tree;

import java.util.ArrayList;

public class BinaryTreeMaximumPathSum {
	public int maxPathSum(TreeNode root) {
		ArrayList<Integer> maxSum = new ArrayList<>();
		maxSum.add(Integer.MIN_VALUE);
		maxSum(root,maxSum);
		return maxSum.get(0);
	}
	
	public int maxSum(TreeNode root,ArrayList<Integer> maxSum) {
		if (root == null) {
			return 0;
		}
		int left = maxSum(root.left,maxSum);
		int right = maxSum(root.right,maxSum);
		int curMax = Math.max(root.val, Math.max(left, right)+root.val);	
		maxSum.set(0,Math.max(maxSum.get(0), Math.max(left+right+root.val, curMax)));
		return curMax;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(-3);
//		root.right = new TreeNode(1);
//		root.right.left = new TreeNode(2);
		System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(root));
	}
}
