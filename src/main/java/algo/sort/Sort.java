package algo.sort;

import java.util.Arrays;

// 递增
public class Sort {

	/**
	 * 基于交换的
	 */

	// 冒泡 - 无优化
	public static void bubbleSort(int[] arr) {
		int temp = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	// 冒泡 - 带优化
	public static void bubbleSort2(int[] arr) {
		// lastExchange 用于记录每轮扫描最后一次发生交换的位置(即已确定有序的最小的位置), 初始化为最后一个元素的下一个位置
		int lastExchange = arr.length, lim, temp = 0;
		while (lastExchange != 0) {
			lim = lastExchange - 1; // 即无序的最大的位置
			lastExchange = 0;
			for (int j = 0; j < lim; j++) { // j 从 0 到 lim - 1, j + 1 从 1 到 lim
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					lastExchange = j + 1;
				}
			}
		}
	}

	// 快速排序
	public static void quickSort(int[] arr) {
		qSort(arr, 0, arr.length - 1);
	}

	public static void qSort(int[] arr, int low, int high) {
		if (low < high) {
			int pivotpos = partition(arr, low, high); // 将 arr 数组进行一分为二
			qSort(arr, low, pivotpos - 1); // 对低字段表进行递归排序
			qSort(arr, pivotpos + 1, high); // 对高字段表进行递归排序
		}
	}

	/**
	 * 找出枢轴（默认是最低位low）在数组中的位置
	 * 
	 * @return 中轴所在位置
	 */
	public static int partition(int[] arr, int low, int high) {
		int pivot = arr[low];
		while (low < high) {
			while (low < high && arr[high] >= pivot) {
				high--;
			}
			arr[low] = arr[high];// 比枢轴小的记录移到低端
			while (low < high && arr[low] <= pivot) {
				low++;
			}
			arr[high] = arr[low]; // 比枢轴大的记录移到高端
		}
		arr[low] = pivot; // 枢轴放到最终位置
		return low; // 返回枢轴的位置
	}

	/**
	 * 基于插入的
	 */
	// 直接插入排序
	public static void insertSort(int[] arr) {
		insertSortByDk(arr, 1);
	}

	// 希尔排序
	public static void shellSort(int[] arr) {
		for (int dk = arr.length / 2; dk > 0; dk >>= 1) { // 每次将步长缩短为原来的一半
			insertSortByDk(arr, dk);
		}
	}

	// 直接插入和希尔排序共用
	private static void insertSortByDk(int[] arr, int dk) {
		int j = 0, temp = 0;
		for (int i = dk; i < arr.length; i++) { // 将 arr[dk] ... arr[n-1] 依次向前插入
			temp = arr[i];
			for (j = i - dk; j >= 0 && temp < arr[j]; j -= dk) {
				arr[j + dk] = arr[j];
			}
			arr[j + dk] = temp;
		}
	}

	// 折半插入排序
	public static void binaryInsertSort(int[] arr) {
		int low, high, mid, j, temp = 0;
		for (int i = 1; i < arr.length; i++) { // 将 arr[1] ... arr[n-1] 依次插入
			// 二分查找
			low = 0;
			high = i - 1;
			while (low <= high) { // 退出时 high 即为所求
				mid = low + (high - low) / 2;
				if (arr[mid] > arr[i]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
			// 插入
			temp = arr[i];
			for (j = i - 1; j > high; j--) {
				arr[j + 1] = arr[j];
			}
			arr[j + 1] = temp;
		}
	}

	/**
	 * 基于归并的
	 */
	// 归并排序
	public static void mergeSort(int[] arr) {
		mSort(arr, 0, arr.length - 1);
	}

	public static void mSort(int[] arr, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			mSort(arr, low, mid);
			mSort(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}
	}

	public static void merge(int[] arr, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int i = low/* 左指针 */, j = mid + 1/* 右指针 */, k = 0;

		while (i <= mid && j <= high) {
			if (arr[i] < arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}
		while (i <= mid) {
			temp[k++] = arr[i++];
		}
		while (j <= high) {
			temp[k++] = arr[j++];
		}

		System.arraycopy(temp, 0, arr, low, high - low + 1);
	}

	/**
	 * 基于选择的
	 */
	// 简单选择排序
	public static void selectSort(int[] arr) {
		int temp = 0;
		for (int i = 0; i < arr.length - 1; i++) { // 依次确定 第 i 小的数
			int min = i;
			for (int j = arr.length - 1; j > i; j--) { // 遍历 i+1 到 length-1
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			// 这里的 交换 导致 不稳定
			temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
	}

	// 堆选择排序
	public static void heapSort(int[] arr) {
		int len = arr.length;
		buildMaxHeap(arr, len - 1); // 建堆
		for (int i = 0; i < len - 1; i++) {
			swap(arr, 0, len - 1 - i); // 交换堆顶和最后一个元素 -> 将最大的移到堆的末尾
			adjustDown(arr, len - 2 - i, 0); // 向下调整
		}
	}

	// 对 arr 数组从 0 到 lastIndex 建大顶堆
	public static void buildMaxHeap(int[] arr, int lastIndex) {
		// 从 lastIndex 节点（最后一个节点）的父节点 ~ 0, 反复向下调整堆
		for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
			adjustDown(arr, lastIndex, i);
		}
	}

	public static void adjustDown(int[] arr, int lastIndex, int cur) {
		// 从 cur 向下调整
		int bigger;
		while (cur * 2 + 1 <= lastIndex) { // 如果当前 cur 节点的子节点存在
			bigger = 2 * cur + 1; // cur 节点的左子节点的索引
			// 如果 biggerIndex 小于 lastIndex，即 biggerIndex + 1 代表的 cur 节点的右子节点
			// 且右子节点的值较大
			if (bigger < lastIndex && arr[bigger] < arr[bigger + 1]) {
				bigger++;
			}
			// 如果 cur 节点的值小于其较大的子节点的值
			if (arr[cur] < arr[bigger]) {
				swap(arr, cur, bigger);
				cur = bigger;
			} else {
				break;
			}
		}
	}

	public static void adjustUp(int[] arr, int cur) {
		int parent = (cur - 1) / 2;
		int temp = arr[cur];
		while (parent >= 0 && arr[parent] < temp) {
			arr[cur] = arr[parent];
			cur = parent;
			parent = (cur - 1) / 2;
		}
		arr[cur] = temp;
	}

	// 交换
	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void main(String[] args) {
		int arr[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35,
				25, 53, 51 };
		// bubbleSort2(arr);
		// quickSort(arr);
		// insertSort(arr);
		// shellSort(arr);
		// binaryInsertSort(arr);
		// mergeSort(arr);
		// selectSort(arr);
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(juage(arr));
	}

	public static boolean juage(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1]) {
				return false;
			}
		}
		return true;
	}
}
