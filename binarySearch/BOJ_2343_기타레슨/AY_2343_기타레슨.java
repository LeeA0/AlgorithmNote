package day;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준_기타레슨_2343_실버1
public class AY_2343_기타레슨 {
	static int[] lesson;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		lesson = new int[N];
		st = new StringTokenizer(br.readLine());

		int left = 0;
		int right = 0;
		for (int i = 0; i < N; i++) {
			lesson[i] = Integer.parseInt(st.nextToken());
			// 모든 원소 중에 최대 레슨길이를 최소 블루레이 크기로 둔다
			left = Math.max(left, lesson[i]);
			// 모든 원소의 함을 최대 블루레이 크기로 둔다
			right += lesson[i];
		} // 입력 완료
		
		// 조건에 맞는 최소 블루레이 크기를 저장할 변수
		int size = right;
		
		// 알맞는 최소 블루레이 크기를 찾기 위해 이분탐색을 진행한다.
		while(left<=right) {
			// 가운데 값을 계산한다.
			int mid = (left+right)/2;
			// mid를 블루레이 사이즈로 몇개의 블루레이가 나오는 지 계산
			int m = calc(mid);
			// m이 M보다 크면 블루레이 크기를 늘려야한다
			// 즉, mid보다 큰 값을 찾아야한다
 			if(m>M) {
				left = mid+1;
			}
 			// m이 M보다 작거나 같으면 블루레이 크기를 줄여서 찾아본다
 			// 즉, mid보다 작은 값을 찾아본다
 			else {
 				// 현재 블루에이 크기과 mid 중에 작은 값을 저장
				size = Math.min(size, mid);
				// 더 작은 값이 size가 될 수 있으므로
				// mid보다 작은 값을 찾아본다
				right = mid-1;
			}
		}
		
		System.out.println(size);
	}
	
	// 블루레이 크기에 맞게 나오는 블루레이의 개수
	static int calc(int size) {
		int m = 1; // 블루레이 개수를 카운트
		
		// 레슨시간의 합을 임시로 저장
		int sum = 0;
		// 전체 레슨시간을 돌려가며 블루레이 개수를 카운트한다
		for (int i = 0; i < lesson.length; i++) {
			// 현재 레슨시간을 더해줌
			sum+=lesson[i];
			// 이때까지의 레슨시간의 합이 블루레이 크기를 넘어서면
			if(sum>size) {
				// 블루레이개수를 하나 추가하고
				m++;
				// 추가한 블루레이에 현재 레슨시간을 넣어준다
				sum=lesson[i];
			}
		}
		// 최종 계산된 블루레이 개수를 리턴한다
		return m;
	}
}
