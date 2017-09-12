package in.action.day624.lousai10;

public class ShiyanlouImpl implements Shiyanlou {
	@Override
	public String toUp(String s) {
		if (s == null)
			return null;
		return s.toUpperCase();
	}
}
