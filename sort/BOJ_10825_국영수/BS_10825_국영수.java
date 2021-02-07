package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_10825_국영수 {
	// Comparable Interface를 상속받아서 compareTo 메서드를 overriding 한다.
	static class Score implements Comparable<Score>{
		int k;
		int y;
		int s;
		String name;
		public Score(String name, int k, int y, int s) {
			this.k = k;
			this.y = y;
			this.s = s;
			this.name = name;
		}
		
		@Override
		public int compareTo(Score score) {
			// 국어 점수가 다르다면
			if(this.k != score.k) {
				// 국어 점수 내림차순 정렬
				return score.k - this.k;
			// 영어 점수가 다르다면
			}else if(this.y != score.y) {
				// 영어 점수 오름차순 정렬
				return this.y - score.y;
			// 수학 점수가 다르다면
			}else if(this.s != score.s) {
				// 수학 점수 내림차순 정렬
				return score.s - this.s;
			// 모든 점수가 같다면
			}else {
				// 이름 사전순 오름차순 정렬
				return this.name.compareTo(score.name);
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Score> scoreList = new ArrayList<>();
		// 각 학생의 이름과 국영수 점수를 입력 받는다
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int k = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			scoreList.add(new Score(name, k, y, s));
		}
		// scoreList를 정렬 (Comparable을 implement한 객체들이므로 정해진 룰에 의해서 정렬된다.
		Collections.sort(scoreList);
		// 출력이 많으므로 StringBuilder를 사용해 보았다.
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < scoreList.size(); i++) {
			sb.append(scoreList.get(i).name+"\n");
		}
		System.out.println(sb.toString());
	}
}