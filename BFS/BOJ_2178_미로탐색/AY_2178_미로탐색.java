package day;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준_미로탐색_2178_실버1
public class BOJ_2178_미로탐색 {
	static int[][] map; // 미로지도, int로 한 이유 : map에 출발점에서 해당 점까지의 거리를 표시하기 위해
	static int N, M; // N: 도착열, M : 도착행
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
		}// 입력 끝

		System.out.println(bfs());
	}

	public static int bfs() {
		// 현재 위치 저장할 Queue선언
		Queue<int[]> que = new LinkedList<>();
		// 시작점을 Queue에 넣음
		que.offer(new int[] { 0, 0 });
		// Queue가 비어있지 않을 때
		while (!que.isEmpty()) {
			// Queue에서 현재 위치를 꺼냄
			int[] curr = que.poll();
			// 현재 위치에서 4방 탐색
			for (int[] d : dir4) {
				// nx : 인접한 곳으로 한칸 이동한 뒤의 행 위치
				// ny : 인접한 곳으로 한칸 이동한 뒤의 열 위치
				int nx = curr[0]+d[0];
				int ny = curr[1]+d[1];
				// 이동한 곳의 위치가 미로 범위에서 벗어났거나 1이 아닌경우 큐에 저장하지 않고 거리를 저장하지 않는다.
				// 1이 아닌 경우 저장하지 않는 이유 : 0은 이동할 수 없는 칸, 갈 수 있지만 아직 가지 않은 곳이면 1, 이미 방문했다면 거리가 들어있어 2이상 이다.
				// 2이상인 경우 곳에 다시 도달하는 경우 뒤늦게 해당지점에 도착했다는 의미이므로 최단거리가 아니여서 고려할 필요없다.
				if(!check(nx,ny)||map[nx][ny]!=1)continue;
				// 이동한 위치에 (출발점부터 현재위치까지의 거리) + 1를 저장
				map[nx][ny]=map[curr[0]][curr[1]]+1;
				// 목적지(N-1,M-1)에 도착했으면 거리를 리턴
				if(nx==N-1&&ny==M-1) return map[nx][ny];
				// 도착하지 않았다면 Queue에 해당 위치를 저장한다.
				que.offer(new int[] {nx,ny});
			}
		}
		return 0;
	}

	public static boolean check(int x, int y) {
		// map의 범위 안에 있으면 true, 아니면 false
		return x >= 0 && x < N && y >= 0 && y < M;
	}
}