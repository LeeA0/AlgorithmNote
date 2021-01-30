package day;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

//백준_크로스워드_1706_실버3
public class AY_1706_크로스워드 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] crossword = new char[R][C];
		for (int i = 0; i < R; i++) {
			crossword[i] = br.readLine().toCharArray();
		} // 입력완료

		// add해줬을 때 사전식으로 정렬해주기위해 treeset으로 선언
		TreeSet<String> list = new TreeSet<String>();
		// 단어를 임시로 저장하는 곳
		StringBuilder sb = new StringBuilder();
		
		// 행으로 탐색하며 단어를 발견
		for (int i = 0; i < R; i++) {
			// Stringbuilder초기화
			sb.delete(0, sb.length());
			for (int j = 0; j < C; j++) {
				// #으로 인해 단어가 끝난 경우
				if (crossword[i][j] == '#') {
					// Stringbuilder에 저장된 단어의 길이가 2이상이면 단어리스트에 추가
					if (sb.length() > 1) {
						list.add(sb.toString());
					}
					// Stringbuilder초기화
					sb.delete(0, sb.length());
				} else {
					// Stringbuilder에 문자를 임시 저장하여 단어로 만듬
					sb.append(crossword[i][j]);
				}
			}
			// Stringbuilder에 저장된 단어의 길이가 2이상이면 단어리스트에 추가
			if (sb.length() > 1) {
				list.add(sb.toString());
			}
		}
		
		// 열로 탐색하며 단어를 발견
		for (int i = 0; i < C; i++) {
			// Stringbuilder초기화
			sb.delete(0, sb.length());
			for (int j = 0; j < R; j++) {
				// #으로 인해 단어가 끝난 경우
				if (crossword[j][i] == '#') {
					// Stringbuilder에 저장된 단어의 길이가 2이상이면 단어리스트에 추가
					if (sb.length() > 1) {
						list.add(sb.toString());
					}
					// Stringbuilder초기화
					sb.delete(0, sb.length());
				} else {
					// Stringbuilder에 문자를 임시 저장하여 단어로 만듬
					sb.append(crossword[j][i]);
				}
			}
			// Stringbuilder에 저장된 단어의 길이가 2이상이면 단어리스트에 추가
			if (sb.length() > 1) {
				list.add(sb.toString());
			}
		}
		// 사전순으로 제일 앞선 것을 출력
		System.out.println(list.first());
	}
}
