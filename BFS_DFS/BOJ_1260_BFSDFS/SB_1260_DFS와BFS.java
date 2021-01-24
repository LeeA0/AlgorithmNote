import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BOJ_1260_DFS��BFS {
	/*
	 * 21.01.23 1260 DFS�� BFS
	 * ���� Ž�� ���� dfs, bfs�� ����
	 */
	
	static int N, M, V; //N(��������), M(��������), V(Ž����������) 
	static boolean[][] connect; //������ķ� Ǯ��
	static boolean[] b; //�湮 ���� üũ
	static StringBuilder sbDFS, sbBFS; //DFS ����, BFS ���� ������ Stringbuilder
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		M = scann.nextInt();
		V = scann.nextInt();
		
		connect = new boolean[N+1][N+1]; //������ ��ȣ�� 1�������̹Ƿ� N+1 ũ���� ������� ũ��
		
		for(int i = 0; i<M; i++) {
			int r = scann.nextInt();
			int c = scann.nextInt();
			
			connect[r][c] = connect[c][r] = true; //(����� ����) ����Ǿ� ������ true, �ƴϸ� false
			
		} //end input
		
		sbDFS = new StringBuilder();
		sbBFS = new StringBuilder();
		
		b = new boolean[N+1];
		dfs(V);
		
		b = new boolean[N+1]; //�湮�迭 �ʱ�ȭ
		bfs(V);
		
		System.out.println(sbDFS.toString());
		System.out.println(sbBFS.toString());
	}

	private static void bfs(int vertex) {
		b[vertex] = true; //������ �湮ó��
		Queue<Integer> que = new LinkedList<>();
		que.add(vertex); //������ que�� ����
		
		while(!que.isEmpty()) {
			vertex = que.poll(); 
			sbBFS.append(vertex).append(" "); //�湮�� ���� ����� �߰�
			
			for (int i = 1; i < N+1; i++) {
				if(connect[vertex][i] && !b[i]) { //���� �Ǿ� �����鼭 ���� �湮��������
					b[i] = true; //���� �湮ó��
					que.add(i); //ť�� ����
				}
			}
		}
	}

	private static void dfs(int vertex) {
		b[vertex] = true; //�湮ó�� 
		sbDFS.append(vertex).append(" "); //������� �߰�
		
		for (int i = 1; i < N+1; i++) {
			if(connect[vertex][i] && !b[i]) { //����Ǿ������鼭 ���� �Ȱ�����
				dfs(i); //��͸� �̿��Ͽ� dfs 
			}
		}
	}

}
