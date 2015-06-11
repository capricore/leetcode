package Array;

class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}
}

public class ConstructBinaryTreefromPreorderandInorderTraversal {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		TreeNode head = null;
		head = buildTree(head, preorder, inorder);
		return head;
	}

	TreeNode buildTree(TreeNode node, int[] preorder, int[] inorder) {
		if ( preorder.length == 1 || inorder.length == 1) {
			return new TreeNode(preorder[0]);
		}
		if ( preorder.length == 0 || inorder.length == 0) {
			return null;
		}
		node= new TreeNode(preorder[0]);
		int index = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == preorder[0]) {
				index = i;
				break;
			}
		}
		int[] leftin = new int[index];
		int[] leftpre = new int[index];
		int[] rightin = new int[inorder.length - index - 1];
		int[] rightpre = new int[inorder.length - index - 1];
		for (int i = 0; i < index; i++) {
			leftin[i] = inorder[i];
			leftpre[i] = preorder[i + 1];
		}
		for (int i = 0; i < inorder.length - index - 1; i++) {
			rightin[i] = inorder[i + index + 1];
			rightpre[i] = preorder[i + index + 1];
		}
		node.left = buildTree(node.left, leftpre, leftin);
		node.right = buildTree(node.right, rightpre, rightin);
		return node;
	}
	
	public static void main(String[] args) {
		int[] preorder = {1,2,4,5,3,6};
		int[] inorder = {4,2,5,1,3,6};
		new ConstructBinaryTreefromPreorderandInorderTraversal().buildTree(preorder, inorder);
	}
}
