package day825.am;

/**
 * 
 * N 个孩子，每个的力量 Xi，有 M 张卡片，每张卡片上有一对数字，表示这两个孩子属于同一组，
 * 其位置未在任何一张卡片上出现的孩子作为一个单人组参加。每组的实力是该组孩子实力的和，求实力最大的组的实力。
 * 
 */
public class MB2 {
	public static void main(String[] args) {
		int nok = 4;
		int noc = 3;
		int[][] pair = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 1 } };
		int[] strength = new int[] { 11, 2, 3, 5 };

		// 用并查集做
		int[] ufSet = new int[nok];
		for (int i = 0; i < pair.length; i++) {
			int num1 = pair[i][0], num2 = pair[i][1];
			while (ufSet[num2 - 1] != 0) {
				num2 = ufSet[num2 - 1];
			}
			while (ufSet[num1 - 1] != 0) {
				num1 = ufSet[num1 - 1];
			}
			if (num1 > num2) {
				int tmp = pair[i][1];
				num1 = num2;
				num2 = tmp;
			}
			if (num1 == num2)
				continue;
			ufSet[num2 - 1] = num1;
			// System.out.println(Arrays.toString(ufSet));
		}
		for (int i = nok - 1; i >= 0; i--) {
			if (ufSet[i] != 0) { // 非树根 or 计算过
				strength[ufSet[i] - 1] += strength[i];
				strength[i] = 0;
			}
		}
		// System.out.println(Arrays.toString(strength));
		int max = 0;
		for (int i = 0; i < nok; i++) {
			if (max < strength[i])
				max = strength[i];
		}
		System.out.println(max);
	}
}
