package in.action.year2017.day0903.yuanjing;

import java.util.Scanner;

// https://www.nowcoder.com/questionTerminal/16fa68271ee5448cafd504bb4a64b482?orderByHotValue=1&mutiTagIds=589_640_639&page=1&onlyReference=false
public class T1 {
	public static void main(String[] args) {
		String s = null;
		char[] chs = null;
		try (Scanner in = new Scanner(System.in)) {
			while (in.hasNext()) {
				s = in.nextLine();
				chs = s.toCharArray();
				for (int i = 0; i < chs.length; i++) {
					if (chs[i] - '0' >= 0 && chs[i] - '0' <= 9)
						System.out.print(chs[i]);
				}
				System.out.println();
			}
		}
	}
}
