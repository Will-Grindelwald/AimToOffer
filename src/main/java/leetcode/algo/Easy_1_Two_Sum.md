# Easy_1_Two_Sum

Date: 2020-06-22

## [题目](https://leetcode-cn.com/problems/two-sum/)

给定一个整数数组 `nums` 和一个目标值 `target`，请你在该数组中找出和为目标值的那 **两个** 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

**示例:**

    给定 nums = [2, 7, 11, 15], target = 9

    因为 nums[0] + nums[1] = 2 + 7 = 9
    所以返回 [0, 1]

Related Topics

* 数组
* 哈希表

## Accepted result:

```java
class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> value2Index = new HashMap<>(4);
        for (int i = 0; i < nums.length; i++) {
            if (value2Index.containsKey(target - nums[i])) {
                return new int[]{value2Index.get(target - nums[i]), i};
            }
            value2Index.put(nums[i], i);
        }
        throw new RuntimeException();
    }
}
```

## 思路讲解

暴力解法就是双循环.

减少搜索, 就要同时记住 value & index(因为最后输出 index), 所以用 map. 最后输出 value 的话, set 就行.

性能分析

1. 时间: 一层循环 + hash O(1) 的搜索, O(n)
1. 空间: hash 表, O(n)
