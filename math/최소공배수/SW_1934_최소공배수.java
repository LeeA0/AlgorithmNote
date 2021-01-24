package final_algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*Silver 5*/
public class BOJ_1934_최소공배수 {

	static int T, numone, numtwo;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine()," ");
			numone = Integer.parseInt(st.nextToken());
			numtwo = Integer.parseInt(st.nextToken());
			
			System.out.println(numone*numtwo/getGcd(numone,numtwo));
		}
	}
	static int getGcd(int x, int y) {
		// x%y일때, y값이 x값보다 더 작아야 하므로 위치 조정.
		if (y>x) {
			int tmp = x;
			x=y;
			y=tmp;
		}
		// 나누어 떨어질때까지 계속해서 나누어 가며 진행.
		// 나누어 떨어진다면 이전의 x%y값을 반환.
		while(x%y!=0) {
			int tmp = x%y;
			x=y;
			y=tmp;
		}
		return y;
	}
}
