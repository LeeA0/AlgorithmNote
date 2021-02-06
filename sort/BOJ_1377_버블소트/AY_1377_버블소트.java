package day;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 백준_버블소트_1377_골드3
public class AY_1377_버블소트 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 정렬해야 할 숫자 개수
		int N = Integer.parseInt(br.readLine());
		// 버블 정렬 특징
		// : 가장 큰 수를 맨끝으로 먼저 배치한다.
		// -> 그 과정에서 나머지 숫자들은 뒤로 밀린다.
		// 정렬횟수는 제일 뒤로 많이 밀린 횟수와 같다.
		// 따라서 정렬 전 원 위치와 정렬 후 위치를 빼준다!
		// 일반 sort는 퀵소트여서 최악의 경우(정렬후와 완전 정반대인 경우) n^2의 시간복잡도가 나와서 시간초과가 난다.
		// 따라서 PriorityQueue를 사용한다.
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			// 값이 같은 경우
			if (o1[1] == o2[1]) {
				// 기존 index가 작은게 앞으로 온다
				return o1[0]-o2[0];
			}
			// 값이 다른 경우 값이 작은게 앞으로 온다
			return o1[1] - o2[1];
		});

		for (int i = 0; i < N; i++) {
			// 현재 인덱스와 값을 입력
			pq.add(new int[] { i, Integer.parseInt(br.readLine())});
		}

		// 최대 이동횟수
		int max = 0;
		// 전체 숫자의 이동 회수를 비교해서 가장 큰 값을 저장
		for (int i = 0; i < N; i++) {
			max = Math.max(max, pq.poll()[0] - i);
		}
		System.out.println(max + 1);
	}
}