import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//�Ȱ��� �ڵ带 dfs�� ���� ���� �� Ʋ������....?
public class Main_BOJ_1926_�׸�_bfs {
	
	/*
	 * 21.01.23 1926 �׸�
	 * �������� ������ȣ ���̴� ����
	 * dfs, bfs �Ѵ� ��� ���� 
	 * �׷��� dfs�� ���� ���� Ʋ����, bfs�� ���� ���� �¾���
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
				if (map[i][j] == 1 && !b[i][j]) { // 1�̸鼭 ���� �Ȱ�����
					cnt = 0; //���� �ʱ�ȭ 0
					danji++; //�׸� ���� ����
					bfs(i, j); //bfs ������
					max = Math.max(max, cnt); //bfs ������ �� �׸��� ���̰��� ���� �ִ� ���̰� ���ؼ� ����
				}
			}
		}
		
		System.out.println(danji);
		System.out.println(max);

	}

	private static void bfs(int r, int c) {
		que = new LinkedList<>();
		que.add(new Point(r, c));
		b[r][c] = true; //������
		
		while(!que.isEmpty()) {
			Point now = que.poll();
			cnt++; //���� ����
			
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
