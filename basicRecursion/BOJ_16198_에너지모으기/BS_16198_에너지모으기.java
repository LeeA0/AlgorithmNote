package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author BUMSEOK SEO
 * @since 2020-12-19
 * @title 16198 에너지 모으기
 *
 */

/*
 * 5 100 2 1 3 100
 * 
 * 10400
 */

public class BOJ_16198_에너지모으기 {
	static int N, max;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 구슬을 담을 어레이리스트 생성
		list = new ArrayList<Integer>();
		N = Integer.parseInt(br.readLine());
		max = Integer.MIN_VALUE;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		// 초기값 : 구슬이 N개, 모인 에너지 0
		getEnergy(N, 0);

		System.out.println(max);
	}
	/*
	 * 현재로써 어느 구슬을 뽑아야 가장 많은 에너지를 얻을 수 있을지 바로 알 수 없으므로,
	 * 모든 뽑는 경우의 수를 다 탐색해야한다.
	 */
	private static void getEnergy(int remain, int sum) {
		// 남은 구슬이 2개라면 현재까지 모인 에너지가 최댓값인지 비교
		if (remain == 2) {
			max = sum > max ? sum : max;
			return;
		}

		/*
		 *  2번째 구슬부터 (남은 구슬 갯수 - 1)번째 구슬 까지 뽑는다
		 *  - 첫 번째와 마지막 구슬은 뽑지 않는다는 조건이 문제에 제시되어 있다.
		 *  - 해당 구슬의 왼쪽과 오른쪽 구슬이 존재해야 에너지 계산이 가능하다는 이유도 들 수 있다.
		 */
		for (int i = 1; i < remain - 1; i++) {
			// 뽑을 i번째 구슬을 임시로 저장해 놓고
			int tmp = list.get(i);

			// i번째 구슬을 뽑기전, 그 주변의 구슬의 에너지의 곱 또한 임시로 저장
			int tmpSum = (list.get(i - 1) * list.get(i + 1));
			// i번째 구슬을 뽑고
			list.remove(i);
			/*
			 * 그 상태에서 다음 구슬 뽑기에 넘어간다 남은 구슬 갯수는 (현재 개수 - 1)이며, 축적된 에너지에서 임시로 저장해둔 좌우구슬 에너지 곱을
			 * 더한 값을 다음 재귀로 넘긴다
			 */
			getEnergy(remain - 1, sum + tmpSum);

			// 뽑았던 i번째 구슬을 원상복귀 시킨다.
			list.add(i, tmp);
		}
	}
}
