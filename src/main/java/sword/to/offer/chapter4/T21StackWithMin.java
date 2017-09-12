package sword.to.offer.chapter4;

import java.util.Stack;

/**
 * 
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的 min 函数。
 * 
 */
public class T21StackWithMin {
	private Stack<Integer> dataStack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();

	public void push(int node) {
		if (minStack.isEmpty())
			minStack.push(node);
		else
			minStack.push(Math.min(minStack.peek(), node));
		dataStack.push(node);
	}

	public void pop() {
		dataStack.pop();
		minStack.pop();
	}

	public int top() {
		return dataStack.peek();
	}

	public int min() {
		return minStack.peek();
	}

	public static void main(String[] args) throws Exception {
	}
}
