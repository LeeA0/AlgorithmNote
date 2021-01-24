import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BOJ_1260_DFS와BFS {
	/*
	 * 21.01.23 1260 DFS와 BFS
	 * 정점 탐색 순서 dfs, bfs의 차이
	 */
	
	static int N, M, V; //N(정점개수), M(간선개수), V(탐색시작정점) 
	static boolean[][] connect; //인접행렬로 풀이
	static boolean[] b; //방문 여부 체크
	static StringBuilder sbDFS, sbBFS; //DFS 순서, BFS 순서 저장할 Stringbuilder
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		M = scann.nextInt();
		V = scann.nextInt();
		
		connect = new boolean[N+1][N+1]; //정점의 번호는 1번부터이므로 N+1 크기의 인접행렬 크기
		
		for(int i = 0; i<M; i++) {
			int r = scann.nextInt();
			int c = scann.nextInt();
			
			connect[r][c] = connect[c][r] = true; //(양방향 연결) 연결되어 있으면 true, 아니면 false
			
		} //end input
		
		sbDFS = new StringBuilder();
		sbBFS = new StringBuilder();
		
		b = new boolean[N+1];
		dfs(V);
		
		b = new boolean[N+1]; //방문배열 초기화
		bfs(V);
		
		System.out.println(sbDFS.toString());
		System.out.println(sbBFS.toString());
	}

	private static void bfs(int vertex) {
		b[vertex] = true; //시작점 방문처리
		Queue<Integer> que = new LinkedList<>();
		que.add(vertex); //시작점 que에 삽입
		
		while(!que.isEmpty()) {
			vertex = que.poll(); 
			sbBFS.append(vertex).append(" "); //방문한 정점 결과에 추가
			
			for (int i = 1; i < N+1; i++) {
				if(connect[vertex][i] && !b[i]) { //연결 되어 있으면서 아직 방문안했으면
					b[i] = true; //들어갈때 방문처리
					que.add(i); //큐에 삽입
				}
			}
		}
	}

	private static void dfs(int vertex) {
		b[vertex] = true; //방문처리 
		sbDFS.append(vertex).append(" "); //결과값에 추가
		
		for (int i = 1; i < N+1; i++) {
			if(connect[vertex][i] && !b[i]) { //연결되어있으면서 아직 안갔으면
				dfs(i); //재귀를 이용하여 dfs 
			}
		}
	}

}
