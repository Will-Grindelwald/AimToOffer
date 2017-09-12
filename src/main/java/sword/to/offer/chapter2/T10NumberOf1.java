package sword.to.offer.chapter2;

/**
 * 
 * 输入一个整数，输出该数二进制表示中 1 的个数。其中负数用补码表示。
 * 
 */
public class T10NumberOf1 {

	public int NumberOf1(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n = n & (n - 1);
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(new T10NumberOf1().NumberOf1(5));
	}
}
