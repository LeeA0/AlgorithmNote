package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_10814_나이순정렬 {
	// Comparable Interface를 상속받아서 compareTo 메서드를 overriding 한다.
	static class Person implements Comparable<Person>{
		int age;
		String name;
		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}
		@Override
		public int compareTo(Person p) {
			// 값이 다를때, 양수값을 반환하면 비교하는 두 객체의 자리가 도치된다.
			if(this.age != p.age) {
				return this.age - p.age;
			}
//			문제와는 상관없지만, 나이가 같을 때 이름 "오름차순으로" 정렬하고자 하면 다음과 같이 기술한다.
//			내림차순이라면  p.name.compareTo(this.name)
//			else if(this.age == p.age) {
//				return this.name.compareTo(p.name);
//			}
			return 0;
		};
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int  N  = Integer.parseInt(br.readLine());
		List<Person> personList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			personList.add(new Person(Integer.parseInt(st.nextToken()), st.nextToken()));
		}
		// 혹시 정렬하고자 하는 묶음이 배열이라면 Arrays.sort를 사용한다.
		Collections.sort(personList);
		for (int i = 0; i < personList.size(); ++i) {
			System.out.println(personList.get(i).age + " " + personList.get(i).name);
		}
	}
}
