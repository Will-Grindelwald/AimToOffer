package in.action.year2018.day1107.toutiao;

// 题目: 链表每k个反转
public class ConvertKOfList {
    public static void main(String[] args) {
        Node head = constructTestCase(50);
        printLinklist(head);
        head = convertK(head, 4);
        printLinklist(head);
    }

    public static Node convertK(Node head, int k) {
        Node vHead = new Node(-1);

        Node oldP = head;
        Node oldQ = head.next;
        Node newP = vHead;
        Node newQ = vHead.next = null;
        int i;
        while (oldP != null) {
            for (i = 0; oldP != null && i < k; i++) {
                // oldP 插入到 newP newQ 之间, 头插法
                oldQ = oldP.next;
                oldP.next = newQ;
                newP.next = oldP;
                oldP = oldQ;
                newQ = newP.next;
            }
            while (newP.next != null) {
                newP = newP.next;
            }
            newQ = newP.next;
        }
        return vHead.next;
    }

    public static Node constructTestCase(int deepth) {
        Node head = new Node(0);
        Node tmp = head;
        for (int i = 1; i < deepth; i++) {
            tmp = constructChild(tmp, i);
        }
        return head;
    }

    public static Node constructChild(Node head, int value) {
        Node child = new Node(value);
        head.next = child;
        return child;
    }

    public static void printLinklist(Node head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }
}

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}