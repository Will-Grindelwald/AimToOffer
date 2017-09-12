package in.action.day906.huawei;

import java.util.Scanner;

/**
 * 
 * 请一个在字符串中找出连续最长的数字串，并把这个串的长度返回；如果存在长度相同的连续数字串，返回最后一个连续数字串；
 * 注意：数字串只需要是数字组成的就可以，并不要求顺序，比如数字串 “1234” 的长度就小于数字串
 * “1359055”，如果没有数字，则返回空字符串（“”）而不是 NULL！（说明：不需要考虑负数） 输入描述: 字符串 输出描述:
 * 连续数字串&在所有数字串最长的长度
 * 
 * abcd12345ed125ss123058789
 * 
 */
public class T1 {
	public static void main(String[] args) {
		String s = null;
		try (Scanner in = new Scanner(System.in)) {
			while (in.hasNext()) {
				s = in.next();
				compute(s);
			}
		}
	}

	// 遍历
	public static void compute(String s) {
		char[] cs = s.toCharArray();
		int max = 0, index = 0, cur = 0;
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] - '0' >= 0 && cs[i] - '0' <= 9) {
				cur++;
			} else {
				if (max <= cur) {
					max = cur;
					index = i - cur;
				}
				cur = 0;
			}
		}
		if (max <= cur) {
			max = cur;
			index = cs.length - cur;
		}
		if (max == 0) {
			System.out.println(0);
		} else {
			System.out.println(new String(cs, index, max));
			System.out.println(max);
		}
	}

	// 正则解法
	public static void compute2(String str) {
		String[] arr = str.split("\\D+");
		String sss = arr[0];
		int max = arr[0].length();
		for (int i = 1; i < arr.length; i++) {
			if (arr[i].length() >= max) {
				sss = arr[i];
				max = arr[i].length();
			} else if (arr[i].length() == max) {
				sss += arr[i];
			}
		}
		if (max == 0) {
			System.out.println(0);
		} else {
			System.out.println(sss);
			System.out.println(max);
		}
	}
}
