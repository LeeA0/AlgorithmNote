import java.util.Arrays;
import java.util.Scanner;

public class Main_BOJ_16505_별 {
	/*
	 * 20.01.16 16505 별 재귀를 이용한 별찍기 문제
	 * 0<=N<=10 
	 * 0->* 
	 * 1->** 
	 * 	  * 
	 * 2->**** 
	 * 	  * * 
	 * 	  ** 
	 * 	  *
	 * 
	 * 1번이 기본 틀 재귀(분할정복)으로 풀이
	 * !!) 각 줄 끝에는 필요없는 공백을 출력하지 않는다.
	 */

	static int num; // 입력 값
	static char[][] map; // 별을 넣을 판

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		num = scann.nextInt(); // 입력값 입력받음

		// 배열의 크기가 2^n
		int size = 1 << num;
		
		// 분할정복 재귀
		map = new char[size][size]; // 2^n의 규칙을 가지고 있으므로 최대값 2^10(1024)를 커버
		
		/*
		 *  자바에서 char 배열의 초기값은 '\0' 이므로 초기화를 하지 않아도 된다.
		 *  --> 아니었따!! (틀림의 원인)
		 *      얼핏 보면, 공백 문자 ' '와 널 문자 '\0'의 출력 결과가 같기 때문에
		 *      두 가지가 같은 것이라고 착각 하면 안된다.
		 *      널 문자의 아스키 코드는 0, 공백 문자의 아스키 코드는 32
		 */

		for (int i = 0; i < size; i++) {
			Arrays.fill(map[i], ' ');
		}
		
		dc(size, 0, 0); //재귀함수 호출
		
		//print
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			for (int j=0; j <size-i; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

	private static void dc(int size, int r, int c) { // 분할정복 재귀
		if (size == 1) { // 기저조건
			map[r][c] = '*';
			return;
		}

		int div = size / 2;
		dc(div, r, c);
		dc(div, r + div, c);
		dc(div, r, c + div);
	}
}
