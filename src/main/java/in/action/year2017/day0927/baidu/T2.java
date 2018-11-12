package in.action.year2017.day0927.baidu;

/**
 * 
 * 
 */
public class T2 {
	public static void main(String[] args) {

	}

	// 18/19
	public int maxStipend(int numOfDays, int[][] taskList) {
		if (numOfDays < 1 || taskList.length != numOfDays)
			return 0;
		int[] a = new int[numOfDays], b = new int[numOfDays], c = new int[numOfDays];
		b[0] = taskList[0][0];
		c[0] = taskList[0][1];
		for (int i = 1; i < taskList.length; i++) {
			a[i] = max(a[i - 1], b[i - 1], c[i - 1]);
			b[i] = a[i] + taskList[i][0];
			c[i] = a[i - 1] + taskList[i][1];
		}
		return max(a[taskList.length - 1], b[taskList.length - 1], c[taskList.length - 1]);
	}

	public static int max(int a, int b, int c) {
		if (a > b) {
			if (a > c) {
				return a;
			} else {
				return c;
			}
		} else {
			if (b > c) {
				return b;
			} else {
				return c;
			}
		}
	}
}
