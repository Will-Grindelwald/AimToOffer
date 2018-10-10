package in.action.day0909.wangyi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * 一个合法的括号匹配序列被定义为: 1. 空串 "" 是合法的括号序列 2. 如果 "X" 和 "Y" 是合法的序列, 那么 "XY"
 * 也是一个合法的括号序列 3. 如果 "X" 是一个合法的序列, 那么 "(X)" 也是一个合法的括号序列 4. 每个合法的括号序列都可以由上面的规则生成
 * 例如 "","()","()()()","(()())","(((()))" 都是合法的。 从一个字符串 S 中移除零个或者多个字符得到的序列称为 S
 * 的子序列。 例如 "abcde" 的子序列有 "abe","","abcde" 等。 定义 LCS(S,T) 为字符串 S 和字符串 T
 * 最长公共子序列的长度, 即一个最长的序列 W 既是 S 的子序列也是 T 的子序列的长度。 小易给出一个合法的括号匹配序列 s,
 * 小易希望你能找出具有以下特征的括号序列 t: 1、t 跟 s 不同, 但是长度相同 2、t 也是一个合法的括号匹配序列 3、LCS(s, t)
 * 是满足上述两个条件的 t 中最大的 因为这样的 t 可能存在多个, 小易需要你计算出满足条件的 t 有多少个。
 * 
 * 如样例所示: s = "(())()", 跟字符串 s 长度相同的合法括号匹配序列有: "()(())", "((()))", "()()()",
 * "(()())", 其中 LCS( "(())()", "()(())" ) 为 4, 其他三个都为 5, 所以输出 3.
 * 
 * 输入描述: 输入包括字符串 s(4 ≤ |s| ≤ 50,|s|表示字符串长度), 保证 s 是一个合法的括号匹配序列。
 * 
 * 输出描述: 输出一个正整数, 满足条件的t的个数。
 * 
 * 示例 1 输入: (())()
 * 
 * 输出: 3
 * 
 */
// https://www.nowcoder.com/discuss/39219
public class T2TODO {
	public static void main(String[] args) {
		String s = null;
		try (Scanner in = new Scanner(System.in)) {
			s = in.nextLine();
			System.out.println(computer(s));
		}
	}

	// 答案来自大宝 50%
	private static Integer computer(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				count++;
			}
		}

		HashMap<Integer, Integer> result = new HashMap<>();
		printPar(count, count, new char[count * 2], 0, s, result);

		int max = 0;
		for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
			if (entry.getKey() > max) {
				max = entry.getKey();
			}
		}
		return result.get(max);
	}

	public static void printPar(int l, int r, char[] cs, int count, String old, HashMap<Integer, Integer> result) {
		if (l < 0 || r < l)
			return;
		if (l == 0 && r == 0) {
			String tmp = new String(cs);
			if (!tmp.equals(old)) {
				int c = lcs(old, tmp);
				if (result.containsKey(c)) {
					result.put(c, result.get(c) + 1);
				} else {
					result.put(c, 1);
				}
			}
		} else {
			if (l > 0) {
				cs[count] = '(';
				printPar(l - 1, r, cs, count + 1, old, result);
			}
			if (r > l) {
				cs[count] = ')';
				printPar(l, r - 1, cs, count + 1, old, result);
			}
		}
	}

	private static int lcs(String s1, String s2) {
		int size1 = s1.length();
		int size2 = s2.length();
		int chess[][] = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 1; i <= size1; i++) { // 根据上面提到的公式计算矩阵
			for (int j = 1; j <= size2; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					chess[i][j] = chess[i - 1][j - 1] + 1;
				} else {
					chess[i][j] = Math.max(chess[i][j - 1], chess[i - 1][j]);
				}
			}
		}
		int i = size1;
		int j = size2;
		StringBuffer sb = new StringBuffer();
		while ((i != 0) && (j != 0)) {
			if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
				sb.append(s1.charAt(i - 1)); // 相同时即为相同的子串
				i--;
				j--;
			} else {
				if (chess[i][j - 1] > chess[i - 1][j]) {
					j--;
				} else {
					i--;
				}
			}
		}
		// return sb.reverse().toString().length(); // 记得反转
		return sb.length();
	}
}
