package sword.to.offer.chapter2;

/**
 * 
 * 大家都知道斐波那契数列，现在要求输入一个整数 n，请你输出斐波那契数列的第 n 项。 n <= 39
 * 
 */
public class T09Fibonacci {

	public long Fibonacci(int n) {
		if (n <= 0)
			return 0;
		long a = 0, b = 1;
		for (int i = 2; i <= n; i++) {
			b = b + a;
			a = b - a;
		}
		return b;
	}

	// logN 性能的求斐波那契数
	/*
	 * 观察:f(n)
	 * 
	 * = 1 * f(n - 1) + 1 * f(n - 2)
	 * 
	 * = 2 * f(n - 2) + 1 * f(n - 3)
	 * 
	 * = 3 * f(n - 3) + 2 * f(n - 4)
	 * 
	 * = 5 * f(n - 4) + 3 * f(n - 5)
	 * 
	 * = ... ...
	 * 
	 * = f(k) * f(n - k + 1) + f(k - 1) * f(n - k)
	 * 
	 * 1、若令 n = 2k, 得 f(2k)
	 * 
	 * = f(k) * f(k + 1) + f(k-1) * f(k)
	 * 
	 * = f(k) * [f(k) + f(k - 1)] + f(k-1) * f(k)
	 * 
	 * = f(k) ^ 2 + 2 * f(k) * f(k - 1)
	 * 
	 * 2、若令 n = 2k - 1, 得 f(2k - 1)
	 * 
	 * = f(k) * f(k) + f(k - 1) * f(k - 1)
	 * 
	 * = f(k) ^ 2 + f(k - 1) ^ 2
	 * 
	 */
	// 每次 Fibonacci2 调用后: pre: 存的都是f(n)的值， post: 存的都是 f(n-1)的值。
	static long pre = 0;
	static long post = 0;

	public long Fibonacci2(int n) {
		if (n <= 0)
			return 0;
		else if (n == 2 || n == 1) {
			pre = post = 1;
			return 1;
		}
		if (n % 2 == 1) {
			// n 为奇数， 则做减 1 操作
			Fibonacci2(n - 1);
			// post： f(n - 1) = f(n) - f(n - 2)
			pre = pre + post;
			// pre： f(n) = f(n - 1) + f(n - 2)
			post = pre - post;
			return pre;
		} else { // logN 体现在这
			// n 为偶数时不断除2, f(n) 通过 f(n/2) 来计算:
			Fibonacci2(n / 2);
			// f(2k) = f(k)^2 + 2 * f(k) * f(k - 1)
			long temp = pre * pre + 2 * pre * post;
			// f(2k - 1) = f(k) * f(k) + f(k - 1) * f(k - 1)
			post = pre * pre + post * post;
			return pre = temp;
		}
	}

	public static void main(String[] args) {
		System.out.println(new T09Fibonacci().Fibonacci2(160));
	}
}
