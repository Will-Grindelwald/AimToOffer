package day624;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
	public static void main(String[] args) {
		String className = "java.lang.String";
		try {
			Class<?> target = Class.forName(className);
			Field[] fields = target.getDeclaredFields();
			for (Field f : fields) {
				System.out.println(f.getType());
			}
			Method[] methods = target.getDeclaredMethods();
			for (Method m : methods) {
				System.out.println(m.getName());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
}
