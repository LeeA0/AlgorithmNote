package day;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 프로그래머스_전화번호목록_레벨2
public class Programmers_전화번호목록 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String[] phone_book = new String[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			phone_book[i] = st.nextToken();
		}
		System.out.println(solution(phone_book));
	}

	static boolean solution(String[] phone_book) {
		// 많은 문자열 비교는 hashcode가 더빠르다!!
		// 0 ~ N-1까지 기준
		for (int i = 0; i < phone_book.length; i++) {
			// 기준 점을 i+1~N까지 비교한다.
			for (int j = i + 1; j < phone_book.length; j++) {
				// 만약 i의 길이와 j의 길이 중 j의 길이가 같거나 길면
				if (phone_book[j].length() >= phone_book[i].length()) {
					// j의 길이를 앞에서 부터 i의 길이까지 자른 후 hashcode로 만들어서 비교
					if (phone_book[j].substring(0, phone_book[i].length()).hashCode() == phone_book[i].hashCode()) {
						// 같으면 false리턴
						return false;
					}
				}
				// i의 길이와 j의 길이 중 i의 길이가 길면
				else {
					// i의 길이를 앞에서 부터 j의 길이까지 자른 후 hashcode로 만들어서 비교
					if (phone_book[i].substring(0, phone_book[j].length()).hashCode() == phone_book[j].hashCode()) {
						// 같으면 false리턴
						return false;
					}
				}
			}
		}
		// 같은게 없으면 true리턴
		return true;
	}
}
