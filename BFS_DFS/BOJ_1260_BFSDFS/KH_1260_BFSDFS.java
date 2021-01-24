package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_BFSDFS {
	static StringBuilder sb = new StringBuilder();
	static boolean [] visited;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		//0 정점의 개수, 1 간선의 개수, 2 탐색 시작 번호
		int N, M, V;
		st = new StringTokenizer(br.readLine()," ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		//인접 리스트를 만든다.
		LinkedList<Integer> adjList[] = new LinkedList [N+1];
		
		//인접리스트에 객체를 만들어 준다.
		for (int i = 1; i <= N; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
		
		//간선 정보를 입력 받는다.
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken()); //시작점
			int v2 = Integer.parseInt(st.nextToken()); //도착점
			
			adjList[v1].add(v2);
			adjList[v2].add(v1);
		}
		//낮은 숫자 순서로 방문해야 하므로 정렬해준다.
		for (int i = 1; i <= N; i++) {
			Collections.sort(adjList[i]);
		}
		//방문 배열 초기화
		visited = new boolean[N+1];
		dfs(V, adjList);
		sb.append('\n');
		//방문 배열 초기화
		visited = new boolean[N+1];
		bfs(V, adjList);
		System.out.print(sb);
	}
	static void dfs(int v, LinkedList<Integer>[] adjList)throws Exception {
		//해당 정점을 방문 했다면 종료
		if(visited[v]) return;
		//방문하지 않았다면 방문 처리
		visited[v] = true;
		sb.append(v).append(' ');
		//현재 정점에 연결된 다른 모든 정점을 깊이 우선으로 탐색한다.
		for (int i = 0; i < adjList[v].size(); i++) {
			int next = adjList[v].get(i);
			dfs(next, adjList);
		}
	}
	static void bfs(int v, LinkedList<Integer>[] adjList)throws Exception {
		Queue<Integer> que = new LinkedList<>();
		//que에 최초 정점을 넣는다.
		que.offer(v);
		//최초 정점을 방문처리 한다.
		visited[v] = true;
		sb.append(v).append(' ');

		//연결된 모든 정점을 방문할 때 까지 반복한다. 
		while(!que.isEmpty()) {
			//que 가장 앞에 있는 정점을 가지고 온다. 
			int curr = que.poll();
			//해당 정점에 +1 level인 방문하지 않은 모든 정점을 찾는다.
			for (int i = 0; i < adjList[curr].size(); i++) {
				int visit = adjList[curr].get(i);
				//이미 방문한 정점이라면 패스
				if(visited[visit]) continue;
				//방문하지 않은 정점이면 방문 처리
				visited[visit] = true;
				sb.append(visit).append(' ');
				//방문 처리 후, que에 넣는다.
				que.offer(visit);
			}
		}
	}
}