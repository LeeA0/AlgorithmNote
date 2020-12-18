package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1662_압축_stack {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str = br.readLine().toCharArray();
		Stack<Character> stack = new Stack<>(); 
		Stack<Integer> len = new Stack<Integer>();
		int answer = 0;
		//1. ')'를 만나기 전까지 stack에 push
		for (int i = 0; i < str.length; i++) {
//			System.out.println("TEST PRINT : "+stack.toString());
			if(str[i]!=')') {
				stack.push(str[i]);
			}
			
			//2. ')'를 만났다면 
			else {
				// K=곱해지는 수, qlen = check가 true일 때, Q의 길이를 구함, Q = ')'가 가장 뒤일 때 최종적인 길이를 구할 때 사용함 
				char K;
				int qLen=0, Q=answer;
				boolean check = false;
				
				// 만약 ')'를 만난 상태일 때, 뒤에 숫자가 나온다면 check는 true이다.
				for (int j = i; j < str.length; j++) {
					if(str[j]>='0' && str[j]<='9') {
						check = true;
						break;
					}
				}
				
				// ')'를 만난상태에서 '('를 찾을 때까지 stack에서 pop
				while(stack.peek()!='(') {
					//해당 압축의 끝 ')'이 아니라면
					if(check) {
						if(stack.pop()=='L') qLen+=len.pop();
						else qLen++;
					}
					//해당 압축의 끝 ')' 이면
					else {
						if(stack.pop()=='L') Q+=len.pop();
						else Q++;
					}
				}
				stack.pop(); 	// '('를 제거한다.
				K = stack.pop();// K * Len의 K를 구한다. 
				
				//check가 true일 때, 뒤에 압축되어있는 문자열이 더 있으므로 결과를 len이라는 stack에 넣어주고 stack에는 이를 L이라 표기한다.
				if(check) {
					len.push(qLen*(K-'0'));
					stack.push('L');
				}
				
				//check가 false라면 해당 압축의 가장 뒷 부분이라는 것을 알 수 있다. 따라서 answer에 K*Q의 결과를 넣어준다.
				else {
					answer = Q*(K-'0');
				}
			}
		}
//		System.out.println("TEST PRINT : "+answer+"  "+stack.toString() +"  " + len.toString());
		while(!stack.isEmpty()) {
			if(stack.pop()=='L') answer+=len.pop();
			else answer++;
		}
		System.out.println(answer);
	}
}