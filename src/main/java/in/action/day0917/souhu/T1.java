package in.action.day0917.souhu;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 
 * 简化 Unix 风格的路径，需要考虑的包括 "/../", "//", "/./" 等情况
 * 
 * 输入描述: Unix 风格的路径
 * 
 * 输出描述: 简化后的 Unix 风格路径
 * 
 * 示例 1 输入 /a/./b/../../c/
 * 
 * 输出 /c
 * 
 */
public class T1 {
	public static void main(String[] args) {
		String s = null;
		try (Scanner in = new Scanner(System.in)) {
			s = in.nextLine();
		}
		System.out.println(compute(s.split("/")));
	}

	public static String compute(String[] ss) {
		LinkedList<String> stack = new LinkedList<>();
		for (int i = 0; i < ss.length; i++) {
			if (ss[i].equals("") || ss[i].equals(".")) {
				continue;
			} else if (ss[i].equals("..")) {
				if (!stack.isEmpty()) {
					stack.removeLast();
				}
			} else {
				stack.addLast(ss[i]);
			}
		}
		if (stack.isEmpty()) {
			return "/";
		}
		StringBuffer sb = new StringBuffer();
		while (!stack.isEmpty()) {
			sb.append('/').append(stack.remove());
		}
		return sb.toString();
	}
}
