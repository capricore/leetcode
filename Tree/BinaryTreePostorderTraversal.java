package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode prev = null;
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.peek();
			if ((cur.left == null && cur.right == null)||(prev != null &&(prev == cur.left || prev == cur.right))) {
				 prev = stack.pop();
				 list.add(prev.val);
			}else {
				if (cur.right!=null) {
					stack.add(cur.right);
				}
				if (cur.left!=null) {
					stack.add(cur.left);
				}
			}
		}
		return list;
	}

}
