package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_10814_나이순정렬PQ {
	static class Member implements Comparable<Member> {
		int age;
		int idx;
		String name;
		public Member(int age, int idx, String name) {
			this.age = age;
			this.idx = idx;
			this.name = name;
		}
		@Override
		public int compareTo(Member o) {
			//나이 순으로 정렬한다. this.age가 작으면 -1(앞으로)
			if(this.age < o.age) return -1;
			//같으면 index 비교
			else if(this.age == o.age) return Integer.compare(this.idx, o.idx);
			//this.age가 더 크면 1(뒤로)
			else return 1;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		//우선순위 큐를 이용하자
		//poll시 자동으로 age가 작은 순으로 나온다.(같다면 가입 순)
		PriorityQueue<Member> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.offer(new Member(Integer.parseInt(st.nextToken()), i, st.nextToken()));
		}
		Member tmp;
		//bufferedWriter랑 비교해봤는데 비슷해서 stringBuilder 사용
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			tmp = pq.poll();
			sb.append(tmp.age).append(" ").append(tmp.name).append("\n");
		}
		//sb에 넣어두고 한번에 출력
		System.out.print(sb);
	}
}