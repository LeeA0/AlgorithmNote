package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_1706_크로스워드 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		//크로스 워드를 저장할 케릭터형 2차원 배열
		char[][] crossword = new char[R][];
		
		//crossword를 입력 받는다.
		for (int i = 0; i < R; i++) {
			crossword[i] = br.readLine().toCharArray(); 
		}
		//크로스워드에 입력된 단어들을 찾고 이를 사전순으로 정렬한다.
		findLexOrder(crossword, R, C);
	}
	static void findLexOrder(char [][] cw, int r, int c) {
		//rsb는 행에 있는 크로스 워드를 저장한다.
		//csb는 열에 있는 크로스 워드를 저장한다.
		StringBuilder rsb,csb;
		
		//사전순 정렬을 하기위해 사용하는 treeSet
		TreeSet<String> ts = new TreeSet<>();
		
		//행 우선 탐색
		for (int i = 0; i < r; i++) {
			csb = new StringBuilder();
			for (int j = 0; j < c; j++) {
				
				//단어의 끝 '#'이아니라면 스트링 빌더에 해당 문자를 추가
				if(cw[i][j] !='#') {
					csb.append(cw[i][j]);
				}
				//단어의 끝 '#' 또는 해당 행의 끝일 때
				if(cw[i][j]=='#' || j+1 == c) {
					//만약 스트링 빌더의 크기가 1보다 크면 단어 이므로 트리셋에 추가
					if(csb.length()>1) {
						ts.add(csb.toString());
					}
					csb = new StringBuilder();
				}
			}
		}
		//열 우선 탐색
		//로직은 행 우선과 동일함
		for (int i = 0; i < c; i++) {
			rsb = new StringBuilder();
			for (int j = 0; j < r; j++) {
				if(cw[j][i] !='#') {
					rsb.append(cw[j][i]);
				}
				if(cw[j][i]=='#' || j+1 == r) {
					if(rsb.length()>1) {
						ts.add(rsb.toString());
					}
					rsb = new StringBuilder();
				}
			}
		}
		//트리셋에 가장 앞에 있는 단어 출력
		System.out.print(ts.first());
	}
}