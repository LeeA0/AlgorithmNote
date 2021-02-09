package final_algo.programmers;

import java.util.Arrays;

public class Programmers_HIndex_v1 {

	class Solution {
		public int solution(int[] citations) {
			int answer = 0;
			int max = 0;
			if (citations.length == 1) {
				answer = citations[0];
			}
			Arrays.sort(citations);
			for (int i = 0; i < citations.length; i++) {
				int countDown = 0;
				int countUp = 0;
				
				for (int j = citations[i]; j < citations[citations.length-1]; j++) {
					countUp++;
				}
				for (int j = citations[0]; j < citations[i]; j++) {
					countDown++;
				}
				
				if(countUp == countDown && max<citations[i]) {
					max = citations[i];
					answer = max;
				}
			}

			return answer;
		}
	}

}
