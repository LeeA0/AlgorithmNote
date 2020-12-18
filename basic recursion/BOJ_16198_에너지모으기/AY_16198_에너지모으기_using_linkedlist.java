package day;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

//백준_에너지모으기_16198_실버1
public class BOJ_16198_에너지모으기_using_linkedlist {
	static int N, answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		LinkedList<Integer> energyBall = new LinkedList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			energyBall.add(Integer.parseInt(st.nextToken()));
		}
		answer = 0;
		nPr(0, 0, energyBall);
		
		System.out.println(answer);
	}

	// cnt : 뽑은 에너지구슬개수
	// sum : 에너지 총합
	// energyBall : 남은 에너지구슬을 저장하는 배열
	private static void nPr(int cnt, int sum, LinkedList<Integer> energyBall) {
		if(cnt==N-2) {
			// sum이 answer보다 크면 answer에 저장
			answer = Math.max(answer, sum);
			return;
		}
		// 맨 처음과 맨 끝을 제외한 나머지 구슬 들 중에 한 개를 뽑음
		for (int i = 1; i < energyBall.size()-1; i++) {
			// 임시 저장 리스트 temp에 energyBall 복사
			LinkedList<Integer> temp = (LinkedList<Integer>) energyBall.clone();
			//LinkedList<Integer> temp = new LinkedList<Integer>();
			//temp.addAll(energyBall);
			
			// 구슬을 하나 뽑음
			temp.remove(i);
			// 뽑은 구슬을 지우면 한 칸씩 앞으로 오므로 sum에 (i-1번째 * i번째)를 더해줌
			// 구슬을 뽑은 상태인 구슬리스트를 보냄
			nPr(cnt+1, sum+(temp.get(i-1)*temp.get(i)),temp);
		}
	}
}
