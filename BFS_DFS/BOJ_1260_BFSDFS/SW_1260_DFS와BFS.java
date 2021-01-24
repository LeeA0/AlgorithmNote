package final_algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {

	static int N, M, V;
	static LinkedList<Integer> list[];
	static boolean visited[];
	static StringBuilder sb_bfs, sb_dfs;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken()); // 정점의 갯수
		M = Integer.parseInt(st.nextToken()); // 간선의 갯수
		V = Integer.parseInt(st.nextToken()); // 시작할 정점의 번호
		
		list = new LinkedList[N+1];
		// list 초기화
		for (int i = 1; i <= N; i++) {
			list[i] = new LinkedList<>();
		}
		// list 이어붙이기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}
		// 작은 순서로 들어갈 수 있도록 정렬
		for (int i = 1; i <= N; i++) {
			Collections.sort(list[i]);
		}
		//StringBuilder bfs/dfs
		sb_bfs = new StringBuilder();
		sb_dfs = new StringBuilder();
		
		visited = new boolean [N+1];
		dfs(V);
		System.out.println(sb_dfs.toString());
		visited = new boolean [N+1];
		bfs(V);
		System.out.println(sb_bfs.toString());
	}
	
	public static void bfs(int start) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(start);
		visited[start] = true;
		//최초 start 값을 담기 위해 append
		sb_bfs.append(start+" ");
		while(!que.isEmpty()) {
			int curr = que.poll();
			for (int i : list[curr]) {
				if(!visited[i]) {
					// 이후 bfs 값들을 append
					sb_bfs.append(i+" ");
					visited[i] = true;
					que.offer(i);
				}
			}
		}
	}
	
	public static void dfs(int start) {
		visited[start]=true;
		sb_dfs.append(start+" ");
		for (int i : list[start]) {
			if(!visited[i]) {
				visited[i]=true;
				dfs(i);
			}
		}
	}
}
