package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_11652_카드 {
	static int max = 0;
	static long answer;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		//Long의 범위는 2^63까지
		//따라서 2^62은 표현 가능
		Map<Long, Integer> card = new HashMap<>();
		for (int i = 0; i < N; i++) {
			long num = Long.parseLong(br.readLine());
			//이미 포함된 키값인가?
			if(card.containsKey(num)) {
				//포함이라면 value+1
				card.put(num, card.get(num)+1);
			}else {
				//아니라면 k,v를 새로 넣음
				card.put(num, 1);
			}
		}
		//map의 크기만큼 loop를 돌림
		card.forEach((k,v)->{
			//더 많이 들어 있다면 k(answer)과 v(max)값 교체
			if(max<v) {
				answer = k;
				max = v;
			}
			//개수가 동일하다면 더 작은 k를 answer에 넣음 
			else if(max==v) answer = Long.compare(k, answer) > 0 ? answer : k;
		});
		System.out.print(answer);
	}	
}