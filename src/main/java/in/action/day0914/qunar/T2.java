package in.action.day0914.qunar;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * 隔离度：所谓六度人脉关系理论（Six Degrees of
 * Separation），是指地球上所有的人都可以通过六层以内的熟人链和任何其他人联系起来。通俗地讲：“你和任何一个陌生人之间所间隔的人不会超过六个，也就是说，最多通过六个人你就能够认识任何一个陌生人。”
 * 
 * 在六度人脉关系理论中有一个 “最大隔离度” 的概念：是在所有两人之间的隔离度中取最大值。如果网络中的两个人之间没有连接，则称这个网络是不连通的。
 * 
 * 输入 输入包含一组描述由人组成的网络的测试用例。测试用例的第一行是两个整数 P(2<=P<=50) 和 R(R>=1),
 * 分别表示网络中包含的人数和网络中的关系数。接下来输入 R
 * 对关系，每对关系由两个字符串组成，表示网络中这对关系所关联的两个人的名字。在本题中，名字是唯一的，且不包含空白字符。因为一个人可能与多个人有关系，所以同一个名字可能在一个测试用例中出现若干次。
 * 
 * 输出 对于测试用例，输入测试用例的编号和最大隔离度。如果该网络是不联通的，则输出 “DISCONNECTED”。
 * 
 * 样例输入 4 4 ChuQiao YuwenYue YanXun YuanChun YanXun YuwenYue YuwenYue YuanChun
 * 
 * 样例输出 2
 * 
 */
public class T2 {
	public static int[][] m;

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int p = in.nextInt();
			int r = in.nextInt();
			String[] persons = new String[p];
			Map<String, Integer> personSet = new HashMap<>();
			m = new int[p][p];
			String tmpPer1 = null, tmpPer2 = null;
			Integer index1, index2;
			int count = 0;
			for (int i = 0; i < r; i++) {
				tmpPer1 = in.next();
				tmpPer2 = in.next();
				if ((index1 = personSet.get(tmpPer1)) == null) {
					personSet.put(tmpPer1, index1 = count++);
					persons[index1] = tmpPer1;
				}
				if ((index2 = personSet.get(tmpPer2)) == null) {
					personSet.put(tmpPer2, index2 = count++);
					persons[index2] = tmpPer2;
				}
				m[index1][index2] = m[index2][index1] = 1;
			}
			for (int i = 0; i < p; i++) {
				for (int j = 0; j < p; j++) {
					if (i == j) {
						continue;
					}
					if (m[i][j] == 0) {
						m[i][j] = Integer.MAX_VALUE;
					}
				}
			}
			floyd();
			int max = 0;
			for (int i = 0; i < p; i++) {
				for (int j = 0; j < p; j++) {
					if (i == j) {
						continue;
					}
					if (m[i][j] == Integer.MAX_VALUE) {
						System.out.println("DISCONNECTED");
						return;
					}
					if (m[i][j] > max) {
						max = m[i][j];
					}
				}
			}
			System.out.println(max);
		}
	}

	public static void floyd() {
		for (int k = 0; k < m.length; k++)
			for (int i = 0; i < m.length; i++)
				for (int j = 0; j < m.length; j++) {
					if (m[i][k] == Integer.MAX_VALUE || m[k][j] == Integer.MAX_VALUE)
						continue;
					if (m[i][j] > m[i][k] + m[k][j])
						m[i][j] = m[i][k] + m[k][j];
				}
		return;
	}
}
