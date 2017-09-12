package sword.to.offer.chapter5;

/**
 * 
 * HZ 偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后, 他又发话了: 在古老的一维模式识别中, 常常需要计算连续子向量的最大和,
 * 当向量全为正数的时候, 问题很好解决。但是, 如果向量中包含负数, 是否应该包含某个负数,
 * 并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2}, 连续子向量的最大和为 8(从第 0 个开始, 到第 3
 * 个为止)。你会不会被他忽悠住？(子向量的长度至少是 1)
 * 
 */
/**
 * 
 * 辅存 o(1) 的动规：f[i]=f[i-1]+a[i] f[i-1]>=0
 * 
 *                   =a[i]         f[i-1]<0
 * 
 */
public class T31FindGreatestSumOfSubArray {
	public static int FindGreatestSumOfSubArray(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int sum = array[0], max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (sum < 0) {
				sum = array[i];
			} else {
				sum += array[i];
			}
			if (max < sum) {
				max = sum;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, -2, 3, 10, -4, 7, 2, -5 };
		System.out.println(FindGreatestSumOfSubArray(arr));
	}
}
