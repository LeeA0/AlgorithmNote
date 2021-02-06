package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BOJ_10825_국영수 {
	static class Student implements Comparable<Student>{
		String name;
		int kor;
		int eng;
		int math;
		public Student(String name, int kor, int eng, int math) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
		
		@Override
		public int compareTo(Student o) {
			// 국어 점수가 감소하는 순
			if(this.kor > o.kor) {return -1;}
			else if(this.kor == o.kor) {
				
				// 국어 점수가 같으면 영어 점수가 증가하는 순
				if(this.eng < o.eng) {return -1;}
				else if(this.eng == o.eng) {
					
					// 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순
					if(this.math > o.math) {
						return -1;
					}
					else if(this.math == o.math) {
						// 모든 점수가 같으면 이름 사전 순
						return this.name.compareTo(o.name);
					}
					else {return 1;}
				}
				else {return 1;}
			}
			else {return 1;}
		}
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Student> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			pq.add(new Student(
					st.nextToken(), 
					Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken())));
		}
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) sb.append(pq.poll().name).append('\n');
		System.out.print(sb);
	}
}