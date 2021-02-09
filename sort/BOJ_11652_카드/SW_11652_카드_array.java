package final_algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*Silver 4*/
/*24600KB	268ms*/
public class BOJ_11652_카드_array {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long arr[] = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i]=Long.parseLong(br.readLine()); 
		}
		Arrays.sort(arr);
		//최소 카운트 값, 최소 최대 카운트 값은 1이므로 1로 초기화
		int cnt = 1,max = 1;
		//카드가 한장일경우 고려 ans를 첫번째 arr값으로 초기화
		long ans = arr[0];
		for (int i = 1; i < N; i++) {
			//같은 카드인지 확인
			if(arr[i] == arr[i-1])cnt+=1;
			//1장일 경우
			else cnt = 1;
			//최대값에 따라 ans값 조정
			if(max < cnt) {
				max = cnt;
				ans = arr[i];
			}
		}
		System.out.println(ans);
	}
}
