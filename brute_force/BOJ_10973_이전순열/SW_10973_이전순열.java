package final_algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*Silver 3*/
public class BOJ_10973_이전순열 {

	static int arr[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		arr = new int [N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if(provious_number(arr,N)) {
			for (int i = 0; i < N; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.setLength(sb.length()-1);
		}
		else {
			sb.append("-1");
		}
		System.out.println(sb.toString());

	}
	static boolean provious_number(int[] arr,int N) {
		int a = N - 1;
		while(a > 0 && arr[a-1] <= arr[a]) a--;
		if(a <= 0) return false;
		
		int b = N - 1;
		while(arr[a-1] <= arr[b]) b--;
		
		swap(a-1, b);
		
		int c = N - 1;
		while(a < c) swap(a++,c--);
		return true;
	}
	static void swap(int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
