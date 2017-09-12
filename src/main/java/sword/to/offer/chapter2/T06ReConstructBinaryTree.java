package sword.to.offer.chapter2;

/**
 * 
 * 重建二叉树
 * 
 * 题目描述: 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 例如输入前序遍历序列
 * {1,2,4,7,3,5,6,8} 和中序遍历序列 {4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 */
public class T06ReConstructBinaryTree {

	private int[] pre, in;

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		this.pre = pre;
		this.in = in;
		return constructBinaryTree(0, pre.length, 0, in.length);
	}

	private TreeNode constructBinaryTree(int preStart, int preEnd, int inStart, int inEnd) {
		TreeNode head = new TreeNode(pre[preStart]);
		int index = search(in, inStart, inEnd, pre[preStart]);
		int num = index - inStart;
		head.left = ((num == 0) ? null : constructBinaryTree(preStart + 1, preStart + num + 1, inStart, index));
		head.right = ((num == preEnd - preStart - 1) ? null
				: constructBinaryTree(preStart + num + 1, preEnd, index + 1, inEnd));
		return head;
	}

	private int search(int[] arr, int start, int end, int key) {
		for (int index = start; index < end; index++) {
			if (arr[index] == key)
				return index;
		}
		return -100;
	}

	public static void main(String[] args) {
		int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
		TreeNode head = new T06ReConstructBinaryTree().reConstructBinaryTree(pre, in);
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
