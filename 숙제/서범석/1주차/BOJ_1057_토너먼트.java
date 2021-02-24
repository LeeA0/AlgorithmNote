package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 토너먼트에서 같은 라운드에 만나는 사람끼리는
 * 2의 제곱만큼 mod한 값이 같을 때 만난다는 것을 알게 되었다.
 * 
 * 주의할 점
 * 1. 아무리 적어도 1번 경기는 하고 만나야하므로 만날때까지 cnt하는 경기수는 1부터 시작한다.
 * 2. mod한 값이 같아야 한다는 접근 방식을 용이하게 하기 위해서 부여받는 번호는 0~N-1까지로 한다.
 */

public class BOJ_1057_토너먼트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Jimin = Integer.parseInt(st.nextToken()) - 1 ;
		int Hansu = Integer.parseInt(st.nextToken()) - 1;
		
//		if(N/2 == 0) {
//			
//		}else {
//			
//		}
		int modNum = 2;
		int playCnt = 1;
		while(N > modNum) {
//			System.out.println(Jimin + " " + Hansu);
			if((Jimin/modNum) == (Hansu/modNum)) {
//				System.out.println("hello");
				break;
			}else {
				playCnt++;
				modNum *= 2;
			}
		}
		System.out.println(playCnt);
	}
}
