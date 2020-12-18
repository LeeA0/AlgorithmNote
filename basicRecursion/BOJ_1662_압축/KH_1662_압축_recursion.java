package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1662_압축_recursion {
	static int idx;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		idx=str.length-1;
		System.out.println(recursion(str));
	}

	private static int recursion(char [] str) {
		int len = 0;
		while(idx>=0) {
			//압축의 시작점이면
			if(str[idx]=='(') {
				return len;
			}
			//압축의 끝점이면
			else if(str[idx]==')') {
				idx--;
				len += recursion(str) * (str[--idx]-'0');
			}
			//숫자이면
			else
				len++;
			idx--;
		}
		return len;
	}
}