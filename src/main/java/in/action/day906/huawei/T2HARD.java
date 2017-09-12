package in.action.day906.huawei;

import java.util.Scanner;

/**
 * 
 * 100 个人围成一圈，每个人有一个编码，编号从 1 开始到 100。他们从 1 开始依次报数，报到为 M 的人自动退出圈圈，然后下一个人接着从 1
 * 开始报数，直到剩余的人数小于 M。请问最后剩余的人在原先的编号为多少？ 例如输入 M=3 时，输出为： “58,91” ，输入 M=4 时，输出为：
 * “34,45,97”。
 * 
 * 输入描述: 函数原型：void NumberOffGame(int m, char* output); 输入的 m，m 为大于 1 且小于 100
 * 的整数。
 * 
 * 输出描述: 输出 output，其中 output 已经分配足够的内存空间，无需单独分配；
 * 
 * 如果 m 输入小于等于 1，则输出 “ERROR!”；
 * 
 * 如果 m 输入大于等于 100，则输出 “ERROR!”；
 * 
 * 否则按照编号从小到大的顺序，以“,”分割输出编号字符串，输出的字符串中标点符号均为半角字符。 示例 1 输入
 * 
 * 3 输出
 * 
 * 58,91
 * 
 */
// 约瑟夫环变体
public class T2HARD {
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int m = in.nextInt();
			System.out.println(NumberOffGame(m));
			System.out.println(NumberOffGame2(m));
		}
	}

	private static String NumberOffGame(int m) { // 暴力模拟
		if (m <= 1 || m >= 100) {
			return "ERROR!";
		}
		int[] arr = new int[100];
		for (int i = 0, k = -1; i <= 100 - m; i++) { // 要去掉 101 - m 个数
			for (int j = 0; j < m; j++) { // m 步
				do { // k 必须先++一次，用 do-while
					if (++k == 100) {
						k = 0;
					}
				} while (arr[k] == -1);
			}
			arr[k] = -1;
		}
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] == 0) {
				sb.append((j + 1) + ",");
			}
		}
		return sb.substring(0, sb.length() - 1);
	}

	private static String NumberOffGame2(int m) { // 动态规划
		
		return null;
	}
}
