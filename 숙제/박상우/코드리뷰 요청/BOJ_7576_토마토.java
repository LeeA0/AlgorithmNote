package final_algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토 {

	static Queue<int[]> que;
	static int N, M, map[][], countTomato, boxcount, visited[][], answer, countEmpty;
	static int dr[] = { 1, 0, -1, 0 };
	static int dc[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		que = new LinkedList<int[]>();
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[N][M];
		boxcount = N * M;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					que.offer(new int[] { i, j });
					countTomato++;
				}
				if (map[i][j] == -1) {
					boxcount--;
				}
				if (map[i][j] == 0) {
					countEmpty++;
				}
			}
		}
		if (countEmpty == 0) {
			answer = 0;
			System.out.println(answer);
			return;
		}
		solution();
		if (countTomato != boxcount) {
			answer = -1;
			System.out.println(answer);
			return;
		}

		System.out.println(answer-1);
	}

	static void solution() {
		while (!que.isEmpty()) {
			// 하루에 익어있는 숫자를 한번에 다 퍼트리기 위해 queSize를 구해서 그만큼 돌리고 이후 count 
			int queSize = que.size();
			for (int i = 0; i < queSize; i++) {
				int curr[] = que.poll();
				visited[curr[0]][curr[1]] = 1;
				for (int d = 0; d < 4; d++) {
					int nr = curr[0] + dr[d];
					int nc = curr[1] + dc[d];
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != -1 && visited[nr][nc] == 0 && map[nr][nc] == 0) {
						visited[nr][nc] = 1;
						que.offer(new int[] { nr, nc });
						countTomato++;
					}
				}
			}
			answer++;
		}
	}
}
