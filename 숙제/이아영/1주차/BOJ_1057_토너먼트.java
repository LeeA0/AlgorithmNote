package day;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준_토너먼트_1057_실버3
public class BOJ_1057_토너먼트 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 참가자 수
		int N = Integer.parseInt(st.nextToken());
		// 김지민의 번호
		int kim = Integer.parseInt(st.nextToken());
		// 임한수의 번호
		int lim = Integer.parseInt(st.nextToken());
		// 라운드 수
		int round = 1;
		
		// 둘이 만날 때까지 반복
		while (true) {
			// 김지민의 번호가 홀수이면 +1
			if (kim % 2 == 1) {
				kim++;
			}
			// 임한수의 번호가 홀수이면 +1
			if (lim % 2 == 1) {
				lim++;
			}
			// 김지민과 임한수가 만나면 종료
			if (kim == lim) {
				break;
			}
			
			// 다음 라운드 진출 후 번호 계산
			kim /= 2;
			lim /= 2;
			
			// 라운드 증가
			round++;
		}
		System.out.println(round);
	}
}
