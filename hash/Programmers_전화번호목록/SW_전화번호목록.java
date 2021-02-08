package final_algo.programmers;

public class Programmers_전화번호목록 {

	class Solution {
		public boolean solution(String[] phone_book) {
			/**
			 * String str1 = "hello world"; 
			 * String str2 = "hello"; 
			 * String str3 = "ello";
			 * 
			 * System.out.println(str1.startsWith(str2)); // true
			 * System.out.println(str1.startsWith(str3)); // false
			 * System.out.println(str1.startsWith(str3, 1)); // true
			 */

			boolean answer = true;
			for (int i = 0; i < phone_book.length; i++) {
				for (int j = 0; j < phone_book.length; j++) {
					//기준점과 나머지 값들을 비교.
					if (i != j && phone_book[i].startsWith(phone_book[j])) {
						answer = false;
						break;
					}
					//바꿔서 다시 한번 접두어인지 비교.
					if (i != j && phone_book[j].startsWith(phone_book[i])) {
						answer = false;
						break;
					}
				}
			}
			return answer;
		}
	}
}
