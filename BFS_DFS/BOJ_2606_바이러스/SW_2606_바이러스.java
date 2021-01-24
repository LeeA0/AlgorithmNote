package final_algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스 {

	static int countCom, network, computers[], comOne, comTwo;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		countCom = Integer.parseInt(br.readLine());
		network = Integer.parseInt(br.readLine());
		computers = new int[countCom + 1];

		// make set
		for (int i = 1; i < countCom + 1; i++) {
			computers[i] = i;
		}

		// 입력
		for (int i = 0; i < network; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			comOne = Integer.parseInt(st.nextToken());
			comTwo = Integer.parseInt(st.nextToken());
			union(comOne, comTwo);
		}

		int cnt = 0;
		for (int i = 0; i < computers.length; i++) {
			if (find(i) == find(1)) cnt++;
		}
		System.out.println(cnt - 1);
	}

	// union
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x != y)
			computers[x] = y;
	}

	// find
	public static int find(int x) {
		if (x == computers[x]) return x;
		return computers[x] = find(computers[x]);
	}
}
