package day;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

// 백준_카드_11652_실버4
public class AY_11652_카드 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		// 숫자별 카드개수를 빠르게 세기위해 선언
		HashMap<Long, Integer> list = new HashMap<>();

		for (int i = 0; i < N; i++) {
			long key = Long.parseLong(br.readLine());
			// list에 이미 해당key의 값이 있다면 그 값에 +1을, 없다면 1을 넣음
			list.put(key, list.getOrDefault(key, 0) + 1);
		}
		
		// 키값을 순서대로 정렬하기 위해 keyset을 ArrayList에 저장
		ArrayList<Long> keySetList = new ArrayList<>(list.keySet());
		
		// 키값을 정렬
		Collections.sort(keySetList, new Comparator<Long>() {
			public int compare(Long o1, Long o2) {
				// 키 값의 value값이 같으면 키 값이 작은 것을 우선순위에 둔다.
				// *list.get()==list.get()는 두 객체의 주소값이 같은지를 보는 것이기 때문에 intValue()를 꼭 붙여야한다!!
				if(list.get(o1).intValue()==list.get(o2).intValue()) {
					return Long.compare(o1, o2);
				}
				// 다르다면 value값이 큰 값을 우선순위에 둔다.
				else {
					return Integer.compare(-list.get(o1).intValue(), -list.get(o2).intValue());
				}
			}
		});

		// 가장 첫 번째를 출력
		System.out.println(keySetList.get(0));
	}
}
