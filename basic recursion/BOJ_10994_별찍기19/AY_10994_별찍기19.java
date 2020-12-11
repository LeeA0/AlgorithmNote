package day;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준_별찍기19_10994_실버4
public class BOJ_10994_별찍기19 {
	static boolean[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		// 제일 큰 정사각형의 변의 길이
		int W = (N - 1) * 4 + 1;
		// 별을 그려줄 map생성
		map = new boolean[W][W];
		// 별찍기 시작
		makeStar(N, 0, 0);
		// map이 true면 *을, 아니면 공백을 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < W; i++) {
			for (int j = 0; j < W; j++) {
				sb.append(map[i][j]?"*":" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	private static void makeStar(int n, int x, int y) {
		if (n == 1) {
			map[x][y]=true;
			return;
		}
		int w = (n - 1) * 4 + 1;
		// 윗줄과 아랫줄에 별
		for (int j = y; j < y + w; j++) {
			map[x][j] = true;
			map[x + w - 1][j] = true;
		}
		// 왼쪽줄과 오른쪽줄에 별
		// (이미 지나간 x,y와 x+w-1,y+w-1은 굳이 다시 별찍을 필요 없음)
		for (int i = x + 1; i < x + w - 1; i++) {
			map[i][y] = true;
			map[i][y + w - 1] = true;
		}
		// 안 쪽 별그리기
		makeStar(n - 1, x + 2, y + 2);
	}
}
