package day;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준_별_16505_실버5
public class BOJ_16505_별_re {
	// 별찍을 곳을 체크해주는 배열
	static boolean[][] starMap;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 수열 숫자
		int N = Integer.parseInt(br.readLine().trim());
		// 입력완료
		
		// 별을 찍는 범위가 2^N
		int size = (int)Math.pow(2, N);
		starMap = new boolean[size][size];
		
		// 수열 숫자 N부터 1씩 감소
		// 처음 시작 위치 (0,0)
		drawStar(N,0,0);
		
		// starMap이 true면 *, false면 ' '을 append해주기위해 선언
		StringBuilder sb = new StringBuilder();
		
		// 별을 찍는 행의 개수는 size개
		for (int i = 0; i < size; i++) {
			// *각 줄 끝에는 필요없는 공백을 출력하지 않는다. => 형태에 맞게 필요한 공백만을 출력해줘야한다는 뜻
			// 별을 찍는 열의 개수는 전체 사이즈에서 각 행의 번째 수를 빼서 역삼각형 형태로 출력
			for (int j = 0; j < size-i; j++) {
				// starMap이 true면 *, false면 ' '을 append
				if(starMap[i][j])sb.append("*");
				else sb.append(" ");
			}
			// 줄바꿈
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	// n: 범위 매개변수 (ex> n=3면 범위는 2^3=8이다.)
	// x: 시작지점 x좌표
	// y: 시작지점 y좌표
	public static void drawStar(int n,int x, int y) {
		// n==0이면 가로세로 범위가 1이므로 별을 찍는 부분을 체크해준다
		if(n==0) {
 			starMap[x][y] = true;
			return;
		}
		// 사각형을 4등분해서 1,1번째 사각형은 출력하지 않기위해
		// 4등분한 사각형의 범위에 맞게 n-1을 해준다
		n--;
		// 4등분한 사각형의 범위를 계산
		int size = (int)Math.pow(2, n);
		// 4등분한 사각형 -> 가로,세로 각 2등분
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				// 1,1번째 사각형은 출력하지않는다.
				if(i==1&&j==1)continue;
				// n은 그대로 넘긴다
				// x,y좌표는 각 4등분된 사각형의 맨왼쪽상단 지점
				drawStar(n,x+size*i,y+size*j);
			}
		}
	}
}
