package chapter2;

/**
 * 
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 
 */
public class T17Merge {

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

	public ListNode Merge(ListNode list1, ListNode list2) {
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;
		ListNode newHead = null, nextNode = null;
		if (list1.val < list2.val) {
			newHead = list1;
			list1 = list1.next;
		} else {
			newHead = list2;
			list2 = list2.next;
		}
		nextNode = newHead;
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				nextNode = nextNode.next = list1;
				list1 = list1.next;
			} else {
				nextNode = nextNode.next = list2;
				list2 = list2.next;
			}
		}
		if (list1 != null) {
			nextNode.next = list1;
		}
		if (list2 != null) {
			nextNode.next = list2;
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
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(2);
		head1.next.next = new ListNode(3);
		head1.next.next.next = new ListNode(4);
		head1.next.next.next.next = new ListNode(5);
		head1.next.next.next.next.next = new ListNode(6);
		head1.next.next.next.next.next.next = new ListNode(7);
		head1.next.next.next.next.next.next.next = new ListNode(8);
		head1.next.next.next.next.next.next.next.next = new ListNode(9);
		ListNode head2 = new ListNode(1);
		head2.next = new ListNode(2);
		head2.next.next = new ListNode(3);
		head2.next.next.next = new ListNode(4);
		head2.next.next.next.next = new ListNode(5);
		head2.next.next.next.next.next = new ListNode(6);
		head2.next.next.next.next.next.next = new ListNode(7);
		head2.next.next.next.next.next.next.next = new ListNode(8);
		head2.next.next.next.next.next.next.next.next = new ListNode(9);
		printList(new T17Merge().Merge(head1, head2));
	}
}
