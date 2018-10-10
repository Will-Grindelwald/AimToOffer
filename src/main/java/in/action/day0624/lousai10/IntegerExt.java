package in.action.day0624.lousai10;

/**
 * 实现 整型常量池
 * 我的代码主要参考了 JDK 的 Integer$IntegerCache
 */
public class IntegerExt {
	private int i;

	static final int low = -128;
	static final int high = 127;
	static final IntegerExt cache[];

	static {
		cache = new IntegerExt[(high - low) + 1];
		int j = low;
		for (int k = 0; k < cache.length; k++)
			cache[k] = new IntegerExt(j++);
	}

	private IntegerExt(int i) {
		this.i = i;
	}

	public int toIntValue() {
		return i;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof IntegerExt) {
			return i == ((IntegerExt) obj).toIntValue();
		}
		return false;
	}

	public static IntegerExt getInstance(int i) {
		if (i >= low && i <= high)
			return cache[i + (-low)];
		return new IntegerExt(i);
	}
}
