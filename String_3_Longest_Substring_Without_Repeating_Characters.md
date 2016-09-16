# String_3_Longest_Substring_Without_Repeating_Characters

Date: 2016.9.15

[题目在这](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

> Given a string, find the length of the longest substring without repeating characters.

> Examples:

> Given "abcabcbb", the answer is "abc", which the length is 3.

> Given "bbbbb", the answer is "b", with the length of 1.

> Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

Accepted result:

```c
int lengthOfLongestSubstring(char* s) {
    char *p = s;
    int count = 0, len = 0;
    for (char *ss = s; *ss; ss++) {
        for (char *t = p; t != ss; t++)
            if (*ss == *t) {
                p = t + 1;
                break;
            }
        len = ss - p + 1;
        if (count < len) count = len;
    }
    return count;
}
```
