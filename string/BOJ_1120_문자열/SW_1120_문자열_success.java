package final_algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1120_문자열_2 {
	
	static char X[], Y[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		X = st.nextToken().toCharArray();
		Y = st.nextToken().toCharArray();

		int ans = X.length;

		int tmp = Y.length - X.length;
		for (int i = 0; i <= tmp; i++) {
			int count = 0;
			for (int j = 0; j < X.length; j++) {
				if (X[j] != Y[i + j]) {
					count++;
				}
			}
			ans = Math.min(count, ans);
		}
		System.out.println(ans);
	}
}
