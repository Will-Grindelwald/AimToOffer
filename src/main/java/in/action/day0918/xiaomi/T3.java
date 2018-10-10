package in.action.day0918.xiaomi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * 密码破译
 * 
 * 我们来做一个简单的密码破译游戏。破译的规则很简单，将数字转换为字母，1 转化为 a，2 转化为 b，依此类推，26 转化为
 * z。现在输入的密码是一串数字，输出的破译结果是该数字串通过转换规则所能产生的所有字符串。
 * 
 * 输入 多行数据，每行为一个数字串。
 * 
 * 输出 多行数据，每行对应输出通过数字串破译得到的所有字符串，并按照字符串顺序排列，字符串之间用单个空格分隔。每行开头和结尾不允许有多余的空格。
 * 
 * 样例输入
 * 
 * <pre>
 * 1
 * 12
 * 123
 * </pre>
 * 
 * 样例输出
 * 
 * <pre>
 * a
 * ab l
 * abc aw lc
 * </pre>
 * 
 */
public class T3 {
	public static char[] tmp;
	public static List<String> res = new ArrayList<>();

	public static void main(String[] args) {
		String s = null;
		try (Scanner in = new Scanner(System.in)) {
			while (in.hasNext()) {
				s = in.nextLine();
				compute(s.toCharArray());
				System.out.print(res.get(0));
				for (int i = 1; i < res.size(); i++) {
					System.out.print(" " + res.get(i));
				}
				System.out.println();
			}
		}
	}

	public static void compute(char[] cs) {
		res = new ArrayList<>();
		tmp = new char[cs.length];
		dfs(cs, 0, 0);
		res.sort(null);
	}

	public static void dfs(char[] cs, int i, int j) {
		if (i == cs.length) {
			res.add(new String(tmp, 0, j));
			return;
		}
		tmp[j] = (char) (cs[i] - '0' - 1 + 'a');
		dfs(cs, i + 1, j + 1);
		if ((i < cs.length - 1) && (cs[i] == '1' || (cs[i] == '2' && (cs[i + 1] >= '0' && cs[i + 1] <= '6')))) {
			tmp[j] = (char) ((cs[i] - '0') * 10 + cs[i + 1] - '0' - 1 + 'a');
			dfs(cs, i + 2, j + 1);
		}
	}
}
