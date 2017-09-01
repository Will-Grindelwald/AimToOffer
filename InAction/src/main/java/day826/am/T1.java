package day826.am;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 剑指offer 第 31 题
public class T1 {

	public static int FindGreatestSumOfSubArray(Integer[] array) {
		return 0;
	}

	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>();
		try (Scanner in = new Scanner(System.in)) {
			while (in.hasNext()) {
				arr.add(in.nextInt());
			}
		}
		System.out.println(FindGreatestSumOfSubArray(arr.toArray(new Integer[arr.size()])));
	}
}
