package day;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준_칸토어집합_4779_실버4
public class BOJ_4779_칸토어집합 {
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp;
		// temp에 다음 줄을 저장하여 이 값이 null 값이 아닐 때 반복
		// 끝에 trim을 쓰면 안된다.
		while ((temp = br.readLine()) != null) {
			// temp를 int형으로 바꾼다.
			int N = Integer.parseInt(temp);
			sb = new StringBuilder();
			// 선그리기 시작
			drawingLine(N, true);
			System.out.println(sb);
		}
	}

	// n : 재귀 회수 (점점 0으로 감)
	// check : 선을 그리는 곳인지 아닌지 체크
	private static void drawingLine(int n, boolean check) {
		// n이 0일 때
		if (n == 0) {
			// check가 true면 선
			if (check) {
				sb.append('-');
			}
			// check가 false면 공백
			else {
				sb.append(' ');
			}
			return;
		}
		// 3단위로 이루어 지므로 3단위로 반복
		for (int i = 0; i < 3; i++) {
			// i가 1일 떄는 선을 안그림
			if (i == 1) {
				// 무조건 가운데는 선을 그리면 안되므로
				// true가 오든 false가 오든 false가 되도록
				drawingLine(n - 1, check & false);
			}
			// i가 0또는 2일 때는 선을 그림
			else {
				// 앞에서 선을 그리지 않는 곳이라 하고 선을 그리면 안되므로
				// true가 왔을 때만 true이도록
				drawingLine(n - 1, check & true);
			}
		}
	}
}
