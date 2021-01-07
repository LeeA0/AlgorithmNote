import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_2178_미로탐색 {
	/*
	 * 2021.01.06 BOJ 2178 미로탐색
	 * 최소칸수 -> BFS
	 */
	static int N, M, ans;
	static int[][] map;
	static boolean[][] b; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp.charAt(j)-'0';
			}
		}//input

		ans = 0;
		//bfs
		bfs();
		System.out.println(ans);
	}
	
	static class Point{
		int r;
		int c;
		int cnt; //전진한 칸수를 저장하는 변수
		
		public Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1}; //상하좌우
	private static void bfs() {
		b = new boolean[N][M];

		Queue<Point> que = new LinkedList<>();
		que.add(new Point(0, 0, 1)); //시작점 que에 넣기
		b[0][0] = true; //방문 체크

		while(!que.isEmpty()) {
			Point p = que.poll();
			ans++;
			if(p.r==N-1 && p.c==M-1) { //N,M을 만나면 종료(인덱스이므로 N-1, M-1 해줘야함)
				ans = p.cnt;
				return;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = p.r+dr[d];
				int nc = p.c+dc[d];
				if(!check(nr,nc)) continue; //갈수 없으면 컨티뉴
			
				if(!b[nr][nc] && map[nr][nc]==1) { //아직 안갔으면서 1이면
					que.add(new Point(nr, nc, p.cnt+1)); //다음 가는 cnt는 현재까지 온 곳에서 +1 
					b[nr][nc] = true; //방문처리
				}
			}
		}
		
	}
	private static boolean check(int nr, int nc) {
		return nr>=0&&nr<N&&nc>=0&&nc<M;
	}

}
