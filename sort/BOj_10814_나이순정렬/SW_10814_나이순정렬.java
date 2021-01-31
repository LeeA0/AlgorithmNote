package final_algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
/*Silver 5*/
public class BOJ_10814_나이순정렬 {

	static int N;
	static String age[][];
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		/*input*/
		N = Integer.parseInt(br.readLine());
		age = new String[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < 2; j++) {
				age[i][j] = st.nextToken();
			}
		}
		/*input end*/
		
		/*comparator*/
		Arrays.sort(age, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				
				return Integer.compare(Integer.parseInt(o1[0]),Integer.parseInt(o2[0]));
			}
			
		});
		
		/*print*/
		for (int i = 0; i < age.length; i++) {
			sb.append(age[i][0]).append(" ").append(age[i][1]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
