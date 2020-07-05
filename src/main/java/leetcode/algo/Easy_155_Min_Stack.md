# Easy_155_Min_Stack

Date: 2020-07-05

## [题目](https://leetcode-cn.com/problems/min-stack/)

设计一个支持 `push` ，`pop` ，`top` 操作，并能在常数时间内检索到最小元素的栈。

* `push(x)` -- 将元素 x 推入栈中。
* `pop()` -- 删除栈顶的元素。
* `top()` -- 获取栈顶元素。
* `getMin()` -- 检索栈中的最小元素。

示例:

* 输入：

    ["MinStack","push","push","push","getMin","pop","top","getMin"]
    [[],[-2],[0],[-3],[],[],[],[]]

* 输出：

    [null,null,null,null,-3,null,0,-2]

* 解释：

    ```
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.getMin(); --> 返回 -3.
    minStack.pop();
    minStack.top(); --> 返回 0.
    minStack.getMin(); --> 返回 -2.
    ```

提示：

* `pop`、`top` 和 `getMin` 操作总是在 **非空栈** 上调用。

Related Topics

* 栈
* 设计

## Accepted result:

```java
class MinStack {

    private final Stack<Integer> stack = new Stack<>();

    private final Stack<Integer> min = new Stack<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {
    }

    public void push(int x) {
        if (stack.empty()) {
            stack.push(x);
            min.push(x);
        } else {
            stack.push(x);
            min.push(Math.min(x, min.peek()));
        }
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
```

## 思路讲解

双栈 or 单栈 + Pair

oj 的系统里没有可用的 Pair，用双栈一样，内存稍大一点

那种 `辅助栈和数据栈不同步` 的思路没必要，没有本质的提升
