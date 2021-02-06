package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

//10 1 5 2 3 : 1 10 5 2 3 => 1 5 10 2 3 => 1 5 2 10 3 => 1 5 2 3 10 : i=1
//				true			
//1 5 2 3 10 : 1 5 2 3 10 => 1 2 5 3 10 => 1 2 3 5 10 => 1 2 3 5 10 : i=2
//								true
//1 2 3 5 10 : 1 2 3 5 10 => 1 2 3 5 10 => 1 2 3 5 10 => 1 2 3 5 10 : i=3

//5 3 1 2 : 3 5 1 2 => 3 1 5 2 => 3 1 2 5 : i=1
//			  true
//3 1 2 5 : 1 3 2 5 => 1 2 3 5 => 1 2 3 5 : i=2
//			  true
//1 2 3 5 : 1 2 3 5 => 1 2 3 5 => 1 2 3 5 : i=3
//
public class BOJ_1377_버블소트 {
	static class Data implements Comparable<Data>{
		int num, idx;
		public Data(int idx, int num) {
			this.idx = idx;
			this.num = num;
		}
		@Override
		public int compareTo(Data o) {
			//현재 num이 더 작으면 앞으로
			if(this.num < o.num) return -1;
			//같다면 idx로 비교
			else if(this.num==o.num) {
				//idx가 더 작으면 앞으로(pq에서 stable하게 만들어 줌)
				if(this.idx < o.idx) {return -1;}
				else {return 1;}
			}
			else return 1;
		}
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		//정렬은 PQ로 이용하자 0.2초정도 빠르다(입력 데이터가 많아지면 차이 더 많이남)
		PriorityQueue<Data> a = new PriorityQueue<>();
		
		for (int i = 0; i < n; i++) {
			a.offer(new Data(i, Integer.parseInt(br.readLine())));
		}
	    int Max = 0;
	    int tmp = 0;
	    for (int i = 0; i < n; i++) {
	    	tmp = a.poll().idx - i;
	    	//버블 소트는 1사이클당 앞으로 1번씩 이동함
	    	//정렬되지 않은 수들 중 가장 큰 수가 버블버블~하면서 뒤로 끝까지 이동함(자기보다 큰 수 만나면 그 앞이 자기 위치)
	    	//이를 이용해서 최초 idx와 정렬된 idx를 비교해보면 버블소트의 끝 사이클을 알 수 있음
			if(tmp > 0) {
				Max = Math.max(Max, tmp);
			}
		}
	    //주어진 코드에서 i를 1부터 시작하기도 했고 false가 되는 부분이 +1인 부분이라 
	    //+1을 해줌
	    System.out.println(Max+1);
	}
}