package chapter2;

public class T4ReplaceSpace {

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
		System.out.println(new T4ReplaceSpace().replaceSpace(new StringBuffer(" We Are Happy. ")));
	}
}
