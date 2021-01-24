package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스_DFS_BFS {
	static LinkedList<Integer> adjList[];
	static boolean visited[];
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int V, E;
		//정점의 개수를 입력받는다.
		V = Integer.parseInt(br.readLine());
		//간선의 개수를 입력받는다.
		E = Integer.parseInt(br.readLine());
		
		//인접리스트를 만든다.
		adjList = new LinkedList [V+1];
		
		//인접리스트에 객체를 생성한다.
		for (int i = 1; i <= V; i++) {
			adjList[i] = new LinkedList<>();
		}
		
		//간선을 입력받는다. A<->B 형태이다(양방향)
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			adjList[v1].add(v2);
			adjList[v2].add(v1);
		}
		visited = new boolean[V+1];
//		dfs(1);
		bfs(1);
		answer();
	}
	static void dfs(int v) {
		//방문 처리
		visited[v] = true;
		for (int i = 0; i < adjList[v].size(); i++) {
			int cv = adjList[v].get(i);
			if(visited[cv]) continue;
			dfs(cv);
		}
	}
	static void bfs(int v) {
		Queue<Integer> que = new LinkedList<>();
		visited[v] = true;
		que.offer(v);
		while(!que.isEmpty()) {
			int curr = que.poll();
			for (int i = 0; i < adjList[curr].size(); i++) {
				int cv = adjList[curr].get(i);
				if(!visited[cv]) {
					visited[cv] = true;
					que.offer(cv);
				}
			}
		}
	}
	static void answer() {
		int cnt=0;
		for (int i = 0; i <visited.length ; i++) {
			if(visited[i]) cnt++;
		}
		//1번 pc를 뺸다.
		System.out.println(cnt-1);
	}
}
