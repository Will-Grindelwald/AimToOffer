package in.action.year2017.day0921.xiecheng;

import java.util.Scanner;

/**
 * 
 * 
 * <pre>
 * 两个已排好序的数组，找出两者合并后的数组的中位数。
例如：
给出 A=[1,2,3,4,5,6] 和 B=[2,3,4,5]，它们合并后的数组是 [1,2,3,4,5,6]，合并后数组的中位数是 3.5(注：(3+4)/2)。
给出 A=[1,2,3] 和 B=[4,5]，它们合并后的数组是 [1,2,3,4,5]，合并后数组的中位数是 3。
输入
第一行读入一个正整数 n，表示第一个数组的元素个数，第二行读入 n 个递增整数，表示第一个排好序的数组，第三行读入一个正整数 m，表示第二个数组的元素个数，第四行读入 m 个递增整数，表示第二个排好序的数组
输出
合并后数组的中位数

样例输入
6
1 2 3 4 5 6
4
2 3 4 5
样例输出
3.5

Hint
请尽可能降低时间复杂度
 * </pre>
 * 
 */
public class T2HARD {
	public static void main(String[] args) {
		int[] a = null, b = null;
		try (Scanner in = new Scanner(System.in)) {
			a = new int[in.nextInt()];
			for (int i = 0; i < a.length; i++) {
				a[i] = in.nextInt();
			}
			b = new int[in.nextInt()];
			for (int i = 0; i < b.length; i++) {
				b[i] = in.nextInt();
			}
			compute(a, b);
		}
	}

	public static void compute(int[] a, int[] b) {
		int aMin = 0, aMax = a.length - 1, bMin = 0, bMax = b.length - 1;
		int low, high;
		if (a[aMin] > b[bMin]) {
			low = b[bMin++];
		} else {
			low = a[aMin++];
		}
		if (a[aMax] < b[bMax]) {
			high = b[bMax--];
		} else {
			high = a[aMax--];
		}
		int nextLow = low, nextHigh = high;
		boolean flag = true;
		L: while (aMin <= aMax && bMin <= bMax) {
			low = nextLow;
			high = nextHigh;
			while (nextLow == low) {
				if (aMin <= aMax && bMin <= bMax) {
					if (a[aMin] > b[bMin]) {
						nextLow = b[bMin++];
					} else {
						nextLow = a[aMin++];
					}
				} else if (aMin <= aMax) {
					nextLow = a[aMin++];
				} else if (bMin <= bMax) {
					nextLow = b[bMin++];
				} else {
					flag = true;
					break L;
				}
			}
			while (nextHigh == high) {
				if (aMin <= aMax && bMin <= bMax) {
					if (a[aMax] > b[bMax]) {
						nextHigh = b[bMax--];
					} else {
						nextHigh = a[aMax--];
					}
				} else if (aMin <= aMax) {
					nextHigh = a[aMax--];
				} else if (bMin <= bMax) {
					nextHigh = b[bMax--];
				} else {
					flag = false;
					break L;
				}
			}
		}
		if (flag) {
			System.out.println(((double) nextLow + nextHigh) / 2);
		} else {
			System.out.println(nextLow);
		}
	}
}
