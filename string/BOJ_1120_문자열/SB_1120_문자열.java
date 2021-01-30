package com.boj.sliver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1120_문자열 {

	public static void main(String[] args) throws Exception {
		BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(sb.readLine(), " ");
		String A = st.nextToken();
		String B = st.nextToken();
		
		char[] aArray = A.toCharArray(); //A 단어 배열 
		char[] bArray = B.toCharArray(); //B 단어 배열
		
		int repeat = B.length() - A.length() + 1; //비교 반복 횟수
		int min = 50; //최소값 초기화
		
		for (int i = 0; i < repeat; i++) { //비교 반복 횟수만큼 돌면서
			int diff = 0; //다른 개수 초기화
			for (int j = 0; j < aArray.length; j++) { //A단어의 길이만큼 돌면서
				if(aArray[j] != bArray[i+j]) { //다르면
					diff++; //다른 개수 증가
				}
			}
			min = Math.min(diff, min); //최소값 갱신
		}
		
		System.out.println(min);
		
		
	}

}
