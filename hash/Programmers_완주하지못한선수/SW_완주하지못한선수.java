package final_algo.programmers;

import java.util.HashMap;

public class Programmers_완주하지못한선수 {

	class Solution {
		public String solution(String[] participant, String[] completion) {
			HashMap<String, Integer> map = new HashMap<>();
			String answer = "";
			/*전체 선수 리스트*/
			//key값에 해당하는 value값이 null일경우 value 값을 default값을 0으로 두고 +1을 한 상태에서 put 
			for(String list : participant) 
				map.put(list, map.getOrDefault(list, 0 )+1 );
			/*결승선 도착 선수 리스트*/
			//key값에 해당하는 value값을 -1처리하여 0으로 처리한다.
			for(String finish : completion) 
				map.put(finish, map.get(finish) - 1 );
			
			//0이 아닌 사람은 도착하지 않은 +1상태이므로 answer값이 된다.
			for (String ans : map.keySet()) {
				if(map.get(ans)!=0) answer = ans;
			}
			return answer;
		}
	}

}
