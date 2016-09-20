# Array_Easy_118_Pascal's_Triangle

Date: 2016.9.18

[题目在这](https://leetcode.com/problems/pascals-triangle/)

> Given numRows, generate the first numRows of Pascal's triangle.

> For example, given numRows = 5,

> Return

> [  
　　　　　[ 1 ],  
　　　　[ 1,　1 ],  
　　　[ 1,　2,　1 ],  
　　[ 1,　3,　3,　1 ],  
　[ 1,　4,　6,　4,　1 ]  
]

Accepted result:

```c
/**
 * Return an array of arrays.
 * The sizes of the arrays are returned as *columnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
int** generate(int numRows, int** columnSizes) {
    int **res = (int **)calloc(numRows, sizeof(int*));
    *columnSizes = (int *)calloc(numRows, sizeof(int));
    for(int i = 0; i < numRows; i++) {
        res[i] = (int *)calloc(i + 1, sizeof(int));
        res[i][0] = 1;
        (*columnSizes)[i] = i + 1;
        for (int j = 1; j < i; j++) {
            res[i][j] = res[i - 1][j - 1] + res[i - 1][j];
        }
        res[i][i] = 1;
    }
    return res;
}
```
