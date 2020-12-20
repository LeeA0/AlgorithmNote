package day;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준_걷다보니신천역삼_14650_실버1
public class BOJ_14650_걷다보니신천역삼 {
	static int N, answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		nPr(0, 0);
		System.out.println(answer);
	}

	// cnt : 뽑은 개수, sum : 뽑은 숫자의 합
	private static void nPr(int cnt, int sum) {
		// 주어진 자리수 만큼 뽑았으면
		if (cnt == N) {
			// 3으로 나눠서 나눠떨어지면 3의 배수이므로 카운트
			if(sum%3==0) {
				answer++;
			}
			return;
		}
		// 0~2 중에 고른다
		for (int i = 0; i < 3; i++) {
			// 첫자리 숫자가 0이면 안되므로 스킵
			if (cnt == 0 && i == 0) {
				continue;
			}
			// 숫자를 고르고 다음 숫자를 뽑는다.
			nPr(cnt + 1, sum+i);
		}
	}
}