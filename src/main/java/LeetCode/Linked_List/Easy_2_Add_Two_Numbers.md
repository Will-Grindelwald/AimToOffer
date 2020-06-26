# Linked_List_Easy_2_Add_Two_Numbers

Date: 2020-06-26

## [题目](https://leetcode-cn.com/problems/add-two-numbers/)

给出两个 **非空** 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 **逆序** 的方式存储的，并且它们的每个节点只能存储 **一位** 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

**示例：**

    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    输出：7 -> 0 -> 8
    原因：342 + 465 = 807

Related Topics

* 链表
* 数学

## Accepted result:

```java
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? (l2 == null ? new ListNode(0) : l2) : l1;
        }
        ListNode last = l1, res = l1;
        int sum, tmp = 0; // tmp 是进位的临时存储
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + tmp;
            l1.val = sum % 10;
            tmp = sum / 10;
            last = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        l1 = l1 != null ? l1 : l2;
        last.next = l1;
        while (l1 != null && tmp != 0) {
            sum = l1.val + tmp;
            l1.val = sum % 10;
            tmp = sum / 10;
            last = l1;
            l1 = l1.next;
        }
        if (tmp != 0) {
            last.next = new ListNode(1);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
```

## 思路讲解

主要考察的就是指针操作 & 边界 case 的考虑

* 双指针推进
* 进位缓存
* l1 == null or l2 == null
* tmp != 0

看了 [题解](https://leetcode-cn.com/problems/add-two-numbers/solution/hua-jie-suan-fa-2-liang-shu-xiang-jia-by-guanpengc/), 很好
小技巧：对于链表问题，返回结果为头结点时，通常需要先初始化一个预先指针 pre，该指针的下一个节点指向真正的头结点head。**使用预先指针的目的在于链表初始化时无可用节点值，而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果。**

```Java []
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
}
```

性能分析

1. 时间: 一次遍历 O(max(n,m))=O(n)
1. 空间: 常量 O(1)
