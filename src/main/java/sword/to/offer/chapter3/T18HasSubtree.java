package sword.to.offer.chapter3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * 输入两棵二叉树 A，B，判断 B 是不是 A 的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 
 */
public class T18HasSubtree {

	/**
	 * 树结点
	 */
	private static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		if (root1 == null || root2 == null)
			return false;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root1);
		TreeNode tmp = null;
		while (!queue.isEmpty()) {
			tmp = queue.remove();
			if (tmp.val == root2.val) {
				if (root2.left != null) {

				}
				if (root2.right != null) {

				}
			}
			if (tmp.left != null) {
				queue.add(tmp.left);
			}
			if (tmp.right != null) {
				queue.add(tmp.right);
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		new T18HasSubtree().HasSubtree(null, null);
	}
}
