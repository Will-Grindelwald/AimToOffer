package sword.to.offer.chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 
 */
public class T23PrintFromTopToBottom {
	private static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		TreeNode tmp = null;
		while (!queue.isEmpty()) {
			tmp = queue.poll();
			res.add(tmp.val);
			if (tmp.left != null)
				queue.offer(tmp.left);
			if (tmp.right != null)
				queue.offer(tmp.right);
		}
		return res;
	}

	public static void main(String[] args) throws Exception {
	}
}
