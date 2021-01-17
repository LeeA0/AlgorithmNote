import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BOJ_2504_괄호의값 {
	/*
	 * 20.01.16 2504 괄호의 값
	 *  1) () : 2 
	 *  2) [] : 3 
	 *  3) (X) : 2*X값 
	 *  4) [X] : 3*X값 
	 *  5) XY : X+Y
	 * 
	 * 스택을 이용 괄호 문자열 길이 1~30 올바르지 못한 입력 -> 0 출력
	 * 
	 * 틀린 원인) Stack에 들어가는 자료형을 Character로 하면 오버플로우 발생....ㅎ
	 * 30글자가 최대기 때문에, 최댓값은 3^15 까지 올 수 있는데, 
	 * stack<char> 형에 숫자를 넣어버리면 오버플로가 되서 제대로 된 답이 나오지 않습니다.
	 * char 형은 1바이트입니다.
	 */
	static Stack<String> s;
	static String input;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		

		boolean isCorrect = check(); //정상적인 괄호인지 먼저 확인
		if(isCorrect) { //정상적인 괄호이면 계산
			calc();
			
			int ans = 0;
			while(!s.isEmpty()) { //스택에 남아있는 것들을 모두 더해서 결과 도출
				ans+=Integer.parseInt(s.pop());
			}
			
			System.out.println(ans);
		}else { //정상적인 괄호가 아니면 0출력
			System.out.println(0);
		}
	}

	private static void calc() {
		//괄호 안을 계산
		for (int i = 0; i < input.length(); i++) {
			int sum = 0;
			switch (Character.toString(input.charAt(i))) { 
			//character to string --> Character.toString() 사용
			case "(":
				s.add("(");
				break;
			case "[":
				s.add("[");
				break;
			case ")":
				while(s.peek()!="(") { //열린 괄호가 나올때까지 내부 숫자가 있으면 더해줌
					sum += Integer.parseInt(s.pop());
				}
				
				//열린괄호 pop
				s.pop();
				
				if(sum == 0) { //괄호 사이에 숫자가 없었으면 1
					sum = 1;
				}
				
				sum*=2; //더한 값에 *2를 전체적으로 해줌, 또는 더한값이 없이 바로 괄호가 나왔으면 2를 넣어줌
				
				s.add(sum+"");
				break;
				
			case "]":
				while(s.peek()!="[") {
					sum += Integer.parseInt(s.pop());
				}
				s.pop();
				
				if(sum == 0) {
					sum = 1;
				}
				
				sum*=3;
				
				s.add(sum+"");
				break;

			default:
				break;
			}
		}
	}

	private static boolean check() {
		// 괄호의 짝이 맞는지 검사
		s = new Stack<>();

		for (int i = 0; i < input.length(); i++) {
			switch (Character.toString(input.charAt(i))) {
			case "(":
				s.add("(");
				break;
			case "[":
				s.add("[");
				break;
			case ")":
				if(s.isEmpty()) return false; //런타임에러 원인) 빈 스택이라면 짝이 맞지 않으므로 false
				if (s.pop() != "(") { //뽑은게 (가 아니라면 false
					return false;
				}

				break;
			case "]":
				if(s.isEmpty()) return false;
				if (s.pop() != "[") {
					return false;
				}
				break;

			default:
				break;
			}
		}
		
		if(!s.isEmpty()) { //짝맞춰서 다 뽑았는데 아직 남아있는게 있다면 짝이 맞지 않으므로 false
			return false;
		}
		return true;
		
	}

}
