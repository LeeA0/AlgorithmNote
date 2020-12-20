package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_14650_걷다보니신척역삼 {
	static int N, answer;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		repeat_nPr(0, 0);
		System.out.print(answer);
	}

	private static void repeat_nPr(int cnt, int sum) {
		if(cnt==N) {
			//3의 배수는 각 자리수를 더한 값이 3으로 나누어 떨어지면 3의 배수이다.
			if(sum%3==0) answer++;
			return;
		}
		//첫 자리는 0으로 오지 못하기 때문에 cnt==0과 i==0이면 1부터
			for (int i = 0; i < 3; i++) {
				if(cnt==0 && i==0) continue;
				repeat_nPr(cnt+1, sum+i);
			}
	}
}