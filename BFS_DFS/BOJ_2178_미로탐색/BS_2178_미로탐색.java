package baekjoon.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author BUMSEOK SEO
 * @problem baekjoon 2178(silver) 미로탐색
 */
public class BOJ_2178_미로탐색 {
	static int N, M;
	static char[] tmp;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 맵의 가로, 세로 길이 N,M을 입력받는다.
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 맵이 저장될 배열 선언
		map = new int[N][M];
		
		// 한 row의 입력을 char로 나누너 받은 후, int 변환을 하기 위한 임시 배열 선언
		tmp = new char[M];
		for (int i = 0; i < N; i++) {
			// 붙어있는 숫자들을 char형 문자로 나눈 후
			tmp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				// char형인 숫자들을 int형으로 바꾸어주면서 계산을 통해 다음 조건이 성립하도록 한다.
				// 조건 : 맵에서 -1은 갈 수 없는 부분, 0은 갈 수 있는 부분이 된다.
				map[i][j] = (tmp[j] - '0') - 1;
			}
		}
		
		// bfs메서드의 반환 값(목표 지점까지 최소 거리)를 출력한다. 
		System.out.println(bfs());
	}

	// 좌표값과 해당 지점까지 도달하기 위해 필요한 거리를 기억하는 Point 클래스
	static class Point {
		int r;
		int c;
		int steps;

		public Point(int r, int c, int steps) {
			this.r = r;
			this.c = c;
			this.steps = steps;
		}
	}

	// 우,하,좌,상 방향을 저장하는 배열
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	// 탐색하면서 원하는 값을 찾는다면 바로 해당 값을 반환하는 bfs 메서드 
	private static int bfs() {
		Queue<Point> que = new LinkedList<Point>();
		// 시작지점(0, 0)과 기본 거리값(1)을 큐에 넣어 탐색을 시작한다.
		que.add(new Point(0, 0, 1));
		/**
		 * 더이상 탐색을 진행할 점이 없을 때까지 반복.
		 * (문제의 조건에 무조건 목표지점에 도달할 수 있다고 하였으므로 while문이 끝나기 전에 무조건 반환된다)
		 */
		while (!que.isEmpty()) {
			// 다음 탐색을 진행할 point를 큐로부터 poll한다
			Point point = que.poll();

			/**
			 * 현재 사방 탐색을 진행하고자 하는 해당 점이 목표지점이라면
			 * 해당 점에 최단거리로 도달했다는 의미가 되므로
			 * 현재까지 카운트한 거리를 return 한다
			 */
			if (point.r == N - 1 && point.c == M - 1)
				return point.steps;
			// 4방탐색을 진행한다
			for (int i = 0; i < 4; i++) {
				int nr = point.r + dr[i];
				int nc = point.c + dc[i];
				// 해당 방향으로 진출했을 때 경계를 벗어났거나, 방분할 수 없는 점(-1), 이미 방문한 점(1~)이라면 continue한다
				if (!check(nr, nc) || map[nr][nc] != 0)
					continue;
				/**
				 * 진출할 수 있다면, 해당 점으로부터 4방탐색을 진행하기 위해
				 * 진출한 좌표와, 한칸 진출했으므로 거리+1한 값을 가진 point객체를 큐에 offer한다
				 */
				que.offer(new Point(nr, nc, point.steps + 1));
				// 진출한 점에 최소 거리를 저장하면서 방문처리를 해준다.
				map[nr][nc] = point.steps + 1;
			}
		}
		// (목표지점에 도달하지 못한다면 -1을 출력한다)
		return -1;
	}

	/**
	 * 경계값을 체크하는 메서드
	 * nr과 nc값이 0보다 크거나 같고, 각각 N, M보다 작다면 경계값을 벗어나지 않으므로
	 * true를 만환한다. 
	 */
	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}
}
