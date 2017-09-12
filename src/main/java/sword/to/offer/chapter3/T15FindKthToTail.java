package sword.to.offer.chapter3;

/**
 * 
 * 输入一个链表，输出该链表中倒数第 k 个结点。
 * 
 */
public class T15FindKthToTail {

	/**
	 * 链表结点
	 */
	private static class ListNode {
		int value; // 保存链表的值
		ListNode next; // 下一个结点
	}

	public ListNode FindKthToTail(ListNode head, int k) {
		if (k <= 0 || head == null)
			return null;
		ListNode lastOne = head;
		int i = 1;
		for (; i < k && lastOne.next != null; i++) {
			lastOne = lastOne.next;
		}
		if (i < k) {
			return null;
		}
		ListNode target = head;
		while (lastOne.next != null) {
			lastOne = lastOne.next;
			target = target.next;
		}
		return target;
	}

	public static void main(String[] args) throws Exception {
		ListNode head = new ListNode();
		head.value = 1;
		head.next = new ListNode();
		head.next.value = 2;
		head.next.next = new ListNode();
		head.next.next.value = 3;
		head.next.next.next = new ListNode();
		head.next.next.next.value = 4;
		head.next.next.next.next = new ListNode();
		head.next.next.next.next.value = 5;
		head.next.next.next.next.next = new ListNode();
		head.next.next.next.next.next.value = 6;
		head.next.next.next.next.next.next = new ListNode();
		head.next.next.next.next.next.next.value = 7;
		head.next.next.next.next.next.next.next = new ListNode();
		head.next.next.next.next.next.next.next.value = 8;
		head.next.next.next.next.next.next.next.next = new ListNode();
		head.next.next.next.next.next.next.next.next.value = 9;
		System.out.println(new T15FindKthToTail().FindKthToTail(head, 1).value);
	}
}
