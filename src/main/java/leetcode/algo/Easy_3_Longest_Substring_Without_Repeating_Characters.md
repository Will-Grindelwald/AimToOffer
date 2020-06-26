# String_Easy_3_Longest_Substring_Without_Repeating_Characters

Date: 2020-06-26

## [题目](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)

给定一个字符串，请你找出其中不含有重复字符的 **最长子串** 的长度。

**示例 1:**

    输入: "abcabcbb"
    输出: 3 
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

**示例 2:**

    输入: "bbbbb"
    输出: 1
    解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

**示例 3:**

    输入: "pwwkew"
    输出: 3
    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
         请注意，你的答案必须是子串的长度，"pwke" 是一个子序列，不是子串。

Related Topics

* 哈希表
* 双指针
* 字符串
* Sliding Window

## Accepted result:

```java
class Solution {

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        if (chars.length < 1) {
            return 0;
        }
        int max = 1, lenth = 1, i = 0, j = 1;
        Set<Character> charSet = new HashSet<>();
        charSet.add(chars[0]);
        while (j < chars.length) {
            if (charSet.add(chars[j])) {
                lenth++;
                max = Math.max(max, lenth);
            } else {
                while (i < j) {
                    if (chars[i] == chars[j]) {
                        i++;
                        lenth = j - i + 1;
                        break;
                    } else {
                        charSet.remove(chars[i]);
                        i++;
                    }
                }
            }
            j++;
        }
        return max;
    }
}
```

## 思路讲解

根据提示"子序列不是子串", 子串->双指针遍历

cache maxLenth

边界 case: 空串

性能分析

1. 时间: 两次遍历 O(2n)=O(n)
1. 空间: hashSet O(n)

看了 [题解](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-jie-suan-fa-3-wu-zhong-fu-zi-fu-de-zui-chang-z/)
我用了 set, 它用了 map, 省掉了我内嵌的那次 while, 赞👍

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }
}
```
