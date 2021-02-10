package final_algo.programmers;

public class Programmers_타겟넘버 {

	class Solution {
	    public int solution(int[] numbers, int target) {
	        int answer = 0;
	        //첫번째 numbers[0]가 더해질때, 빼질때 포함.
	        answer = dfs(numbers,target,numbers[0],1)+dfs(numbers, target, -numbers[0], 1);
	        return answer;
	    }

	    /**
	     * 재귀를 이용하여 값을 구함.
	     * @param numbers 입력 숫자 배열
	     * @param target 재귀를 통해 구하고자 하는 값
	     * @param sum 시작점 number[0] 또한 numbers[index++] 되어 더해짐
	     * @param index number[0]을 제외한 number[1]로 초기화
	     * @return
	     */
	    public int dfs(int[] numbers, int target, int sum, int index) {
	    	int count = 0;
			if(index == numbers.length) {
				//sum 값이 target값과 같다면 count+=1
				if(sum == target) return 1;
				//아니라면 count+=0
				else return 0;
			}
			count += dfs(numbers, target, sum+numbers[index], index+1);
			count += dfs(numbers, target, sum-numbers[index], index+1);
			return count;
		}
	}
}
