# Array_Easy_27_Remove_Element

Date: 2016.9.13

[题目在这](https://leetcode.com/problems/remove-element/)

> Given an array and a value, remove all instances of that value in place and return the new length.

> Do not allocate extra space for another array, you must do this in place with constant memory.

> The order of elements can be changed. It doesn't matter what you leave beyond the new length.

>> Example:

>> Given input array nums = [3,2,2,3], val = 3

>Your function should return length = 2, with the first two elements of nums being 2.

Accepted result:

```c
int removeElement(int* nums, int numsSize, int val) {
    int len = 0;
    for(int i = 0; i < numsSize; i++)
        if(nums[i] != val) nums[len++] = nums[i];
    return len;
}
```
