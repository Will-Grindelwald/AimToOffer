package chapter2;

/**
 * 
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 
 */
public class T09Fibonacci2 {

	public int JumpFloor(int n) {
		if (n <= 0)
			return 0;
		int a = 1, b = 1;
		for (int i = 2; i <= n; i++) {
			b = b + a;
			a = b - a;
		}
		return b;
	}

	public static void main(String[] args) {
		System.out.println(new T09Fibonacci2().JumpFloor(39));
	}
}
