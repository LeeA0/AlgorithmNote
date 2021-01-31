package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1120_문자열 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		char [] a = st.nextToken().toCharArray();
		char [] b = st.nextToken().toCharArray();
		System.out.print(minDiff(a, b));
	}
	//a와 b의 차이가 최소가 되는 지점을 찾는다.
	static int minDiff(char a[], char b[]) {
		int min = Integer.MAX_VALUE; //min값을 저장
		int aLen = a.length;		 //a의 길이
		int difLen = b.length - aLen;//b와 a의 길이 차이
		
		//길이 차이만큼 for문을 돌린다.
		for (int i = 0; i <= difLen; i++) {
			int diff = 0; //차이가 얼마나 나는가를 판단
			int k = 0;	  //a의 index
			//오른쪽으로 1칸씩 밀면서 탐색 진행
			for (int j = i; j < aLen+i; j++) {
				//a[k]의 문자가 b[j]의 문자와 다르다면 차이를 +1해준다.
				if(a[k++]!=b[j]) diff++;
			}
			//최소 값을 구함
			min = Math.min(min, diff);
			//만약 b에 a와 완전 동일한 문자열이 있을 경우 바로 return한다. 
			if(min==0) return 0;
		}
		//최소 값을 return
		return min;
	}
}