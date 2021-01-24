package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스 {
	static int [] parent;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int V, E, ans=0;
		//정점을 입력받는다.
		V = Integer.parseInt(br.readLine());
		//간선을 입력받는다.
		E = Integer.parseInt(br.readLine());
		

		parent = new int[V+1];
		//정점의 부모의 정보를 저장한다.
		makeSet(V);
		
		//간선을 입력받는다. A->B 형태이다.
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		// 1번이 변경 되어있을 수도 있으므로 find(1)==find(i)로 바이러스에 감염된 정점들을 찾는다.
		for (int i = 2; i <= V; i++) {
			if(find(i)==find(1)) ans++;
		}
		// 정답 출력
		System.out.print(ans);
	}
	static void makeSet(int v) {
		for (int i = 1; i <= v; i++) {
			parent[i] = i;
		}
	}
	static void union(int a, int b) {
		//a 정점의 부모를 찾는다.
		a = find(a);
		//b 정점의 부모를 찾는다.
		b = find(b);
		//만약에 부모가 서로 같다면 return
		if(a==b) return;
		//부모가 다르다면 A->B일 경우 A가 B의 부모가 되기로 결정했으므로 b의 부모를 a로 결정한다. 
		parent[b] = a;
	}
	static int find(int c) {
		//c의 최고 부모를 찾는다.
		if(parent[c]==c) return c;
		//부모를 찾아 올라갈 때마다 갱신하고 return
		return parent[c] = find(parent[c]);
	}
}
