package Tree;

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}

public class PopulatingNextRightPointersinEachNodeII {
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		TreeLinkNode across = root;
		while (across != null) {
			TreeLinkNode cur = across;
			while (cur != null) {
				if (cur.left != null && cur.right != null) {
					cur.left.next = cur.right;
					cur.right.next = findLinkNode(cur.next);
				}else if (cur.left == null && cur.right != null) {
					cur.right.next = findLinkNode(cur.next);
				}else if (cur.left != null && cur.right == null) {
					cur.left.next = findLinkNode(cur.next);
				}
				cur = cur.next;
			}
			across = findNextLevel(across);
		}
	}

	public TreeLinkNode findLinkNode(TreeLinkNode root) {
		if (root == null) {
			return null;
		} else {
			while (root != null) {
				if (root.left != null) {
					return root.left;
				} else if (root.right != null) {
					return root.right;
				}
				root = root.next;
			}
		}
		return null;
	}
	
	public TreeLinkNode findNextLevel(TreeLinkNode root) {
		if (root == null) {
			return null;
		}
		if (root.left != null) {
			return root.left;
		}else if (root.right != null) {
			return root.right;
		}else {
			if (root.next == null) {
				return null;
			}else {
				return findNextLevel(root.next);
			}
		}
	}
}
