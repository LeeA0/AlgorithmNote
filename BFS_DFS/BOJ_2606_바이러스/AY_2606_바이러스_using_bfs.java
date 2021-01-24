package day;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준_바이러스_2606_실버3
public class BOJ_2606_바이러스_using_bfs {
	static LinkedList<Integer>[] adjList;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine().trim());
		int E = Integer.parseInt(br.readLine().trim());

		adjList = new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adjList[i] = new LinkedList<>();
		}
		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			adjList[from].add(to);
			adjList[to].add(from);
		}
		visited = new boolean[V];

		System.out.println(bfs(0));
	}

	static int bfs(int x) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(x);
		int cnt = 0;
		visited[x] = true;
		while (!que.isEmpty()) {
			int curr = que.poll();
			for (int nx : adjList[curr]) {
				if (!visited[nx]) {
					que.offer(nx);
					cnt++;
					visited[nx] = true;
				}
			}
		}
		return cnt;
	}
}
