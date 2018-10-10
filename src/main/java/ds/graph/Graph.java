package ds.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	public int[][] m;
	public boolean[] visited;

	public static void main(String[] args) {
		Graph graph = new Graph();
		init1(graph);
		System.out.print("\nBFS: ");
		graph.BFSTraverse();
		System.out.print("\nDFS: ");
		graph.DFSTraverse();
		
		init2(graph);
		System.out.print("\nFloyd: ");
		graph.Floyd();
		System.out.println(Arrays.deepToString(graph.m));
	}

	// m[i][i] == 0
	// m[i][j] == Integer.MAX_VALUE 即两点不连通

	/**
	 * 
	 * 无向图 连通图
	 * 
	 * <pre>
	 * 0 — 1   2 — 3
	 * |   | / | / |
	 * 4   5 — 6 — 7
	 * </pre>
	 * 
	 */
	public static void init1(Graph graph) {
		graph.m = new int[8][8];
		for (int i = 0; i < graph.m.length; i++) {
			for (int j = 0; j < graph.m.length; j++) {
				if (i == j) {
					continue;
				}
				graph.m[i][j] = Integer.MAX_VALUE;
			}
		}
		graph.m[0][1] = graph.m[1][0] = 1;
		graph.m[0][4] = graph.m[4][0] = 1;
		graph.m[1][5] = graph.m[5][1] = 1;
		graph.m[2][5] = graph.m[5][2] = 1;
		graph.m[2][3] = graph.m[3][2] = 1;
		graph.m[2][6] = graph.m[6][2] = 1;
		graph.m[5][6] = graph.m[6][5] = 1;
		graph.m[3][6] = graph.m[6][3] = 1;
		graph.m[3][7] = graph.m[7][3] = 1;
		graph.m[6][7] = graph.m[7][6] = 1;
	}

	/**
	 * 
	 * 有向图 连通图
	 * 
	 * <pre>
	 * 1   →   2
	 *  ↖↘       ↗
	 * ↑   4   ↕
	 *   ↗      ↘
	 * 0   ←   3
	 * </pre>
	 * 
	 */
	public static void init2(Graph graph) {
		graph.m = new int[5][5];
		for (int i = 0; i < graph.m.length; i++) {
			for (int j = 0; j < graph.m.length; j++) {
				if (i == j) {
					continue;
				}
				graph.m[i][j] = Integer.MAX_VALUE;
			}
		}
		graph.m[0][1] = 10;
		graph.m[0][4] = 5;
		graph.m[1][2] = 1;
		graph.m[1][4] = 2;
		graph.m[2][3] = 4;
		graph.m[3][2] = 6;
		graph.m[3][0] = 7;
		graph.m[4][1] = 3;
		graph.m[4][2] = 9;
		graph.m[4][3] = 2;
	}

	public void visit(int v) {
		System.out.print(v + " ");
	}

	public void BFSTraverse() {
		visited = new boolean[m.length];
		for (int i = 0; i < m.length; i++) {
			if (!visited[i]) { // 非连通图
				BFS(i);
			}
		}
	}

	public void BFS(int v) {
		Queue<Integer> queue = new LinkedList<>();
		visit(v);
		visited[v] = true;
		queue.offer(v);
		int cur;
		while (!queue.isEmpty()) {
			cur = queue.poll();
			for (int i = 0; i < m.length; i++) {
				if (i == cur)
					continue;
				if (m[cur][i] != Integer.MAX_VALUE && !visited[i]) {
					visit(i);
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
		return;
	}

	public void DFSTraverse() {
		visited = new boolean[m.length];
		for (int i = 0; i < m.length; i++) {
			if (!visited[i]) { // 非连通图
				DFS(i);
			}
		}
	}

	public void DFS(int v) {
		visit(v);
		visited[v] = true;
		for (int i = 0; i < m.length; i++) {
			if (i == v)
				continue;
			if (m[v][i] != Integer.MAX_VALUE && !visited[i]) {
				DFS(i);
			}
		}
	}

	public void Dijkstra() {
		
	}

	public void Floyd() {
		for (int k = 0; k < m.length; k++) {
			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m.length; j++) {
					if (m[i][k] == Integer.MAX_VALUE || m[k][j] == Integer.MAX_VALUE)
						continue;
					if (m[i][j] > m[i][k] + m[k][j])
						m[i][j] = m[i][k] + m[k][j];
				}
			}
		}
	}
}
