package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

//프로그래머스_완주하지못한선수_레벨1
public class Programmers_완주하지못한선수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] participant = new String[N];
		String[] completion = new String[N - 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			participant[i] = st.nextToken();
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			completion[i] = st.nextToken();
		}// 입력

		System.out.println(solution(participant, completion));
	}

	static String solution(String[] participant, String[] completion) {
		String answer = "";
		
		// 동명이인인 사람을 체크하기위해 이름을 키값으로, 해당 이름을 가진 사람 수를 값으로 저장
		HashMap<String, Integer> names = new HashMap<>();
		
		// 참가자를 카운트해준다.
		for (int i = 0; i < participant.length; i++) {
			// *getOrDefault : 키가 있다면 값을 받아오고, 없다면 설정값을 받아온다.
			names.put(participant[i], names.getOrDefault(participant[i], 0) + 1);
		}
		// 완주한 사람을 빼준다.
		for (int i = 0; i < completion.length; i++) {
			names.put(completion[i], names.get(completion[i]) - 1);
		}

		
		Iterator<String> iter = names.keySet().iterator();
		while (iter.hasNext()) {
			String name = iter.next();
			// 값이 0이 아닌 이름을 출력해준다.
			if (names.get(name) != 0) {
				answer = name;
				break;
			}
		}

		return answer;
	}
}
