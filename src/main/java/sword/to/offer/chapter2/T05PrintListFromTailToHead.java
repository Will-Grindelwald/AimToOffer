package sword.to.offer.chapter2;

import java.util.ArrayList;

/**
 * 
 * 从尾到头打印链表
 * 
 * 题目描述: 输入一个链表，从尾到头打印链表每个节点的值。
 * 
 * 1. 用栈：时 o(n), 空 o(n), 原链表没改变
 * 
 * 2. 先头插法建表，再顺序遍历：时 o(n), 空 o(1), 原链表改变了
 *
 */
public class T05PrintListFromTailToHead {

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (listNode == null) {
			return result;
		}
		ListNode newList = null, tmp = listNode;
		while ((listNode = listNode.next) != null) {
			tmp.next = newList;
			newList = tmp;
			tmp = listNode;
		}
		tmp.next = newList;
		newList = tmp;
		while (newList != null) {
			result.add(newList.val);
			newList = newList.next;
		}
		return result;
	}

	public static void main(String[] args) {
	}
}

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}
