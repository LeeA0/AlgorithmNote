package day;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준_큰수구성하기_18511
public class BOJ_18511_큰수구성하기 {
	static int N, K, answer;
	static int[] kList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		// N을 String타입으로 받음
		String N_temp = st.nextToken();
		// N의 자릿수를 구함
		int N_length = N_temp.length();
		// N을 Int타입으로 변환
		N = Integer.parseInt(N_temp);
		// K값 받음
		K = Integer.parseInt(st.nextToken());
		// 숫자들 입력
		kList = new int[K];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < K; i++) {
			kList[i] = Integer.parseInt(st.nextToken());
		}
		// 오름차순으로 정렬
		Arrays.sort(kList);
		answer = 0;
		// N의 자리 수 부터 1씩 감소하며 함수를 호출
		for (int i = N_length; i > 0;i--) {
			if(subset(0, "", i)) {
				break;
			}
		}
//		subset(0);
		System.out.println(answer);
	}

	// cnt : 숫자를 고른 개수, number : 고른 숫자, endCnt : 골라야하는 개수
	private static boolean subset(int cnt, String number,int endCnt) {
		// 목표 자리 수 까지 숫자를 뽑았을 때
		if (cnt == endCnt) {
			// String형태의 number를 Int형태의 num으로 변환
			int num = Integer.parseInt(number);
			// 숫자가 N보다 크면
			if (num <= N) {
				// answer에 저장
				answer = num;
				// 큰 수 부터 num에 저장했으므로, 조건에 해당하는 값을 찾은 것은 해당 num이 조건을 만족하는 최대 값이라는 것
				return true;
			}
			//아니면 false로 리턴
			return false;
		}
		// 큰 수 부터 저장할 수 있도록 거꾸로 돌림
		for (int i = K - 1; i >= 0; i--) {
			// 최대값을 찾았으면 true로 리턴해서 쭈욱 나감
			if (subset(cnt + 1, number + kList[i], endCnt)) {
				return true;
			}
		}
		// 아니면 false리턴
		return false;
	}

	
	// 참고할만한 소스
//	private static void subset(int num) {
		// 뽑은 수가 N보다 크면 리턴
//		if(num>N) {
//			return;
//		}
		// 크지않다면 answer와 비교해서 저장
//		answer = Math.max(answer, num);
	    // 큰 수 부터 저장할 수 있도록 거꾸로 돌림
//		for (int i = K - 1; i >= 0; i--) {
			// 지금 숫자를 한자리 수 밀고 새로 뽑은 숫자를 저장
//			subset(num*10+kList[i]);
//		}
//	}
}
