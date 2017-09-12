package in.action.day624.lousai10;

public class StringUtils {
	public static boolean allIsNotNull(String... s) {
		if (s == null || s.length == 0) {
			return false;
		}
		for (String str : s) {
			if (str == null)
				return false;
		}
		return true;
	}

	public static boolean allIsNotEmpty(String... s) {
		if (s == null || s.length == 0) {
			return false;
		}
		for (String str : s) {
			if (str == null || str.isEmpty())
				return false;
		}
		return true;
	}
}
