package day826.am;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * 输出 无序序列 中第 k 大的数，如：45 67 33 21 中第 2 大的数
 * 
 */
public class T2 {

	public static void main(String[] args) {
		int[] nums = null;
		int n = 0;
		try (Scanner in = new Scanner(System.in)) {
			String[] numstr = in.nextLine().split(" ");
			nums = new int[numstr.length];
			for (int i = 0; i < numstr.length; i++) {
				nums[i] = Integer.valueOf(numstr[i]);
			}
			n = in.nextInt();
		}
		Arrays.sort(nums);
		System.out.println(nums[nums.length - n]);
	}
}
