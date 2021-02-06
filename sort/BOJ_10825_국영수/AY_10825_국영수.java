package day;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 백준_국영수_10825_실버4
public class AY_10825_국영수 {
	// 학생 객체 선언
	static class Student implements Comparable<Student> {
		// 이름
		String name;
		// 국어점수
		int korean;
		// 영어점수
		int english;
		// 수학점수
		int math;

		// 생성자
		public Student(String name, int korean, int english, int math) {
			this.name = name;
			this.korean = korean;
			this.english = english;
			this.math = math;
		}

		// 비교 메소드
		@Override
		public int compareTo(Student o) {
			// 국어 점수가 다르면
			if (this.korean != o.korean) {
				// 감소하는 순
				return Integer.compare(-1 * this.korean, -1 * o.korean);
			} 
			// 영어 점수가 다르면
			else if (this.english != o.english) {
				// 증가하는 순
				return Integer.compare(this.english, o.english);
			} 
			// 수학 점수가 다르면
			else if (this.math != o.math) {
				// 감소하는 순
				return Integer.compare(-1 * this.math, -1 * o.math);
			}
			// 점수가 전부 같으면 이름 사전순
			else {
				return this.name.compareTo(o.name);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Student> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String n = st.nextToken();
			int k = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			// PriorityQueue에 들어갈때마다 compareTo에 맞게 정렬
			pq.add(new Student(n, k, e, m));
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(pq.poll().name).append("\n");
		}
		System.out.print(sb);
	}
}
