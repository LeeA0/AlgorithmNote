package baekjoon.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @author BUMSEOK SEO
 * @problem 1926(silver) 그림
 *
 */
public class BOJ_1926_그림 {
	static int picNumCnt;
	static int N, M;
	static int[][] map;
	static int[] picWidthCnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		// 500 * 500 != 2500
		picWidthCnt = new int[250001];
		
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				/**
				 *  색칠이 안된 부분을 -1 색칠이 된 부분을 0으로 하여 배열에 입력받는다
				 *  이로써 세지 않은 그림 영역은 0이 되고, 그림을 하나 추가할 때마다 해당 그림의 번호로 채워지게 된다(1,2,3 ---)
				 */
				  
				map[i][j] = Integer.parseInt(st.nextToken()) - 1;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = ++picNumCnt;
					picWidthCnt[picNumCnt]++;
					bfs(i,j);
				}
			}
		}
		int max = 0;
		for (int i = 1; i <= picNumCnt; i++) {
			if(picWidthCnt[i] > max) max = picWidthCnt[i];
		}
		System.out.println(picNumCnt);
		System.out.println(max);
	}

	static class Point{
		int r;
		int c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	private static void bfs(int sr, int sc) {
		Queue<Point> que = new LinkedList<Point>();
		que.add(new Point(sr, sc));
		while(!que.isEmpty()) {
			Point curr = que.poll();
			for (int d = 0; d < 4; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				if(!check(nr,nc) || map[nr][nc] != 0) continue;
				map[nr][nc] = picNumCnt;
				picWidthCnt[picNumCnt]++;
				que.add(new Point(nr,nc));
			}
		}
		
	}
	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
