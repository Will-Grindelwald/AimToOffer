package in.action.day0918.xiaomi;

import java.util.Scanner;

/**
 * 
 * 名称转换
 * 
 * 在 C++ 头文件中可以使用 include guard 以避免头文件被重复 include，譬如：
 * 
 * <pre>
 * #ifndef MYHEADER_H_
 * #define MYHEADER_H_
 * ... 
 * #endif
 * </pre>
 * 
 * 现在我希望你编写一个程序，将类名按照某种规则转换为 include guard 所使用的宏。 类名会包含 namespace 前缀，使用 “.”
 * 作为分隔符。被分隔符分开的各个部分称之为组件，组件只会包含大小写字母和数字，且不能以数字开头。
 * 
 * 转换规则：
 * 
 * <pre>
 * > 在开头和结尾都添加下划线；
 * > 将 “.” 转化为下划线；
 * > 根据下面的规则识别出组件中的单词，并使用下划线将单词进行分隔（具体参照输入输出样例）：
 * >> 第一个大写字母与后面连续的小写字母一起识别为一个单词，如果不以大写字母开头，则直接将连续的小写字母识别为一个单词；
 * >> 连续的大写字母一起识别为一个单词，但是如果最后一个大写字母后面跟着小写字母，则最后一个大写字母不包含在内；
 * >> 连续的数字一起识别为一个单词；
 * </pre>
 * 
 * 输入 多行字符串，每行是一个类名
 * 
 * 输出 多行字符串，每行是一个转化后的 include guard 宏，与输入对应
 * 
 * 样例输入 a my.ABC simple.HelloService MY.ASTParser12
 * 
 * 样例输出 _A_ _MY_ABC_ _SIMPLE_HELLO_SERVICE_ _MY_AST_PARSER_12_
 * 
 */
/**
 * 
 * 当时 82%， 少考虑一种情况
 * 
 */
public class T1 {
	public static void main(String[] args) {
		String s = null;
		try (Scanner in = new Scanner(System.in)) {
			while (in.hasNext()) {
				s = in.nextLine();
				System.out.println(compute(s.toCharArray()));
			}
		}
	}

	public static String compute(char[] cs) {
		StringBuffer sb = new StringBuffer();
		sb.append('_').append(Character.toUpperCase(cs[0]));
		for (int i = 1; i < cs.length; i++) {
			if (cs[i] == '.') {
				sb.append('_');
			} else if (Character.isUpperCase(cs[i])) {
				if (i != cs.length - 1 && (Character.isUpperCase(cs[i - 1]) && Character.isLowerCase(cs[i + 1])
						|| Character.isLowerCase(cs[i - 1]) || Character.isDigit(cs[i - 1]))) {
					sb.append('_');
				}
				sb.append(cs[i]);
			} else if (Character.isLowerCase(cs[i])) {
				if (Character.isDigit(cs[i - 1])) { // 当时没考虑这种情况
					sb.append('_');
				}
				sb.append(Character.toUpperCase(cs[i]));
			} else if (Character.isDigit(cs[i])) {
				if (!Character.isDigit(cs[i - 1]))
					sb.append('_');
				sb.append(cs[i]);
			}
		}
		sb.append('_');
		return sb.toString();
	}
}
