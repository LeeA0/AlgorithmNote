package day;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준_나이순정렬_10814_실버5
public class AY_10814_나이순정렬 {
	// 회원객체 생성
	static class Member implements Comparable<Member>{
		// 나이
		int age;
		// 이름
		String name;
		
		// 생성자
		public Member(int age, String name) {
			super();
			this.age = age;
			this.name = name;
		}
		
		// 비교 메소드
		@Override
		public int compareTo(Member o) {
			// 나이가 같으면 들어온 순서대로
			if(this.age==o.age) {
				return 0;
			}
			// 나이가 다르면 어린 순서대로
			return Integer.compare(this.age,o.age);
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Member[] list = new Member[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list[i] = new Member(Integer.parseInt(st.nextToken()),st.nextToken());
		} // 입력완료
		
		// 규칙대로 정렬, 객체의 compareTo를 기준으로 정렬
		Arrays.sort(list);
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for(Member m : list) {
			sb.append(m.age).append(" ").append(m.name).append("\n");
		}
		System.out.print(sb);
	}
}
