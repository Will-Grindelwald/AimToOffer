# Array_Easy_121_Best_Time_to_Buy_and_Sell_Stock

Date: 2016.9.21

[题目在这](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

> Say you have an array for which the ith element is the price of a given stock on day i.

> If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

> Example 1:
>> Input: [7, 1, 5, 3, 6, 4]  
Output: 5

>> max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)

> Example 2:
>> Input: [7, 6, 4, 3, 1]  
Output: 0

>> In this case, no transaction is done, i.e. max profit = 0.

Accepted result:

```c
int maxProfit(int* prices, int pricesSize) {
    int max = 0;
    for (int min = 0, cur = 0; cur < pricesSize; cur++) {
        if(prices[cur] < prices[min]) min = cur;
        if(prices[cur] - prices[min] > max) max = prices[cur] - prices[min];
    }
    return max;
}
```
