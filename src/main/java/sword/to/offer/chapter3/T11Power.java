package sword.to.offer.chapter3;

/**
 * 
 * 给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent。求 base 的 exponent 次方。不用考虑大数问题。
 * 
 */
public class T11Power {

	public double Power(double base, int exponent) throws Exception {
		if (exponent == 0)
			return 1;
		/*
		 * 注意指数为负的情况， 其中 base 同时为 0，是错误输入
		 */
		System.out.println(base);
		if (exponent < 0) {
			if ((base - 0 < 0.0000000000001) && (base - 0 > -0.0000000000001))
				throw new RuntimeException("基数不能为0");
			base = 1 / base;
			exponent = -exponent;
		}
		/*
		 * 递归实现 快速幂
		 */
		// double half = Power(base, exponent >> 1);
		// half *= half;
		// if ((exponent & 0x01) == 1) {
		// half *= base;
		// }
		// return half;
		/*
		 * 循环实现 快速幂
		 */
		double res = 1;
		while (exponent > 0) {
			if ((exponent & 1) == 1)
				res = res * base;
			base *= base;
			exponent >>= 1;
		}
		return res;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(new T11Power().Power(3.0 - 3, -3));
	}
}
