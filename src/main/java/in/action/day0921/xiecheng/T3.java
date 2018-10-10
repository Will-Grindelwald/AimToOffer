package in.action.day0921.xiecheng;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * <pre>
 * 输入为一个无序数组，输出数组中不存在的最小正整数。

输入
第一行为数组大小 n
接下来 n 行为数组元素
输出
正整数

样例输入
5
3
4
-1
1
6
样例输出
2
 * </pre>
 * 
 */
public class T3 {
	public static void main(String[] args) {
		int[] a = null;
		try (Scanner in = new Scanner(System.in)) {
			a = new int[in.nextInt()];
			for (int i = 0; i < a.length; i++) {
				a[i] = in.nextInt();
			}
		}
		System.out.println(findMinMis(a));
	}

	public static int findMinMis(int[] a) {
		Arrays.sort(a);
		int res = Arrays.binarySearch(a, 1);
		if (res < 0)
			return 1;
		int i = res + 1, j = 2;
		for (i = res + 1, j = 2; i < a.length; i++, j++) {
			if (a[i] != j)
				break;
		}
		return j;
	}
}
