package day;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 백준_괄호의값_2504_실버2
public class BOJ_2504_괄호의값 {
	// 괄호열을 저장하는 배열
	static char[] bracket;
	// 여는 괄호를 저장하는 스택
	static Stack<Character> stack;
	// 괄호열을 순환하는 인덱스
	static int idx;
	// 올바른 괄호열인지 아닌지 체크
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 괄호열 저장
		bracket = br.readLine().trim().toCharArray();
		// 스택 생성
		stack = new Stack<>();
		// 인덱스 초기화
		idx = 0;
		// 처음에는 올바른 괄호열이라고 설정하고 시작
		flag = true;

		// 계산 값을 출력
		System.out.print(calculate());
	}

	public static int calculate() {
		// 계산 값을 저장하는 변수
		int sum = 0;
		// 올바른 괄호열이고, 아직 다 탐색하지 않았으면 반복
		while (flag && idx < bracket.length) {
			// 현재 인덱스가 가리키고있는 괄호가 다음과 같을 때
			switch (bracket[idx++]) {
			case '(':
				// 스택에 해당 괄호 저장
				stack.push('(');
				// ()은 2이므로 계산한 값에 2를 곱해준다.
				sum += calculate() * 2;
				break;
			case '[':
				// 스택에 해당 괄호 저장
				stack.push('[');
				// []은 3이므로 계산한 값에 3을 곱해준다.
				sum += calculate() * 3;
				break;
			case ')':
				// 스택이 비어있거나 괄호열이 올바르지 않으면
				if (stack.isEmpty() || stack.pop() != '(') {
					// flag를 false로 바꿔준뒤 return
					flag = false;
					return 0;
				}
				// sum이 0이면 ()이라는 뜻이므로 1을 리턴 아니면 계산 값 sum을 리턴
				return sum == 0 ? 1 : sum;
			case ']':
				// 스택이 비어있거나 괄호열이 올바르지 않으면
				if (stack.isEmpty() || stack.pop() != '[') {
					flag = false;
					// flag를 false로 바꿔준뒤 return
					return 0;
				}
				// sum이 0이면 ()이라는 뜻이므로 1을 리턴 아니면 계산 값 sum을 리턴
				return sum == 0 ? 1 : sum;
			}
		}
		// 스택이 비어있거나 올바르지않은 괄호열이면 0을 리턴
		if (!stack.isEmpty() || !flag) {
			return 0;
		}
		// 올바른 괄호열이면 계산한 값을 리턴
		return sum;
	}
}
