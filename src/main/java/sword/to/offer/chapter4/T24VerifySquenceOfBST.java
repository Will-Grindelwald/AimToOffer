package sword.to.offer.chapter4;

/**
 * 
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出 Yes, 否则输出 No。假设输入的数组的任意两个数字都互不相同。
 * 
 */
public class T24VerifySquenceOfBST {
	public boolean VerifySquenceOfBST(int[] sequence) {
		if (sequence == null || sequence.length == 0) {
			return false;
		}
		return verify(sequence, 0, sequence.length - 1);
	}

	public boolean verify(int[] sequence, int start, int end) {
		if (start >= end) {
			return true;
		}
		int i;
		for (i = end - 1; i >= start; i--) {
			if (sequence[i] <= sequence[end])
				break;
		}
		int index = i;
		for (; i >= start; i--) {
			if (sequence[i] > sequence[end])
				break;
		}
		if (i >= start) {
			return false;
		} else {
			return verify(sequence, start, index) && verify(sequence, index + 1, end - 1);
		}
	}

	public static void main(String[] args) throws Exception {
		System.out.println(new T24VerifySquenceOfBST().VerifySquenceOfBST(new int[] { 4, 8, 6, 12, 16, 14, 10 }));
	}
}
