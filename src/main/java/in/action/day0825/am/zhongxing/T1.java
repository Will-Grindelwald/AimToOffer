package in.action.day0825.am.zhongxing;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 给定锁定密钥，求解锁密钥，计算方式：解锁密钥是锁定密钥中数字的最小排列(数量上)，且不会以 0 开头。-10^5<=锁定密钥<=10^5
 * 
 */
public class T1 {
	public static void main(String[] args) {
		long n = -100156746510008l;

		// 注意负数的情况
		boolean flag = false;
		if (n < 0)
			flag = true;
		List<Integer> nums = new ArrayList<>();
		while (n != 0) {
			nums.add((int) Math.abs(n%10));
			n /= 10;
		}
		nums.sort(null);
		long res = 0;
		if (flag) {
			for (int i = nums.size() - 1; i >= 0; i--) {
				res *= 10;
				res += nums.get(i);
			}
			System.out.println(-res);
		} else {
			for (int i = 0, k = nums.size(); i < k; i++) {
				if (nums.get(i) == 0)
					continue;
				res *= 10;
				if (res == 0) {
					res += nums.get(i);
					for (int j = i; j > 0; j--) {
						res *= 10;
					}
				} else {
					res += nums.get(i);
				}
			}
			System.out.println(res);
		}
	}
}
