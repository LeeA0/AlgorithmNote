package final_algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1926_색종이 {

	static int n, m, map[][], visited[][];
	static int dr[] = { 1, 0, -1, 0 };
	static int dc[] = { 0, 1, 0, -1 };
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0; 
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && visited[i][j] == 0) {
					// 최초의 그림의 넓이 발견은 1일테니 default값을 1로 지정.
					int countMAX = 1;
					// 최초 1인 지점을 만났을때 1로 체크 이후 다른 그림만났을때 ++진행.
					cnt ++;
					bfs(i, j, cnt, countMAX);
				}
			}
		}
		System.out.println(cnt);
		// 예외처리 : 만약 그림이 하나도 안주어 진다면 0으로 출력.
		if (max == Integer.MIN_VALUE) {
			System.out.println(0);
		}else {
			System.out.println(max);
		}
	}

	/**
	 * 너비 우선 탐색
	 * @param r 세로
	 * @param c 가로
	 * @param cnt 그림의 갯수
	 * @param countMAX 가장 넓은 그림의 넓이
	 */
	public static void bfs(int r, int c, int cnt, int countMAX) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {r,c});
		visited[r][c]=cnt;
		
		while(!que.isEmpty()) {
			int[] curr = que.poll();
			int cr = curr[0];
			int cc = curr[1];
			for (int d = 0; d < 4; d++) {
				int nr = cr +dr[d];
				int nc = cc +dc[d];
				if (!check(nr,nc)) continue;
				if (map[nr][nc]==1 && visited[nr][nc] == 0) {
					countMAX++;
					visited[nr][nc]=cnt;
					que.offer(new int[] {nr,nc});
				}
				// 가장 넓은 그림일 경우 max값 최신화
				if (max<countMAX)  max = countMAX;
			}
		}
	}

	private static boolean check(int r, int c) {
		if (r >= 0 && r < n && c >= 0 && c < m) {
			return true;
		} else
			return false;
	}
}
