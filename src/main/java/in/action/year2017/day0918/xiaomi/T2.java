package in.action.year2017.day0918.xiaomi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * 路径匹配
 * 
 * 假如有一个 HTTP Server，可以对不同的路径（Path）注册不同的处理函数（Handler）。路径的格式为 /x/y/z，使用 “/”
 * 作为分隔符，被分隔开的每个组件都是只包含字母的非空字符串；路径总是以 “/” 开头，且不以 “/” 结尾，也不会出现 “/x//y”
 * 这样的情况。为了简化问题，我们将处理函数用整数的 ID 号表示。 对于客户端的 HTTP
 * 请求，我们需要根据路径匹配最合适的处理函数。匹配规则是：在所有已经注册的路径中，找到包含该路径的最长前缀。前缀要求对组件的匹配是完整的，因此 “/a/b”
 * 是 “/a/b/c” 的前缀，但不是 “/a/bc” 的前缀。
 * 
 * 输入 输入分两部分： 第一部分是注册的路径列表，每行两个元素，用空格分开，分别为路径和 ID 号；ID 号为非 0 整数，且不会重复。
 * 第二部分是需要匹配的路径列表，每行一个路径。 两个部分用只包含一个短横线的特殊行分隔。
 * 
 * 输出 对于每个需要匹配的路径，输出其匹配的 ID 号，每行一个；如果没有找到匹配路径，则输出 0。
 * 
 * 样例输入
 * 
 * <pre>
 * /a 1
 * /a/b 2
 * /a/b/c/d/e/f/g/h/i 3
 * /a/bcde 4
 * -
 * /a
 * /a/b
 * /a/b/c/d
 * /a/b/c/d/e/f/g/h/i
 * /a/bcde
 * /a/bcdefghi
 * /b
 * </pre>
 * 
 * 样例输出
 * 
 * <pre>
 * 1
 * 2
 * 2
 * 3
 * 4
 * 1
 * 0
 * </pre>
 * 
 */
public class T2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		HashMap<String, String> map = new HashMap<>();
		boolean down = false;
		while (in.hasNext()) {
			String line = in.nextLine().trim();
			if (!"-".equals(line) && !down) {
				String[] split = line.split(" ");
				map.put(split[0], split[1]);
			} else {
				if ("-".equals(line)) {
					down = true;
					continue;
				}
				String s = "";
				for (Map.Entry<String, String> entry : map.entrySet()) {
					String key = entry.getKey();
					String tmpKey = key + "/";
					line = line + "/";
					if (line.startsWith(tmpKey) && key.length() > s.length()) {
						s = key;
					}
				}
				if (map.get(s) == null) {
					System.out.println(0);
				} else {
					System.out.println(map.get(s));
				}
			}
		}
	}
}
