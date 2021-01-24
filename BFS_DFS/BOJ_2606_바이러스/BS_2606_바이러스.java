package baekjoon.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author BUMSEOK SEO
 * @problem 2606(silver) 바이러스
 *
 */
public class BOJ_2606_바이러스 {
	static int n;
	static int pair;
	static boolean[][] pairMap;
	static boolean[] virus;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		n = Integer.parseInt(br.readLine());
		pair = Integer.parseInt(br.readLine());
		pairMap = new boolean[n+1][n+1];
		virus = new boolean[n+1];
		
		for (int i = 0; i < pair; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			pairMap[from][to] = true;
			pairMap[to][from] = true;
		}
		
		dfs(1);
		
		int result = 0;
		for (int i = 2; i <= n; i++) {
			if(virus[i]) result++;
		}
		System.out.println(result);
	}

	private static void dfs(int from) {
		for (int i = 1; i <= n; i++) {
			if(virus[i]) continue;
			if(pairMap[from][i]) {
				virus[i] = true;
				dfs(i);
			}
		}
	}
}
