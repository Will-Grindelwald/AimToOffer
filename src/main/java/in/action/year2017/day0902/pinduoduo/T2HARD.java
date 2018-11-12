package in.action.year2017.day0902.pinduoduo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * 
 * 
 */
// 样例输入
// 10
// my-app 1
// src 0
// ma 1
// ja 2
// re 2
// we 2
// te 1
// ja 6
// re 6
// pom.xml 0
public class T2HARD {
	public static void main(String[] args) {
		int n = 0;
		List<Node> nodes = new ArrayList<>();
		String root = null;
		try (Scanner in = new Scanner(System.in)) {
			n = in.nextInt();
			root = in.next();
			in.nextInt();
			Node tmp = null;
			for (int i = 1; i < n; i++) {
				tmp = new Node();
				tmp.id = i;
				tmp.name = in.next();
				tmp.par = in.nextInt();
				nodes.add(tmp);
			}
		}
		System.out.println(root);
		print(nodes, 0, "");
	}

	private static void print(List<Node> nodes, int n, String prefix) {
		List<Node> tmp = new ArrayList<>();
		for (Node node : nodes) {
			if (node.par == n) {
				tmp.add(node);
			}
		}
		Collections.sort(tmp, new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				return o1.name.compareTo(o2.name);
			}
		});
		for (int i = 0; i < tmp.size(); i++) {
			if (i != tmp.size() - 1) {
				System.out.println(prefix + "|-- " + tmp.get(i).name);
				print(nodes, tmp.get(i).id, prefix + "|   ");
			} else {
				System.out.println(prefix + "`-- " + tmp.get(i).name);
				print(nodes, tmp.get(i).id, prefix + "    ");
			}
		}
	}

	private static class Node {
		int id;
		int par;
		String name;
	}
}
