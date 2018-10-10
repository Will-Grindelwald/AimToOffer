package in.action.day0624.lousai10;

import java.lang.reflect.Field;

/**
 * 题目
 * 
 * 补全类 ShiyanlouImpl，实现 toUp(String name) 方法, toUp 方法将传入的字符串转为大写并返回 (异常情况返回
 * null)，例如传入为 shiyanlou，返回为 SHIYANLOU。
 * 
 * 补全 Main 类的 ioc(String className, Shiyanlou s, String methodName, String name)
 * 方法，实现功能： 1. 反射生成 className 类实例； 2. 找到 className 实例中类型为 Shiyanlou 的变量并调用 set
 * 方法注入参数 s； 3. 然后调用 className 的 methodName 方法传入 name 参数；
 * 
 * 目标
 * 
 * 最终实现的 IOC 满足题目的所有要求；
 * 
 * 提示语
 * 
 * 注意处理异常情况； 注意要使用 set 方法注入；
 * 
 * 知识点
 * 
 * 反射； IOC；
 *
 */
public class Main {
	public static void ioc(String className, Shiyanlou s, String methodName, String name) {
		if (className == null || s == null || methodName == null || name == null)
			return;
		try {
			Class<?> target = Class.forName(className);
			Object targetObj = target.newInstance();
			for (Field f : target.getDeclaredFields()) {
				if (Shiyanlou.class.isAssignableFrom(f.getType())) {
					String setter = "set" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
					target.getMethod(setter, Shiyanlou.class).invoke(targetObj, s);
				}
			}
			target.getMethod(methodName, String.class).invoke(targetObj, name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ioc("integerExt.TT", new ShiyanlouImpl(), "ls", "abcd");
	}
}
