package day;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준_재귀함수가뭔가요?_17478_실버5
public class BOJ_17478_재귀함수가뭔가요 {
	// 문자열을 저장 할 StringBuilder 선언
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		// 문자열을 저장 할 StringBuilder 생성
		sb = new StringBuilder();
		// 맨 처음 문장 입력
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		// 재귀함수 호출
		recursion(N, "");
		
		System.out.print(sb);
	}

	// n: 재귀함수를 호출하는 횟수, temp : 앞에 붙일 문자열 
	private static void recursion(int n, String temp) {
		// 들여쓰기 문장 입력
		sb.append(temp);
		// 질문 입력
		sb.append("\"재귀함수가 뭔가요?\"\n");
		// n이 0일 때 재귀에 대한 답변 입력
		if (n == 0) {
			sb.append(temp);
			sb.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
		}
		// 아닐 때 다시 질문
		else {
			sb.append(temp);
			sb.append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
			sb.append(temp);
			sb.append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
			sb.append(temp);
			sb.append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
			recursion(n - 1, temp + "____");
		}
		// 마지막에 답변
		sb.append(temp);
		sb.append("라고 답변하였지.\n");
	}
}
