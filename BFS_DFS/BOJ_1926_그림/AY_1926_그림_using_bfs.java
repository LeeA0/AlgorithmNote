package day;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준_그림_1926_실버1
public class BOJ_1926_그림_using_bfs {
	// 상하좌우
	static int[][] dir4 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	// 도화지의 세로크기, 도화지의 가로크기
	static int N, M;
	// 도화지
	static boolean[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < M; j++) {
				// map이 1이면 true, 0이면 false를 저장 (주어지는 값이 1또는 0임)
				map[i][j] = Integer.parseInt(st.nextToken())==1;
			}
		} // 입력 끝

		// 그림의 개수
		int count = 0;
		// 가장 넓은 그림의 넓이
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 그림이 그려진 부분이면
				if (map[i][j]) {
					// 그림의 개수를 +1
					count++;
					// 그림의 너비가 기존 max값보다 크면 갱신
					max = Math.max(max, bfs(i, j));
				}
			}
		}
		// 출력
		StringBuilder sb = new StringBuilder();
		sb.append(count).append("\n").append(max);
		System.out.print(sb);
	}

	// x와 y는 현재 그림이 시작되는 곳의 좌표
	public static int bfs(int x, int y) {
		// bfs로 탐색하기 위해 que를 선언
		Queue<int[]> que = new LinkedList<>();
		// 현재 좌표를 que에 넣음
		que.offer(new int[] { x, y });
		// 영역의 넓이를 체크하는 변수
		// 현재 칸을 방문해 있으므로 1로 초기화
		int cnt = 1;
		// 현재 칸에 방문했으면 다시 방문하지 않을 것이므로 false로 표시
		map[x][y] = false;
		
		// que가 비어있지 않을 때까지 반복
		while (!que.isEmpty()) {
			// 가장 먼저 들어온 좌표를 현재좌표로 받음
			int[] curr = que.poll();
			// 현재 좌표를 기점으로 4방향 탐색
			for (int[] d : dir4) {
				// 현재 좌표에서 4방향 중 한방향으로 이동
				int nx = curr[0]+d[0];
				int ny = curr[1]+d[1];
				// 이동한 좌표가 영역에서 벗어났거나 false상태이면 넘김
				if(!check(nx,ny)||!map[nx][ny])continue;
				// 아니면 이동한 좌표 저장
				que.offer(new int[] {nx,ny});
				// 그림의 넓이+1
				cnt++;
				// 해당 칸에 방문했다는 표시
				map[nx][ny]=false;
			}
		}
		return cnt;
	}
	// x, y는 영역을 벗어났는지 아닌지 체크하는 변수
	public static boolean check(int x, int y) {
		// 영역을 벗어났으면 false, 아니면 true
		return (x>=0&&x<N&&y>=0&&y<M);
	}
}
