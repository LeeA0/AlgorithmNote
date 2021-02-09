package final_algo.programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Programmers_가장큰수 {

	class Solution {
	    public String solution(int[] numbers) {
	    	String findMax[] = new String[numbers.length];
	    	//숫자를 문자열로 변환
	    	for (int i = 0; i < numbers.length; i++) {
	    		findMax[i] = String.valueOf(numbers[i]);
			}
	    	
	    	Arrays.sort(findMax, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					//내림차순
					return (o2 + o1).compareTo(o1 + o2);
				}
	    	});
	    	//0으로만 이뤄져있으면 0 반환
	    	if(findMax[0].equals("0")) {
	    		return "0";
	    	}
	    	
	    	String answer = "";
	    	for (String string : findMax) {
				answer += string;
			}
	    	return answer;
	    }
	}

}
