package sword.to.offer.chapter4;

import java.util.Stack;

/**
 * 
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列 1,2,3,4,5
 * 是某栈的压入顺序，序列 4,5,3,2,1 是该压栈序列对应的一个弹出序列，但 4,3,5,1,2
 * 就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * 
 */
public class T22IsPopOrder {
	private Stack<Integer> stack = new Stack<>();

	public boolean IsPopOrder(int[] pushA, int[] popA) {
		for (int i = 0, j = 0; i < pushA.length; i++) {
			stack.push(pushA[i]);
			while (!stack.isEmpty() && stack.peek() == popA[j]) {
				stack.pop();
				j++;
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) throws Exception {
	}
}
