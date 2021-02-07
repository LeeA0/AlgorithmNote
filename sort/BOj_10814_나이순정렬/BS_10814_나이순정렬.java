package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_10814_���̼����� {
	// Comparable Interface�� overriding�ؼ� ����Ѵ�
	static class Person implements Comparable<Person>{
		int age;
		String name;
		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}
		@Override
		public int compareTo(Person p) {
			// ���� �ٸ���, ������� ��ȯ�ϸ� ���ϴ� �� ��ü�� �ڸ��� ��ġ�ȴ�.
			if(this.age != p.age) {
				return this.age - p.age;
			}
//			�����ʹ� ���������, ���̰� ���� �� �̸� "������������" �����ϰ��� �ϸ� ������ ���� ����Ѵ�.
//			���������̶��  p.name.compareTo(this.name)
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
		// Ȥ�� �����ϰ��� �ϴ� ������ �迭�̶�� Arrays.sort�� ����Ѵ�.
		Collections.sort(personList);
		for (int i = 0; i < personList.size(); ++i) {
			System.out.println(personList.get(i).age + " " + personList.get(i).name);
		}
	}
}
