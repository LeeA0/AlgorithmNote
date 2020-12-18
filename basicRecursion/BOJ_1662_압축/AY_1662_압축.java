package day;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준_압축_1662_골드5
public class BOJ_1662_압축 {
	static char[] temp;
	static int index;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		temp = br.readLine().trim().toCharArray();
		// 뒤에서부터 읽기위한 인덱스 설정
		index = temp.length - 1;
		System.out.print(zip());
	}

	private static int zip() {
		int cnt = 0;
		// 모든 문자열을 읽을 때까지 반복
		while (index >= 0) {
			// 닫는 괄호면
			if (temp[index] == ')') {
				// 인덱스를 -1 해주고
				index--;
				// zip() : 한단계 안으로 들어간다
				// temp[--index]-'0' : 앞의 숫자를 읽기 위해 index를 -1해주고, 읽어온 것의 자료형이 char이므로 '0'을 빼줌
				cnt += zip() * (temp[--index]-'0');
			} 
			// 여는 괄호면 cnt를 리턴해준다
			else if (temp[index] == '(') {
				return cnt;
			} 
			// 다른 숫자면 개수를 +1 해준다
			else {
				cnt++;
			}
			// 모든 연산을 끝냈으면 다음 문자를 읽기 위해 index-1을 해준다.
			index--;
		}
		// 다 읽었으면 cnt를 리턴
		return cnt;
	}
}
