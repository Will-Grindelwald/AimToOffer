# Array_Easy_189_Rotate_Array

Date: 2016.9.17

[题目在这](https://leetcode.com/problems/rotate-array/)

> Rotate an array of n elements to the right by k steps.

> For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

> Note:  
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

Accepted result:

```c
void rotate(int* nums, int numsSize, int k) {
    k %= numsSize;
    reverse(nums, numsSize);
    reverse(nums, k);
    reverse(nums + k, numsSize - k);
}

void reverse(int* nums, int numsSize) {
    int i, temp, k = numsSize / 2;
    for (i = 0; i < k; i++) {
        temp = nums[i];
        nums[i] = nums[numsSize - i - 1];
        nums[numsSize - i - 1] = temp;
    }
}
```
