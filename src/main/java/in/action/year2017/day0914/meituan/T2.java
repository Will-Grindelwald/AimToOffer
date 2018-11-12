package in.action.year2017.day0914.meituan;

import java.util.Scanner;

/**
 * 
 * 灯的状态 0 关 1 开。修改操作：选中一个灯，将它及其后的灯状态翻转。Alice 先 Bob 后，每人交替操作，第一个将 all 灯变亮的人胜。
 * 两人足够聪明，问谁胜？
 * 
 */
public class T2 {
	public static void main(String[] args) {
		byte[] state = null;
		try (Scanner in = new Scanner(System.in)) {
			state = new byte[in.nextInt()];
			for (int i = 0; i < state.length; i++) {
				state[i] = in.nextByte();
			}
		}
		int count = state[0];
		for (int i = 1, cur = state[0]; i < state.length; i++) {
			if (state[i] != cur) {
				count++;
				cur = state[i];
			}
		}
		if (count % 2 == 0) {
			System.out.println("Bob");
		} else {
			System.out.println("Alice");
		}
	}
}
