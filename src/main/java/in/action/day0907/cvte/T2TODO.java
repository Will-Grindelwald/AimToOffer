package in.action.day0907.cvte;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 给一个数 n，求 1~n 内，可以表示成三个素数的和的数
 * 
 */
// 好像写错了
public class T2TODO {
	public static void main(String[] args) {
		System.out.println(count(10));
	}

	private static int count(int number) {
		Integer[] primes = getPrimes(number);
		Set<Integer> set = new HashSet<>();
		for (Integer i : primes) {
			for (Integer j : primes) {
				if (i + j < number) {
					set.add(i + j);
				}
			}
		}
		int count = 0;
		for (Integer i : primes) {
			if (set.contains(number - i)) {
				count++;
			}
		}
		return count;
	}

	// 筛法求素数
	public static Integer[] getPrimes(int n) {
		Integer[] a = new Integer[n];
		for (int i = 2; i < n; i++) {
			a[i] = i;
		}
		// 筛法
		for (int i = 2; i < n; i++) {
			if (a[i] != 0) {
				for (int j = i * 2; j < n; j = j + i) {
					a[j] = 0;
				}
			}
		}
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (a[i] != 0) {
				count++;
			}
		}
		if (count > 0) {
			Integer[] primes = new Integer[count];
			int j = 0;
			for (int i = 2; i < n; i++) {
				if (a[i] != 0) {
					primes[j] = a[i];
					j++;
				}
			}
			return primes;
		}
		return null;
	}

	protected boolean isPrimeNumber(int num) {
		if (num == 2)
			return true;// 2特殊处理
		if (num < 2 || num % 2 == 0)
			return false;// 识别小于2的数和偶数
		for (int i = 3; i <= Math.sqrt(num); i += 2) {
			if (num % i == 0) {// 识别被奇数整除
				return false;
			}
		}
		return true;
	}
}
