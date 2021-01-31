package baekjoon.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author BUMSEOK SEO
 * @problem 1120(silver) 문자열
 * 
 * 생각하는 방법 : 
 * 결국 앞뒤로 자유롭게 문자를 추가하여 맞출 수 있다고 한다면,
 * A문자열과 B문자열의 차이가 최소가 되는 지점에서 A문자열의 요소를 늘이면 차이에는 변함이 없으므로,
 * 해당 차이가 최소가 되는 부분을 검색하였다.
 *
 */
public class BOJ_1120_문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		/** 문자열 A와 B를 입력받는다 */
		String A = st.nextToken();
		String B = st.nextToken();
		
		/** 입력받을 수 있는 문자열은 50자를 넘지 않으므로, min의 초기값은 51로 초기화 한다 */
		int min = 51;
		/** A문자열을 B문자열과 비교한다,
		 * A와 B의 첫 요소를 비교하는 것부터 시작하여, A와 B의 끝요소를 비교할 때까지 한칸씩 이동시키면서 비교한다 */
		for (int i = 0; i <= B.length()- A.length(); ++i) {
			/** 다른 갯수를 카운트 하기 위한 변수 */
			int tmpCnt = 0;
			/** A 문자열과, B문자열로부터 A문자열 길이만큼 떼어내어서 비교한다.
			 * 이후 B문자열에서 떼어낸 문자열은 한칸씩 다음칸으로 이동하여 계속 비교하게 된다. 
			 */
			for (int j = 0; j < A.length(); ++j) {
				if(A.charAt(j) != B.charAt(j+i)) tmpCnt++;
			}
			// min과 차이값을 비교하여 min을 갱신한다.
			min = tmpCnt < min? tmpCnt : min;
		}
		/** 집계된 최소 값을 출력한다 */
		System.out.println(min);
	}
}
