package final_algo.programmers;

public class Programmers_네트워크 {

	class Solution {
		public int solution(int n, int[][] computers) {
			int answer = 0;
			boolean flag[] = new boolean[n];
			
			for (int i = 0; i < n; i++) {
				if(!flag[i]) {
					dfs(i,computers,flag);
					answer++;
				}
			}
			return answer;
		}

		/**
		 * 재귀를 이용한 연결된 네트워크 찾기
		 * @param start 기존의 index
		 * @param computers 
		 * @param flag 0~n까지의 visited flag
		 * @return
		 */
		public boolean[] dfs(int start, int[][] computers, boolean[] flag) {
			//재 방문 하지 않도록 true 처리
			flag[start] = true;
			for (int index = 0; index < computers.length; index++) {
				/* start!=index :: 자기 자신을 가리키는 네트워크는 count하지 않는다.
				 * !flag[index] :: 방문하지 않은 index 방문
				 * computers[start][index] == 1 :: 1인 경우 네트워크 연결이므로 방문
				 *  flag = dfs(index, computers, flag) :: 방문한 index를 기준으로 index를 start index로 재 정의.
				 * */
				if(start!=index && !flag[index] && computers[start][index] == 1) flag = dfs(index, computers, flag); 
			}
			return flag;
		}
	}
}
