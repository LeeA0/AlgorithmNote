package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_4779_칸토어집합 {
	static int N;
	static char str[];
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		String input;
		while((input = br.readLine()) != null) { //입력의 끝을 모를 떄(파일의 EOF)
			N = Integer.parseInt(input);
			sb = new StringBuilder();
			int length = (int)Math.pow(3.0, N);
			
			str = new char[length]; //칸토어 집합 길이 만큼 만든다.
			
			for (int i = 0; i < length; i++) { //str초기화
				str[i] = '-';
			}
			CantorSet(length, 0, length);
			for (int i = 0; i < length; i++) {
				sb.append(str[i]);
			}
			sb.append('\n');
			System.out.print(sb);
		}
	}
	private static void CantorSet(int length, int start, int end) {
		
		if(length==1) return;
		int len = length/3;
		for (int i = start+len; i < end-len; i++) str[i] = ' '; //세 구역 중 중앙 집합을 공백 처리
		CantorSet(len, start, start+len); //왼쪽 집합
		CantorSet(len, end-len, end); 	  //오른쪽 집합
	}
}