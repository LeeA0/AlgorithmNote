package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_16198_에너지모으기 {
	static int N, MAX;
	static ArrayList<Integer> nList = new ArrayList<>();
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nList.add(Integer.parseInt(st.nextToken()));
		}
		recursive(0, nList, 0);
		System.out.println(MAX);
		
	}
	private static void recursive(int cnt, ArrayList<Integer> list, int sum) {
		//Basis part 
		//가장 앞과 가장 뒤의 값이 남으면 return
		if(cnt==N-2) {
			MAX = Math.max(sum, MAX);
			return ;
		}
		//inductive part
		for (int i = 1; i < list.size()-1; i++) { 						  //받아온 리스트의 사이즈에서 -1을 해준다.(가장 뒤의 값을 빼기위해)
			ArrayList<Integer> tlist = (ArrayList<Integer>) list.clone(); //list를 복사한다.
			tlist.remove(i); 											  //선택된 index의 값을 지우고 다음 x를 고른다. 
			recursive(cnt+1, tlist, sum+list.get(i-1) * list.get(i+1));
		}
	}
}