package SILVER;

import java.util.Scanner;

public class BOJ_10994_별찍기19 {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		//1 -> 5 -> 9 -> 13... -> n = n = 4*(n-1)+1	(i=0 부터, n=1 부터)
		StringBuilder sb = new StringBuilder();
		N = 4*(N-1)+1;
		recursion(0,N,sb);
		System.out.print(sb);
	}
	
	private static void recursion(int k, int n, StringBuilder sb) {
		if(k==N/2+1) { //basis condition 
			return;
		}
		int ktmp = k/2; //"* "과 " *"를 찍기위해 필요한 변수 //점점 작아질수록 좌우 대칭으로 "* "형태가 증가하며 찍힘 
		if(k%2==0) { //0, 2, 4, 6... 2n번째 행이면 
			print(true, ktmp, n, sb);
			recursion(k+1, n, sb);
			if(k!=N/2) { //n=0일 때, 한번 무시하도록 if문을 걸어주고 대칭이 되도록 스트링 빌더에 append
				print(true, ktmp, n, sb);
			}
		}
		else {//1,3,5,7,... 2n+1번째 행이면
			print(false,ktmp+1, n-4, sb); //2n+1행일 때, "* "과 " *"는 1번씩 더 찍히고 중앙에 빈 칸은 n-4칸 찍힘 
			recursion(k+1, n-4, sb);
			print(false, ktmp+1, n-4, sb); //재귀를 탈출 했을 때, 상하 대칭으로 찍히게 하기 위해 한번 더 별을 찍음
		}
	}
	//1~4(n-1)+1까지 모든 행은 아래 for문들의 형태로 print할 수 있음
	private static void print(boolean check, int k, int n, StringBuilder sb) {
		for (int i = 0; i < k; i++) sb.append("* ");
		for (int i = 0; i < n; i++) sb.append(check ? '*' : ' ');
		for (int i = 0; i < k; i++) sb.append(" *");
		sb.append('\n');
	}
}