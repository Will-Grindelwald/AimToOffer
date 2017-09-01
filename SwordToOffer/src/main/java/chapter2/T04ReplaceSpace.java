package chapter2;

/**
 * 
 * 替换空格
 * 
 * 题目描述: 请实现一个函数，将一个字符串中的空格替换成 “%20”。 例如，当字符串为 We Are Happy. 则经过替换之后的字符串为
 * We%20Are%20Happy。
 * 
 * 考察指针，对于 java 无意义
 *
 */
public class T04ReplaceSpace {

	public String replaceSpace1(StringBuffer str) {
		return str.toString().replaceAll(" ", "%20");
	}

	public String replaceSpace(StringBuffer str) {
		int lastIndex = 0;
		while ((lastIndex = str.indexOf(" ", lastIndex)) != -1) {
			str.deleteCharAt(lastIndex);
			str.insert(lastIndex, "%20");
			lastIndex += 3;
		}
		return str.toString();
	}

	public static void main(String[] args) {
		System.out.println(new T04ReplaceSpace().replaceSpace(new StringBuffer(" We Are Happy. ")));
	}
}
