package final_algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_10825_국영수 {

	static int N;
	static String score[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		score = new String[N][4];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 4; j++) {
				score[i][j] = st.nextToken();
			}
		}

		solution(score);

		for (int i = 0; i < N; i++) {
			sb.append(score[i][0]).append("\n");
		}
		System.out.println(sb.toString());
	}

	/**
	 * o1[0] :: 이름
	 * o1[1] :: 국어
	 * o1[2] :: 영어
	 * o1[3] :: 수학
	 * @param score
	 */
	static void solution(String[][] score) {
		Arrays.sort(score, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				if (Integer.parseInt(o1[1]) == Integer.parseInt(o2[1])) {
					if (Integer.parseInt(o1[2]) == Integer.parseInt(o2[2])) {
						if (Integer.parseInt(o1[3]) == Integer.parseInt(o2[3])) {
							//오름차순
							return o1[0].compareTo(o2[0]);
						}
						//내림차순
						return Integer.compare(Integer.parseInt(o2[3]),Integer.parseInt(o1[3]));
					}
					//오름차순
					return Integer.compare(Integer.parseInt(o1[2]),Integer.parseInt(o2[2]));
				}
				//내림차순
				return Integer.compare(Integer.parseInt(o2[1]),Integer.parseInt(o1[1]));
			}
		});
	}
}
