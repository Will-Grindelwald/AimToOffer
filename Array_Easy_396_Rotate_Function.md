# Array_Easy_396_Rotate_Function

Date: 2016.9.14

[题目在这](https://leetcode.com/problems/rotate-function/)

> Given an array of integers A and let n to be its length.

> Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F on A as follow:

> F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].

> Calculate the maximum value of F(0), F(1), ..., F(n-1).

> Note:

> n is guaranteed to be less than 10^5.


>> Example:

>> A = [4, 3, 2, 6]

>> F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25  
>> F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16  
>> F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23  
>> F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26  

>> So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.

Accepted result:

```c
int maxRotateFunction(int* A, int ASize) {
    int max = 0, c = 0;
    for (int j = 0; j < ASize; j++) {
        max += A[j] * j;
        c += A[j];
    }
    for (int i = 1, temp = max; i < ASize; i++) {
        temp += c - ASize * A[ASize - i]; // 精髓
        if(temp > max) max = temp;
    }
    return max;
}
```

Note:

　　一开始写了个 O(n^2) 的答案，被最后一条 case 挡住了，最后一条 case 应该是有 10^5 长的数组，就 time out 了，才想到去挖掘问题的核心，才有了这个 O(n) 的解
