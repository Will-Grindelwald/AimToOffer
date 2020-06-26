# Array_Easy_283_Move_Zeroes

Date: 2016.9.19

[题目在这](https://leetcode.com/problems/move-zeroes/)

> Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

> For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

> Note:
>> You must do this in-place without making a copy of the array.  
>> Minimize the total number of operations.

> Credits:  
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Accepted result:

```c
void moveZeroes(int* nums, int numsSize) {
    int i, j;
    for(i = j = 0; i < numsSize; i++) {
        if(nums[i]) nums[j++] = nums[i];
    }
    while(j < numsSize) nums[j++] = 0;
}
```