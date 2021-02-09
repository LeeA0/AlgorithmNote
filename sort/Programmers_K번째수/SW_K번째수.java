package final_algo.programmers;

import java.util.Arrays;

public class Programmers_K번째수 {

	class Solution {
		public int[] solution(int[] array, int[][] commands) {
			int[] answer = new int [commands.length];
			for (int i = 0; i < commands.length; i++) {
				int start = commands[i][0] - 1;
				int end = commands[i][1] - 1;
				int select = commands[i][2] - 1;
				
				int tmp[] = new int[end - start + 1];
				for (int j = 0; j < tmp.length; j++) {
					//j증가값 + start index value
					tmp[j] = array[j+start];
				}
				//start에서 end까지 자른 후 정렬.
				Arrays.sort(tmp);
				answer[i] = tmp[select];
			}
			return answer;
		}
	}
}
