package com.boj.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main_BOJ_1706_크로스워드 {
	static int R, C;
	static char[][] puzzle;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		puzzle = new char[R][C]; 
		
		for (int i = 0; i < R; i++) {
			puzzle[i] = br.readLine().toCharArray();
		}//end input
		
		TreeSet<String> ts = new TreeSet<>();
		StringBuilder sb;
		
		for (int i = 0; i < R; i++) {
			sb = new StringBuilder(); //한줄이 끝나면 스트링빌더 초기화
			for (int j = 0; j < C; j++) {
				if(puzzle[i][j] != '#') { //금지된 글자가 아니면
					sb.append(puzzle[i][j]+"");  //스트링빌더에 문자 추가
				}else { //금지된 글자를 만나면
					if(sb.length()>1) { //2이상의 길이를 가진 단어이면
						ts.add(sb.toString()); //treeset에 넣음
					}
					sb = new StringBuilder(); 
				}
			}
			if(sb.length()>1){ //한줄이 끝났는데 입력된 글자가 2이상의 길이이면
				ts.add(sb.toString());
			}
		}
		
		//세로는 아래로 내려가면서 탐색
		for (int i = 0; i < C; i++) {
			sb = new StringBuilder();
			for (int j = 0; j < R; j++) {
				if(puzzle[j][i] != '#') { //금지된 글자가 아니면
					sb.append(puzzle[j][i]+"");
				}else { //금지된 글자를 만나면
					if(sb.length()>1) { //단어이면
						ts.add(sb.toString());
					}
					sb = new StringBuilder();
				}
			}
			
			if(sb.length()>1){
				ts.add(sb.toString());
			}
		}
		
		System.out.println(ts.pollFirst());
	}

}
