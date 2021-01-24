import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//똑같은 코드를 dfs로 했을 때는 왜 틀렸을까....?
public class Main_BOJ_1926_그림_bfs {
	
	/*
	 * 21.01.23 1926 그림
	 * 전형적인 단지번호 붙이는 문제
	 * dfs, bfs 둘다 사용 가능 
	 * 그러나 dfs로 했을 때는 틀리고, bfs로 했을 때는 맞았음
	 */
	
	static int R, C, danji, cnt, max;
	static int[][] map;
	static boolean[][] b;
	static Queue<Point> que;
	
	static class Point{
		int r;
		int c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		R = scann.nextInt();
		C = scann.nextInt();

		map = new int[R][C];
		b = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = scann.nextInt();
			}
		} // end input

		max = 0;
		danji = 0;
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 1 && !b[i][j]) { // 1이면서 아직 안갔으면
					cnt = 0; //넓이 초기화 0
					danji++; //그림 개수 증가
					bfs(i, j); //bfs 돌리기
					max = Math.max(max, cnt); //bfs 끝나면 그 그림의 넓이값과 현재 최대 넓이값 비교해서 갱신
				}
			}
		}
		
		System.out.println(danji);
		System.out.println(max);

	}

	private static void bfs(int r, int c) {
		que = new LinkedList<>();
		que.add(new Point(r, c));
		b[r][c] = true; //시작점
		
		while(!que.isEmpty()) {
			Point now = que.poll();
			cnt++; //넓이 증가
			
			for (int d = 0; d < 4; d++) {
				int nr = now.r + dr[d];
				int nc = now.c + dc[d];
				
				if(!check(nr,nc)) continue;
				if(!b[nr][nc]&&map[nr][nc]==1) {
					que.add(new Point(nr,nc));
					b[nr][nc] = true;
				}
			}
		}
		
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < R && nc >= 0 && nc < C;
	}

}
