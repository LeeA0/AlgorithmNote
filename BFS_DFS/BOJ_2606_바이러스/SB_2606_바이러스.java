import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BOJ_2606_바이러스 {
	/*
	 * 21.01.23 2606 바이러스
	 * 그래프탐색 bfs 사용해서 풀이
	 */
	
	static int V, E, cnt;
	static boolean[][] connect;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		V = scann.nextInt();
		E = scann.nextInt();
		
		connect = new boolean[V+1][V+1]; //1번 부터 번호
		visited = new boolean[V+1];
		
		for (int i = 0; i < E; i++) {
			int r = scann.nextInt();
			int c = scann.nextInt();
			
			connect[r][c] = connect[c][r] = true; //양방향 연결
		}//end input
		
		
		bfs(1);
		
		System.out.println(cnt-1); //1번은 제외
	}

	private static void bfs(int start) {
		Queue<Integer> que = new LinkedList<>();
		que.add(start);
		visited[start] = true;
		
		while(!que.isEmpty()) {
			cnt++;
			int now = que.poll();
			
			for (int i = 1; i < V+1; i++) {
				if(connect[now][i] && !visited[i]) { //연결되어 있으면서 아직 방문 안했으면
					que.add(i);
					visited[i] = true;
					
				}
			}
		}
	}

}
