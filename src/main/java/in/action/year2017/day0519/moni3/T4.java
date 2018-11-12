package in.action.year2017.day0519.moni3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * 牛牛有一个数组，里面的数可能不相等，现在他想把数组变为：所有的数都相等。问是否可行。 牛牛可以进行的操作是：将数组中的任意一个数改为这个数的两倍。
 * 这个操作的使用次数不限，也可以不使用，并且可以对同一个位置使用多次。
 * 
 * 输入描述: 输入一个正整数 N (N <= 50) 接下来一行输入 N 个正整数，每个数均小于等于 1e9.
 * 
 * 输出描述: 假如经过若干次操作可以使得N个数都相等，那么输出"YES", 否则输出"NO"
 * 
 * 输入例子: 2 1 2
 * 
 * 输出例子: YES
 * 
 */
public class T4 {
	public static void main(String[] args) {
		int number = 0;
		int[] array;
		try (Scanner in = new Scanner(System.in)) {
			number = in.nextInt();
			array = new int[number];
			for (int i = 0; i < number; i++) {
				array[i] = in.nextInt();
			}
		}
		Arrays.sort(array);
		for (int i = 1, tmp = array[0]; i < number; i++) {
			while (tmp < array[i])
				tmp *= 2;
			if (tmp != array[i]) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
}
