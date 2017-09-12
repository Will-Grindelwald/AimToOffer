package in.action.day616.moni4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * 牛家庄幼儿园为庆祝 61 儿童节举办庆祝活动, 庆祝活动中有一个节目是小朋友们围成一个圆圈跳舞。牛老师挑选出 n 个小朋友参与跳舞节目,
 * 已知每个小朋友的身高 h_i。为了让舞蹈看起来和谐, 牛老师需要让跳舞的圆圈队形中相邻小朋友的身高差的最大值最小, 牛老师犯了难, 希望你能帮帮他。
 * 如样例所示: 当圆圈队伍按照 100, 98, 103, 105 顺时针排列的时候最大身高差为 5, 其他排列不会得到更优的解
 * 
 * 输入描述: 输入包括两行, 第一行为一个正整数 n(3 ≤ n ≤ 20) 第二行为 n 个整数 h_i(80 ≤ h_i ≤ 140),
 * 表示每个小朋友的身高。
 * 
 * 输出描述: 输出一个整数, 表示满足条件下的相邻小朋友身高差的最大值。
 * 
 * 输入例子: <br>
 * 4 <br>
 * 100 103 98 105
 * 
 * 输出例子: 5
 *
 */
public class T6MID {
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int num = in.nextInt();
			int[] data = new int[num];
			for (int i = 0; i < num; i++) {
				data[i] = in.nextInt();
			}
			Arrays.sort(data);
			int det = 0;
			det = data[1] - data[0] > data[num - 1] - data[num - 2] ? data[1] - data[0] : data[num - 1] - data[num - 2];
			for (int i = 2; i < num; i++) {
				det = det > data[i] - data[i - 2] ? det : data[i] - data[i - 2];
			}
			System.out.println(det);
		}
	}
}
