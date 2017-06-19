package day519;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * 牛牛举办了一次编程比赛, 参加比赛的有 3*n 个选手, 每个选手都有一个水平值 a_i. 现在要将这些选手进行组队, 一共组成 n 个队伍, 即每个队伍
 * 3 人. 牛牛发现队伍的水平值等于该队伍队员中第二高水平值。 例如: 一个队伍三个队员的水平值分别是 3,3,3. 那么队伍的水平值是 3
 * 一个队伍三个队员的水平值分别是 3,2,3. 那么队伍的水平值是 3 一个队伍三个队员的水平值分别是 1,5,2. 那么队伍的水平值是 2
 * 为了让比赛更有看点, 牛牛想安排队伍使所有队伍的水平值总和最大。 如样例所示: 如果牛牛把 6 个队员划分到两个队伍 如果方案为:
 * team1:{1,2,5}, team2:{5,5,8}, 这时候水平值总和为 7. 而如果方案为: team1:{2,5,8},
 * team2:{1,5,5}, 这时候水平值总和为 10. 没有比总和为 10 更大的方案, 所以输出 10.
 * 
 * 输入描述: 输入的第一行为一个正整数 n(1 ≤ n ≤ 10^5), 第二行包括 3*n 个整数 a_i(1 ≤ a_i ≤ 10^9),
 * 表示每个参赛选手的水平值.
 * 
 * 输出描述: 输出一个整数表示所有队伍的水平值总和最大值.
 * 
 * 输入例子: <br>
 * 2 <br>
 * 5 2 8 5 1 5
 * 
 * 输出例子: 10
 *
 */
public class T6 {
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int num = in.nextInt();
			int[] data = new int[3 * num];
			for (int i = 0; i < 3 * num; i++) {
				data[i] = in.nextInt();
			}
			Arrays.sort(data);

			int sum = 0;
			int count = 0;
			for (int i = data.length - 2; (i >= 0) && (count != num); i -= 2) {
				sum += data[i];
				count++;
			}
			System.out.println(sum);
		}
	}
}
