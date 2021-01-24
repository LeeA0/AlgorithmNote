package day;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 백준_바이러스_2606_실버3
public class BOJ_2606_바이러스_using_dfs {
	static LinkedList<Integer>[] adjList;
	static boolean[] visited;
	static int cnt;

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
		cnt = 0;
		dfs(0);
		System.out.println(cnt-1);
	}

	static void dfs(int x) {
		cnt++;
		visited[x] = true;
		for (int nx : adjList[x]) {
			if (!visited[nx]) {
				dfs(nx);
			}
		}
	}
}
