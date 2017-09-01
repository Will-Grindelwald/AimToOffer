package chapter2;

/**
 * 
 * 法一：归纳法：一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级…… 它也可以跳上 n 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 
 * f(n) = 1 + f(1) + f(2) + ... + f(n - 2) + f(n - 1), and f(1) = 1
 * 
 * ==> f(n) = 2^n;
 * 
 * 法二：解释：每个台阶都有跳与不跳两种情况（除了最后一个台阶），最后一个台阶必须跳。所以共用 2^(n-1) 中情况
 * 
 */
public class T09Fibonacci3 {

	public int JumpFloorII(int n) {
//		return (int) Math.pow(2, n);
		return 1 << (n -1); // 可以用位运算实现
	}

	public static void main(String[] args) {
		System.out.println(new T09Fibonacci3().JumpFloorII(5));
	}
}
