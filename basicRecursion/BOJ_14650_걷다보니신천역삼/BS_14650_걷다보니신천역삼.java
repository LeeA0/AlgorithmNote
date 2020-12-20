package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14650_걷다보니신천역삼 {
	static int N;
	static int resultCnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		// 최상위 자리수가 1일경우
		bf(1, 1);
		// 최상위 자리수가 2일경우
		bf(1, 2);
		System.out.println(resultCnt);
	}

	private static void bf(int depth, int sum) {
		// 모든 자리의 수를 더한 뒤에
		if (depth == N) {
			// 그 합이 3으로 나누어 떨어지면
			if (sum % 3 == 0) {
				// 3의 배수가 되므로 결과값을 올려준다.
				resultCnt++;
			}
			return;
		}
		
		// 현재 자리수의 값이 0일 경우
		bf(depth + 1, sum + 0);
		// 현재 자리수의 값이 1일 경우
		bf(depth + 1, sum + 1);
		// 현재 자리수의 값이 2일 경우
		bf(depth + 1, sum + 2);
	}
}
