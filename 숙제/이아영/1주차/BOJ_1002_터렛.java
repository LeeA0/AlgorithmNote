package day;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준_터렛_1002_실버4
public class BOJ_1002_터렛 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());

			// 각 터렛의 거리
			double dist = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
			
			// 터렛의 위치 및 거리가 같을 때 무한대
			if(x1==x2&&y1==y2&&r1==r2) {
				sb.append(-1);
			}
			// 내접과 외접범위의 안쪽에 있을 때 접점 2개
			else if (Math.abs(r1 - r2) < dist && dist < r1 + r2) {
				sb.append(2);
			}
			// 내접 혹은 외접일 때 접점 1개
			else if (Math.abs(r1 - r2) == dist || r1 + r2 == dist) {
				sb.append(1);
			}
			// 그 밖에 접점 0개
			else {
				sb.append(0);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
