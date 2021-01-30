package day;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ_문자열_1120_실버4
public class AY_1120_문자열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String A = st.nextToken();
		String B = st.nextToken();// 입력완료
		
		// A문자열과 B문자열의 문자 개수 차이
		int diff_length = B.length() - A.length();
		
		// A와 B의 최소 차이, A와 B의 최대길이가 50이므로 1더 큰 50으로 초기화
		int min_diff = 51;
		
		// 개수차이+1의 횟수만큼 A와 B를 비교해준다
		for (int i = 0; i < diff_length + 1; i++) {
			// A[i]와 B[i]의 차이를 세줌
			int diff = 0;
			// B문자의 첫 시작점을 +1씩 바꾸며 A문자와의 차이를 센다
			for (int j = 0; j < A.length(); j++) {
				// 다르면 +1
				if (A.charAt(j) != B.charAt(i + j))
					diff++;
			}
			// 최소 차이값을 저장
			min_diff = Math.min(min_diff, diff);
		}
		System.out.println(min_diff);
	}
}
