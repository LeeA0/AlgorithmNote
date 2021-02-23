package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준_기타줄_1049_실버4
public class BOJ_1049_기타줄 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 끊어진 기타줄 수
		int N = Integer.parseInt(st.nextToken());
		// 기타줄 브랜드 수
		int M = Integer.parseInt(st.nextToken());
		// 6개 세트 최소 비용
		int min_six = 1000;
		// 1개 최소 비용
		int min_one = 1000;
		
		// 브랜드 중에 가장 저렵한 6개 세트 비용과 1개 비용을 구한다
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			min_six = Math.min(min_six, Integer.parseInt(st.nextToken()));
			min_one = Math.min(min_one, Integer.parseInt(st.nextToken()));
		}
		
		// 만약 1개 비용 * 6이 6개 세트 최소 비용보다 작으면
		if (min_six > min_one * 6) {
			// 6개 세트 최소 비용을 낱개로 6개 산 비용으로 변경
			min_six = min_one * 6;
		}
		
		// 6개 세트 비용으로 6개씩 묶어서 산다
		// ex) 15개면 15개 중에 12개를 세트로 구매
		int cost = N / 6 * min_six;
		// 더 사야할 기타 줄 수 를 계산
		N -= N / 6 * 6;
		// 낱개로 사는 비용이 더 저렴하면
		if (min_six > N * min_one) {
			// 낱개로 구매
			cost += N * min_one;
		} 
		// 아니면
		else {
			// 세트로 구매
			cost += min_six;
		}
		System.out.println(cost);
	}
}
