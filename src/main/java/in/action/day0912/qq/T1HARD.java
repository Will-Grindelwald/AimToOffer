package in.action.day0912.qq;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * 给四个 字符串 a b c d，求他们的最短超串的长度。最短超串：abcd 与 bcde 的最短超串为 abcde，abcd 与 efgh 的最短超串为
 * abcdefgh
 * 
 * 样例：abc ab bc a --> 3 (超串 为 abc)
 * 
 */
public class T1HARD {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String[] ss = input.split(" ");
		List<String> list = new ArrayList<>();
		list.add(ss[0]);
		list.add(ss[1]);
		list.add(ss[2]);
		list.add(ss[3]);
		System.out.println(compute(list));
	}

	public static int compute(List<String> strs) {
		while (strs.size() > 1) {
			int max = 0, maxI = 0, maxJ = 1, maxOp = 0;
			for (int i = 0; i < strs.size(); i++) {
				for (int j = 0; j < strs.size(); j++) {
					if (j == i)
						continue;
					int ljc = jointCount(strs.get(i), strs.get(j));
					int rjc = jointCount(strs.get(j), strs.get(i));
					int cur = Math.max(ljc, rjc);
					if (cur > max) {
						max = cur;
						maxI = i;
						maxJ = j;
						maxOp = ljc > rjc ? 0 : 1;
					}
				}
			}
			String ns, a = strs.get(maxI), b = strs.get(maxJ);

			if (maxOp == 0)
				ns = a + b.substring(max);
			else
				ns = b + a.substring(max);

			strs.remove(a);
			strs.remove(b);
			strs.add(ns);
		}
		return strs.get(0).length();
	}

	public static int jointCount(String a, String b) {
		char c = a.charAt(a.length() - 1);
		int i = b.indexOf(c);
		if (i < 0)
			return 0;
		int al = a.length();
		for (int j = i; j >= 0; j--) {
			int aj = al - 1 - i + j;
			if (aj < 0)
				return 0;
			if (a.charAt(aj) != b.charAt(j))
				return 0;
		}
		return i + 1;
	}
}
