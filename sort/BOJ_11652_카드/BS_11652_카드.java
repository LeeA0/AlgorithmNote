package baekjoon.two;

import java.util.PriorityQueue;
import java.util.Scanner;
/**
 * 
 * @author BUMSEOK SEO
 * 메모리를 10만KB 가까이 사용하였는데, 더 효율적인 방법은 어떻게 될까요?
 *
 */
public class BOJ_11652_카드 {
	public static void main(String[] args) {
		PriorityQueue<Long> que = new PriorityQueue<Long>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		// PriorityQueue에 값들을 입력해준다.
		for (int i = 0; i < N; i++) {
			que.offer(sc.nextLong());
		}
		
		// 현재 count하고 있는 숫자와, 몇개째 세고 있는지 기억하는 변수
		long nowNum = que.poll();
		int nowCnt = 1;
		
		// max값일때의 숫자와, 그 때 몇개를 가지고 있었는지 기억하는 변수
		long maxNum = nowNum;
		int maxCnt = 1;
		
		// que가 빌때 까지 탐색
		while(!que.isEmpty()) {
			// 혹시 다음 숫자가 현재 세고 있는 숫자와 같다면
			if(que.peek().equals(nowNum) ) {
				// nowCnt를 늘려준다
				nowCnt++;
			// 혹시 다른 숫자가 나왔다면
			} else {
				// 지금까지 count했던 변수가 최대 count보다 크다면
				if(nowCnt > maxCnt) {
					// 최대 값과 그 때의 count값을 기억한다
					maxCnt = nowCnt;
					maxNum = nowNum;
				}
				// 다른 수를 만났으니 초기화
				nowCnt = 1;
			}
			// 다음의 요소와 비교하기 위해서 현재의 요소를 기억해둔다.
			nowNum = que.poll();
		}
		
		// 이 부분이 없어서 실패했었다.
		// 마지막 요소가 최대일 때 최댓값 판단이 되지 않았기 때문에 마지막에 판단문을 한번 더 추가해주었다.
		if(nowCnt > maxCnt) {
			maxCnt = nowCnt;
			maxNum = nowNum;
		}
		System.out.println(maxNum);
	}
}
