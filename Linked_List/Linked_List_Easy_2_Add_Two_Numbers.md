# Linked_List_Easy_2_Add_Two_Numbers

Date: 2016.9.14

[题目在这](https://leetcode.com/problems/add-two-numbers/)

> You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

> Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)

> Output: 7 -> 0 -> 8

Accepted result:

```c
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2) {
    int n = 0;
    struct ListNode *resL, *temp1, *temp2;
    temp2 = resL = (struct ListNode *)calloc(1, sizeof(struct ListNode));
    while(l1 && l2) {
        temp1 = temp2;
        temp1->val = l1->val + l2->val + n;
        n = 0;
        if(temp1->val > 9) {
            temp1->val %= 10;
            n = 1;
        }
        l1 = l1->next;
        l2 = l2->next;
        temp1->next = temp2 = (struct ListNode *)calloc(1, sizeof(struct ListNode));
    }
    l1 = l1 ? l1 : l2;
    while(l1) {
        temp1 = temp2;
        temp1->val = l1->val + n;
        n = 0;
        if(temp1->val > 9) {
            temp1->val %= 10;
            n = 1;
        }
        l1 = l1->next;
        temp1->next = temp2 = (struct ListNode *)calloc(1, sizeof(struct ListNode));
    }
    if(n) {
        temp1 = temp2;
        temp1->val = n;
    } else free(temp2);
    temp1->next = NULL;
    return resL;
}
```
