# Easy_20_Valid_Parentheses

Date: 2020-07-05

## [题目](https://leetcode-cn.com/problems/valid-parentheses/)

给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 

有效字符串需满足：

1.  左括号必须用相同类型的右括号闭合。
2.  左括号必须以正确的顺序闭合。

注意空字符串可被认为是有效字符串。

示例 1:

**输入:** "()"
**输出:** true

示例 2:

**输入:** "()[]{}"
**输出:** true

示例 3:

**输入:** "(]"
**输出:** false

示例 4:

**输入:** "([)]"
**输出:** false

示例 5:

**输入:** "{[]}"
**输出:** true

Related Topics

* 栈
* 字符串

## Accepted result:

```java
class Solution {

    private static final Map<Character, Character> match = new HashMap<>();

    static {
        match.put(')', '(');
        match.put('}', '{');
        match.put(']', '[');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (match.containsKey(c)) {
                if (stack.empty() || !stack.pop().equals(match.get(c))) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
    }
}
```

## 思路讲解

简单题。

提交两次才过，漏了上来就要 pop() 的情况 "]"。

没有 stack 的时候，用 list 模拟
