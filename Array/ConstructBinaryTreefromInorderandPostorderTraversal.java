package Array;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		TreeNode head = null;
		head = buildTree(head, inorder, postorder);
		return head;
	}

	TreeNode buildTree(TreeNode node, int[] inorder, int[] postorder) {
		if (postorder.length == 1 || postorder.length == 1) {
			return new TreeNode(postorder[0]);
		}
		if (postorder.length == 0 || postorder.length == 0) {
			return null;
		}
		node = new TreeNode(postorder[postorder.length-1]);
		int index = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == postorder[postorder.length-1]) {
				index = i;
				break;
			}
		}
		int[] leftin = new int[index];
		int[] leftpost = new int[index];
		int[] rightin = new int[postorder.length - index - 1];
		int[] rightpost = new int[postorder.length - index - 1];
		for (int i = 0; i < index; i++) {
			leftin[i] = inorder[i];
			leftpost[i] = postorder[i];
		}
		for (int i = 0; i < postorder.length - index - 1; i++) {
			rightin[i] = inorder[i + index + 1];
			rightpost[i] = postorder[i + index];
		}
		node.left = buildTree(node.left, leftin, leftpost);
		node.right = buildTree(node.right, rightin, rightpost);
		return node;
	}
	public static void main(String[] args) {
		int[] postorder = {4,5,2,6,3,1};
		int[] inorder = {4,2,5,1,3,6};
		new ConstructBinaryTreefromInorderandPostorderTraversal().buildTree(inorder, postorder);
	}
}
