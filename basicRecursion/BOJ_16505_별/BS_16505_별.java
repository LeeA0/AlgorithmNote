package baekjoon.two;

import java.util.Scanner;

/**
 * 
 * @author BUMSEOK SEO
 * @problem 16505(silver) 별
 *
 */
public class BOJ_16505_별 {
	static int N;
	static char[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = (int)Math.pow(2, sc.nextInt());
		map = new char[N][N];
		
		print(N,0,0);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-i; j++) {
				if(map[i][j] == '*') {
					System.out.print(map[i][j]);
				}else {
					System.out.print(' ');
				}
			}
			if(i!= N-1)
				System.out.println();
		}
	}
	private static void print(int cnt, int sr, int sc) {
		if(cnt == 0) {
			map[sr][sc] = '*';
			return;
		}

		print(cnt/2, sr, sc);
		print(cnt/2, sr, sc + cnt/2);
		print(cnt/2, sr + cnt/2, sc);
//		print(cnt-1, sr + size/2, sc + size/2);
		
//		print(cnt-1);
//		print(cnt-1);
//		System.out.println();
//		print(cnt-1);
	}
}
