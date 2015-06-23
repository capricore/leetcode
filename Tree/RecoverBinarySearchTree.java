package Tree;

public class RecoverBinarySearchTree {
	TreeNode prev = null;
	TreeNode first = null;
	TreeNode second = null;
	boolean flag = false;
	public void recoverTree(TreeNode root) {
		recoverTrees(root);
		if (first != null && second != null) {
			int temp = first.val;
			first.val = second.val;
			second.val = temp;
		}
		return;
	}

	public void recoverTrees(TreeNode root) {
		if (root == null) {
			return;
		}
		recoverTrees(root.left);
		if (prev == null) {
			prev = root;
		}else {
			if (!flag && root.val < prev.val) {
				flag = true;
				first = prev;
				second = root;
			}else if (flag && root.val < prev.val) {
				second = root;
			}
			prev = root;
		}
		recoverTrees(root.right);
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(2);
		new RecoverBinarySearchTree().recoverTree(root);
	}
}
