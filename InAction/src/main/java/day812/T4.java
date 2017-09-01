package day812;

import java.util.Scanner;

/**
 * 
 * 小易有一个长度为 n 的整数序列, a_1,...,a_n。然后考虑在一个空序列 b 上进行 n 次以下操作: 1、将 a_i 放入 b 序列的末尾
 * 2、逆置 b 序列 小易需要你计算输出操作 n 次之后的 b 序列。
 * 
 * 输入描述: 输入包括两行, 第一行包括一个整数 n(2 ≤ n ≤ 2*10^5), 即序列的长度。 第二行包括 n 个整数 a_i(1 ≤ a_i ≤
 * 10^9), 即序列 a 中的每个整数, 以空格分割。
 * 
 * 输出描述: 在一行中输出操作 n 次之后的 b 序列, 以空格分割, 行末无空格。
 * 
 * 输入例子 1: 4 1 2 3 4
 * 
 * 输出例子 1: 4 2 1 3
 *
 */
/**
 * 
 * 解：
 * 
 * 4: 42 13
 * 
 * 5: 531 24
 * 
 * 6: 642 135
 * 
 */
public class T4 {
	public static void main(String[] args) {
		int n = 0;
		int[] arr = null;
		try (Scanner in = new Scanner(System.in)) {
			n = in.nextInt();
			arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
			}
		}
		/* // 未优化版
		int i = 0;
        for (i = n - 1; i >= 0; i -= 2) {
            if (i == n - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(' ');
                System.out.print(arr[i]);
            }
        }
        if (n % 2 == 0) {
            for (i++; i < n; i += 2) {
                System.out.print(' ');
                System.out.print(arr[i]);
            }
        } else {
            for (i += 3; i < n; i += 2) {
                System.out.print(' ');
                System.out.print(arr[i]);
            }
        }
		*/
		for (int i = n - 1; i >= 0; i -= 2) { // 前一半从最后一个数开始以 2 为步长递减
			System.out.print(arr[i] + " ");
		}
		for (int i = n % 2; i < n - 2; i += 2) { 
			// 后一半根据整数个数的奇偶，分别从第二个或第一个数开始以 2 为步长递增
			// 为了格式，n - 2 单独打印
			System.out.print(arr[i] + " ");
		}
		System.out.print(arr[n - 2]); // 最后一个数
	}
}
