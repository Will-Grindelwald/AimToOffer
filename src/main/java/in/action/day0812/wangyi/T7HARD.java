package in.action.day0812.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * 小易老师是非常严厉的, 它会要求所有学生在进入教室前都排成一列, 并且他要求学生按照身高不递减的顺序排列。有一次, n 个学生在列队的时候,
 * 小易老师正好去卫生间了。学生们终于有机会反击了, 于是学生们决定来一次疯狂的队列,
 * 他们定义一个队列的疯狂值为每对相邻排列学生身高差的绝对值总和。由于按照身高顺序排列的队列的疯狂值是最小的,
 * 他们当然决定按照疯狂值最大的顺序来进行列队。现在给出 n 个学生的身高, 请计算出这些学生列队的最大可能的疯狂值。小易老师回来一定会气得半死。
 * 
 * 输入描述: 输入包括两行, 第一行一个整数 n(1 ≤ n ≤ 50), 表示学生的人数。第二行为 n 个整数 h[i](1 ≤ h[i] ≤
 * 1000), 表示每个学生的身高
 * 
 * 输出描述: 输出一个整数, 表示 n 个学生列队可以获得的最大的疯狂值。
 * 
 * 如样例所示: 当队列排列顺序是: 25-10-40-5-25, 身高差绝对值的总和为 15 + 30 + 35 + 20 = 100。
 * 这是最大的疯狂值了。
 * 
 * 输入例子 1: 5 5 10 25 40 25
 * 
 * 输出例子 1: 100
 *
 */
public class T7HARD {
	public static void main(String[] args) {
		int n = 0;
		int[] arr = null;
		try (Scanner in = new Scanner(System.in)) {
			n = in.nextInt();
			arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
			}
		}
		Arrays.sort(arr);
		int sum = 0, tempFisrt = arr[n - 1], tempLast = arr[n - 1];
		boolean flag = false;
		for (int i = 0; i < (n - 1) / 2; i++) {
			if (flag == false) {
				sum += Math.abs(tempLast - arr[i]);
				tempLast = arr[i];
				System.out.println("index=" + (i) + "sum=" + sum);
				sum += Math.abs(tempFisrt - arr[i + 1]);
				tempFisrt = arr[i + 1];
				System.out.println("index=" + (i + 1) + "sum=" + sum);
				flag = !flag;
			} else {
				sum += Math.abs(tempLast - arr[n - i - 1]);
				tempLast = arr[n - i - 1];
				System.out.println("index=" + (n - i - 1) + "sum=" + sum);
				sum += Math.abs(tempFisrt - arr[n - (i + 1) - 1]);
				tempFisrt = arr[n - (i + 1) - 1];
				System.out.println("index=" + (n - (i + 1) - 1) + "sum=" + sum);
				flag = !flag;
			}
		}
		if (n % 2 == 0) {
			int index = n % 4 == 0 ? n / 2 : n / 2 - 1;
			sum += Math.abs(tempFisrt - arr[index]) > Math.abs(tempLast - arr[index]) ? Math.abs(tempFisrt - arr[index])
					: Math.abs(tempLast - arr[index]);
			System.out.println("index=" + (index) + "sum=" + sum);
		} else {
			int index1 = n / 2;
			int index2 = index1 % 2 == 0 ? index1 + 1 : index1 - 1;
			sum += Math.abs(arr[index2] - arr[index1]);
			System.out.println("index1=" + (index1) + " index2=" + (index2) + " sum=" + sum);
			sum -= arr[index1 + 1] - arr[index1] < arr[index1] - arr[index1 - 1] ? arr[index1 + 1] - arr[index1]
					: arr[index1] - arr[index1 - 1];
			System.out.println("arr[index + 1] - arr[index]=" + (arr[index1 + 1] - arr[index1])
					+ "arr[index] - arr[index - 1]=" + (arr[index1] - arr[index1 - 1]));
		}
		System.out.println(sum);
	}

	// 别人的另一种解法
	public static void main2(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int n = in.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = in.nextInt();
			}
			Arrays.sort(nums);
			int min = nums[0]; // 上一次加入疯狂队列的那个最小值
			int max = nums[n - 1]; // 上一次加入疯狂队列的那个最大值
			int diff = max - min;
			int minIndex = 1; // 未加入疯狂队列的最小值索引
			int maxIndex = n - 2; // 未加入疯狂队列的最大值索引
			while (minIndex < maxIndex) {
				diff += max - nums[minIndex];
				diff += nums[maxIndex] - min;
				min = nums[minIndex++];
				max = nums[maxIndex--];
			}
			// 原数列中最后一个数 minIndex == maxIndex，将它放到合适的位置上
			diff += Math.max(nums[maxIndex] - min, max - nums[minIndex]);
			System.out.println(diff);
		}
		in.close();
	}
}
