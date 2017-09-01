package chapter2;

/**
 * 
 * 输入一个链表，反转链表后。
 * 
 */
public class T16ReverseList {

	/**
	 * 链表结点
	 */
	private static class ListNode {
		int val; // 保存链表的值
		ListNode next; // 下一个结点

		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode ReverseList(ListNode head) {
		if (head == null)
			return null;
		ListNode newHead = null, tmp = null;
		while (head != null) {
			tmp = head;
			head = head.next;
			tmp.next = newHead;
			newHead = tmp;
		}
		return newHead;
	}

	/**
	 * 输出链表的元素值
	 * 
	 * @param head
	 *            链表的头结点
	 */
	public static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println("null");
	}

	public static void main(String[] args) throws Exception {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);
		head.next.next.next.next.next.next.next.next = new ListNode(9);
		printList(new T16ReverseList().ReverseList(head));
	}
}
