package sword.to.offer.chapter2;

/**
 * 
 * 我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，总共有多少种方法？
 * 
 * 依然 f(1) = 1, f(2) = 2, f(n) = f(n - 1) + f(n - 2)
 * 
 */
public class T09Fibonacci4 {

	public int RectCover(int n) {
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
		System.out.println(new T09Fibonacci4().RectCover(5));
	}
}
