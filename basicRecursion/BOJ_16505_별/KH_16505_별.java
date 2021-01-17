package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_16505_별 {
	static boolean star[][];
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		N = (int)Math.pow(2, N);
		star = new boolean[N][N];
		//**
		//* 이 형태를 유지하도록 한다.
		isStar(0,0,N);
		printStar(N);
	}
	static void isStar(int r, int c, int len) {
		//basis step
		if(len==1) {
			star[r][c] = true;
			return;
		}
		//inductive step
		int nLen = len/2; //2^N 행렬의 크기에서 2를 나눈다. 
		isStar(r+nLen, c, nLen);//  * 1,1의 위치
		isStar(r, c+nLen, nLen);//   *0,1의 위치
		isStar(r, c, nLen); //		* 0,0의 위치
	}
	static void printStar(int N) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-i; j++) {//조건 중 해당 행의 끝 부분 뒤에는 공백이 없어야한다는 조건
				if(star[i][j]) sb.append('*');
				else sb.append(' ');
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
}