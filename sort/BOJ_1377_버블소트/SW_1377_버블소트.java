package final_algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*Gold 3*/
public class BOJ_1377_버블소트 {

	static class A implements Comparable<A> {
		/* i : index
		 * v : value
		 */
		int i;
		int v;

		/*Generate Constructor using Fields*/
		public A(int i, int v) {
			super();
			this.i = i;
			this.v = v;
		}

		@Override
		public int compareTo(A o) {
			//value 값이 같을 경우 index값을 기준으로 정렬
			if(this.v - o.v == 0) return this.i - o.i;
			//value 값을 기준으로 정렬
			return this.v - o.v;
		}

	}

	static int N, max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		N = Integer.parseInt(br.readLine());
		PriorityQueue<A> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			//PriorityQueue를 이용하여 자동정렬
			pq.add(new A(i, Integer.parseInt(br.readLine())));
		}

		/*index의 가장 큰 차이를 max를 이용하여 구한다.*/
		int count = 0;
		while(!pq.isEmpty()) {
			A a = pq.poll();
			//원래 index와 정렬한 현재 index의 차이를 구한다. 
			if(max < a.i - count) max = a.i - count;
			count++;
		}
		//arr 0 부터 진행해서 index +1을 진행해준다. 
		sb.append(max+1);
		System.out.println(sb.toString());
	}
}
