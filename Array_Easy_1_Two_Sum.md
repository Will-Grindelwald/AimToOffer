# Array_Easy_1_Two_Sum

Date: 2016.9.12

[题目在这](https://leetcode.com/problems/two-sum/)

> Given an array of integers, return indices of the two numbers such that they add up to a specific target.

> You may assume that each input would have exactly one solution.

> Example:

>> Given nums = [2, 7, 11, 15], target = 9,

>> Because nums[0] + nums[1] = 2 + 7 = 9,return [0, 1].

>UPDATE (2016/2/13):  
The return format had been changed to zero-based indices. Please read the above updated description carefully.

Accepted result:

```c
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* twoSum(int* nums, int numsSize, int target) {
    int *a = (int *)calloc(2, sizeof(int));
    for (a[0] = 0; a[0] < numsSize; ++a[0])
    {
        for (a[1] = a[0] + 1; a[1] < numsSize; ++a[1])
        {
            if(a[0] == a[1]) continue;
            if((nums[a[0]] + nums[a[1]]) == target) goto L; // 因为只有一个解
        }
    }
L:  return a;
}
```
