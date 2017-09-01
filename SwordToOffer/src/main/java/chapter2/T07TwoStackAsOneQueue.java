package chapter2;

import java.util.Stack;

/**
 * 
 * 用两个栈实现队列
 * 
 * 题目描述: 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。 队列中的元素为 int 类型。
 *
 */
public class T07TwoStackAsOneQueue {

	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {
		stack1.push(node);
	}

	public int pop() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		if (stack2.isEmpty()) {
			return 0;
		}
		return stack2.pop();
	}

	public static void main(String[] args) {
	}
}
