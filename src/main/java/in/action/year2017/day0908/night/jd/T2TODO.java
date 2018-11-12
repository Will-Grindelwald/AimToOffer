package in.action.year2017.day0908.night.jd;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * 题目见图
 * 
 */
/**
 * 
 * 牛妹的答案
 * 
 * 裸暴力(4 重 for)只能拿 20% 的分
 * 
 * 我们考虑去枚举 n 范围内的所有 i, 然后处理出 i 的幂那些数。 考虑对于 i ^ x, 我们需要计算满足 (i ^ x) ^ c = (i ^ y)
 * ^ d 的数量, 其中 i ^ x, i ^ y <= n. 这些我们可以通过预处理出来。 然后对于 (i ^ x) ^ c = (i ^ y) ^ d
 * 其实意味着 x c = y d, 意味着 (x / y) = (d / c), 其中 x, y 我们可以在预处理之后枚举出来, 于是我们就可以借此计算出
 * n 范围内有多少不同这种 c 和 d 去满足等式。 其实就等于 n / max(x / gcd(x, y), y / gcd(x, y)),
 * 然后都累加进答案。gcd() 表示最大公约数。 中间可能产生重复枚举, 我们用一个 set 或者 hash 容器标记一下就好。
 * 
 * 以上枚举对于 2~sqrt(n)。最后对于大于 sqrt(n) 的部分, 每个的贡献都是 n。(因为当 a 大于 sqrt(n), 仅有 a^i=a^i)
 * 
 */
// https://www.nowcoder.com/discuss/38889
public class T2TODO {
	
	public static void main(String[] args) {
		int n = 0;
		try (Scanner in = new Scanner(System.in)) {
			n = in.nextInt();
		}
		long ans = (long) 1 * n * (n * 2 - 1) % 1_000_000_007;
		Set<Integer> set = new HashSet<>();
		for (int i = 2; i * i <= n; i++) {
			if (set.contains(i))
				continue;
			long tmp = i;
			int cnt = 0;
			while (tmp <= n) { // i^2 i^3....放入 set
				set.add((int) tmp);
				tmp = tmp * i;
				cnt++;
			}
			for (int k = 1; k <= cnt; k++) {
				for (int j = k + 1; j <= cnt; j++) {
					ans = (ans + n / (j / gcd(k, j)) * (long) 2) % 1_000_000_007;
				}
			}
		}
		System.out.println(ans);
	}

	public static long gcd(long a, long b) {
		return (a % b == 0) ? b : gcd(b, a % b);
	}
}
