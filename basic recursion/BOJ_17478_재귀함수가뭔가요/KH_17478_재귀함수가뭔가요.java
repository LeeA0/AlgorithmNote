package SILVER;

import java.util.Scanner;

public class BOJ_17478_재귀함수가뭔가요 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		
		System.out.print("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		
		recursion(N, 0, "", sb);//입력받은 n, n까지 재귀할 변수, ____용 string 변수, 정답용 sb

		System.out.print(sb);
	}
	private static void recursion(int n, int cnt, String k, StringBuilder sb) {

		//=========================================================================================
		//basis part == 기저 파트 == 종료 조건
		if(cnt==n) {
			sb.append(k).append("\"재귀함수가 뭔가요?\"\n");
			sb.append(k).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			sb.append(k).append("라고 답변하였지.\n");
			return;
		}
		//=========================================================================================
		
		//induction part == 유도 파트 == 재귀마다 실행되는 코드
		sb.append(k).append("\"재귀함수가 뭔가요?\"\n").
		append(k).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n").
		append(k).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n").
		append(k).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
		//=========================================================================================
		
		recursion(n,cnt+1, k+"____", sb);
		sb.append(k).append("라고 답변하였지.\n");
	}
}
