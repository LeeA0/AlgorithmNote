package final_algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/*Silver 4*/
/*31324KB	380ms*/
public class BOJ_11652_카드_hashmap {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<Long,Integer> map = new HashMap<>();
		long arr[] = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i]=Long.parseLong(br.readLine()); 
		}
		long max = 0;
		long ans = Integer.MAX_VALUE;
		//arr 안에서 같은 key 값들을 value를 +1 해준다.
		for (Long num : arr) map.put(num, map.getOrDefault(num, 0) + 1);
		//최대 max 값을 가져온다. max는 count된 value의 최대값이다.
		for (Long num : map.keySet()) max = Math.max(max, map.get(num));
		//그 중 같은 max값을 가진 key들중에서 가장 작은 값을 ans에 넣는다.
		for (Long num : map.keySet()) if(max == map.get(num)) ans = Math.min(ans,num);
		System.out.println(ans);
	}
}
