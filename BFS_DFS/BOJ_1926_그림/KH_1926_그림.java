package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1926_그림 {
	//행,열, 해당 그림 크기, 최대 크기, 그림 개수
	static int N, M, P, max, cnt;
	//도화지
	static boolean map[][];
	//방향
	static int [][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		
		//입력값이 1이면 true 입력값이 0이면 false
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken())==1 ? true : false;
			}
		}
		//flood fill 형태로 진행한다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				//아직 방문하지 않은 그림이면 bfs or dfs를 수행한다.
				if(map[i][j]) { 
					cnt++;
					P=1;
//					dfs(i, j);
					bfs(i,j);
					//가장 큰 그림을 찾는다.
					max = Math.max(P, max);
				}
			}
		}
		System.out.print(cnt+"\n"+max);
	}
	static void dfs(int r, int c) {
		//현재 정점을 방문처리 한다.
		map[r][c] = false;
		//현재 정점에서 상하좌우로 연결된 정점을 찾는다.
		for (int i = 0; i < 4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			//도달할 수 있는 정점이라면
			if(check(nr,nc) && map[nr][nc]) {
				//그림의 크기 +1
				P++;
				dfs(nr,nc);
			}
		}
	}
	static void bfs(int r, int c) {
		Queue<int []> que = new LinkedList<>();
		//현재 정점을 방문처리 한다.
		map[r][c] = false;
		//que에 현재 정점을 넣는다.
		que.offer(new int [] {r,c});
		//해당 정점에서 level +1인 모든 정점을 순차적으로 방문한다.
		while(!que.isEmpty()) {
			//que의 가장 앞에 있는 정점을 가지고 온다.
			int [] curr = que.poll();
			//4방으로 방문할 수 있는 정점을 찾는다.
			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dir[i][0];
				int nc = curr[1] + dir[i][1];
				//아직 방문하지 않은 정점이면
				if(check(nr,nc) && map[nr][nc]) {
					//방문 처리
					map[nr][nc] = false;
					//그림의 크기 +1
					P++;
					//정점을 que에 넣는다.
					que.offer(new int [] {nr,nc});
				}
			}
		}
	}
	static boolean check(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<M) return true;
		return false;
	}
}