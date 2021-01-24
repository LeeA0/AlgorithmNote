package baekjoon.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @author BUMSEOK SEO
 * @problem 1260(silver) DFS와 BFS
 *
 */
public class BOJ_1260_DFS와BFS {
	static int N, M, V;
	static boolean[][] map;
	static Queue<Integer> dfsQueue;
	static Queue<Integer> bfsQueue;
	static boolean[] dfsVisited;
	static boolean[] bfsVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		dfsQueue = new LinkedList<Integer>();
		bfsQueue = new LinkedList<Integer>();
		
		dfsVisited = new boolean[N+1];
		bfsVisited = new boolean[N+1];

		map = new boolean[N+1][N+1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[from][to] = true;
			map[to][from] = true;
		}
		
		dfsQueue.add(V);
		bfsQueue.add(V);
		dfs(V);
		bfs(V);
		
		StringBuilder sb = new StringBuilder();
		while(!dfsQueue.isEmpty()) {
			sb.append(dfsQueue.poll() + " ");
		}
		sb.append("\n");
		while(!bfsQueue.isEmpty()) {
			sb.append(bfsQueue.poll() + " ");
		}
		
		System.out.println(sb.toString());
	}

	private static void bfs(int from) {
		Queue<Integer> que = new LinkedList<Integer>();
		bfsVisited[from] = true; 
		que.offer(from);
		while(!que.isEmpty()) {
			int curr = que.poll();
			for (int i = 1; i <= N; i++) {
				if(!map[curr][i]) continue;
				if(bfsVisited[i]) continue;
				bfsVisited[i] = true;
				que.offer(i);
				bfsQueue.offer(i);
			}
		}
	}

	private static void dfs(int from) {
		dfsVisited[from] = true;
		for (int i = 1; i <= N; i++) {
			if(!map[from][i]) continue; 
			if(dfsVisited[i]) continue;
			dfsQueue.offer(i);
			dfs(i);
		}
	}
}
