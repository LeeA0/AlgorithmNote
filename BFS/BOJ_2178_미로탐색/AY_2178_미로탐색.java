package day;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준_미로탐색_2178_실버1
public class BOJ_2178_미로탐색 {
	static int[][] map;
	static int N, M;
	static int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상 하 좌 우

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().trim().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp[j] - '0';
			}
		}

		System.out.println(bfs());
	}

	public static int bfs() {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { 0, 0 });
		while (!que.isEmpty()) {
			int[] curr = que.poll();
			for (int[] d : dir4) {
				int nx = curr[0]+d[0];
				int ny = curr[1]+d[1];
				if(!check(nx,ny)||map[nx][ny]!=1)continue;
				map[nx][ny]=map[curr[0]][curr[1]]+1;
				if(nx==N-1&&ny==M-1) return map[nx][ny];
				que.offer(new int[] {nx,ny});
			}
		}
		return 0;
	}

	public static boolean check(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
}