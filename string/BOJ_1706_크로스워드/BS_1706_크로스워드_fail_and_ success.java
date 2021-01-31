package baekjoon.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 
 * @author BUMSEOK SEO
 * @problem 1706(silver) 크로스워드
 *
 */
public class BOJ_1706_크로스워드 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		/** 크로스워드를 저장할 매열 선언 */
		char[][] map = new char[R][];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		/** 문자열이 사전순으로 쌓이도록하기 위해서 PriorityQueue 사용*/
		PriorityQueue<String> pq = new PriorityQueue<String>();

		/** 파싱하는 중에 생성되는 문자열을 저장해둘 변수를 지정합니다 */
		String tmp = "";
		
		/** 열에 있는 낱말(== 2글자 이상으로 이루어진 문자열) 파싱 시작 */
		for (int i = 0; i < R; i++) {
			/** 각 열을 순차적으로 탐색 */
			for (int j = 0; j < C; j++) {
				/** #을 만난다면 */
				if (map[i][j] == '#') {
					/** 임시 문자열이 낱말인 경우에만 PriorityQueue에 추가한다 */
					if (tmp.length() > 1) {
						pq.add(tmp);
					}
					/** #을 만났으므로,
					 *  이전에 쌓아둔 문자열은 더이상 확장할 수 없으므로 초기화 */
					tmp = "";
					continue;
				/** #이 아닌 열의 마지막 요소라면 */
				} else if (j == C - 1) {
					/** 일단 임시 문자열에 추가하고 낱말이라면 PriorityQueue에 추가
					 * (풀기 직전까지 발견하지 못했던 부분) */
					tmp += map[i][j];
					if (tmp.length() > 1) {
						pq.add(tmp);
					}
					/** 열의 끝을 만났으므로,
					 * 이전에 쌓아둔 문자열을 더이상 확장할 수 없으므로 초기화 */
					tmp = "";
					continue;
				}
				
				/** 조건에서 걸러지지 않았다면 낱말이 확장될 수 있다는 뜻이므로,
				 * 해당 문자를 임시 문자열에 추가한다 */
				tmp += map[i][j];
			}
		}

		/** 행에 있는 낱말(== 2글자 이상으로 이루어진 문자열) 파싱 시작 */
		for (int i = 0; i < C; i++) {
			/** 각 열을 순차적으로 탐색 */
			for (int j = 0; j < R; j++) {
				/** #을 만난다면 */
				if (map[j][i] == '#') {
					/** 임시 문자열이 낱말인 경우에만 PriorityQueue에 추가한다 */
					if (tmp.length() > 1) {
						pq.add(tmp);
					}
					/** #을 만났으므로,
					 *  이전에 쌓아둔 문자열은 더이상 확장할 수 없으므로 초기화 */
					tmp = "";
					continue;
				/** #이 아닌 행의 마지막 요소라면 */
				} else if (j == R - 1) {
					/** 일단 임시 문자열에 추가하고 낱말이라면 PriorityQueue에 추가
					 * (풀기 직전까지 발견하지 못했던 부분) */
					tmp += map[j][i];
					if (tmp.length() > 1) {
						pq.add(tmp);
					}
					/** 행의 끝을 만났으므로,
					 * 이전에 쌓아둔 문자열을 더이상 확장할 수 없으므로 초기화 */
					tmp = "";
					continue;
				}

				/** 조건에서 걸러지지 않았다면 낱말이 확장될 수 있다는 뜻이므로,
				 * 해당 문자를 임시 문자열에 추가한다 */
				tmp += map[j][i];
			}
		}
		
		/** 기본적으로 PriorityQueue에 가장 먼저 쌓이는 요소가
		 *  사전적으로 가장 빠른 낱말이므로 첫 요소를 출력한다 */
		System.out.println(pq.poll());
	}
}
