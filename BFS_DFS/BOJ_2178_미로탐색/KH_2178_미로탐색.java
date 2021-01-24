package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * @author Kihyeon Yun
 * @date 2021. 1. 7.
 * BFS를 이용한 최단거리 문제
 */
public class BOJ_2178_미로탐색 {
	static int N, M, map[][];
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," "); //checkedException - IoException
		
		//N과 M을 입력 받는다.
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//맵에 N*M크기의 int형 2차원 배열의 시작 주소를 할당한다.(주소라고 하는게 맞는것인가?)
		map = new int [N][M];
		
		//맵 데이터를 입력받는다.
		for (int r = 0; r < N; r++) { //행의 크기
			//입력데이터가 구분자 없이 붙어있는 형태로 오기 때문에 한줄씩 char배열 형태로 가지고 온다.
			char charArr[] = br.readLine().toCharArray(); 
			for (int c = 0; c < M; c++) { //열의 크기
				//입력받은 char배열을 map에 int형으로 parsing해서 넣는다.
				//48을 빼주는 이유는 '0'의 ASCII코드가 48번이기 때문이다.
				map[r][c] = charArr[c]-48;
			}
		}
		//입력 끝
		
		//BFS를 통해 너비우선 탐색으로 최단 도착거리를 구한다.
		//필요한 parameter는 시작좌표와 끝좌표(N과, M이 끝지점을 알고 있다 배열은 0부터 시작하기로 했으므로 -1을 해준다)
		System.out.println(bfs(0,0,N-1,M-1));
		
		
	}
	static int bfs(int sr,int sc, int er, int ec) {
		//최단거리를 저장할 변수
		int shortestDistance = 0;
		
		//각 level에 해당하는 좌표를 저장할 que 자료구조 변수를 만든다. 
		//좌표를 저장해야하므로 int배열 또는 class로 객체를 만든다.(int [] 사용) 
		Queue<int []> nodes = new LinkedList<>(); //util 패키지에 정의되어 있음
		
		//최초 좌표는 sr,sc이며 해당 레벨은 0이다.
		//하지만 이렇게 했을 때, 시작 위치를 정답이 포함하지 않기에 1로 시작하도록 한다.
		nodes.offer(new int [] {sr,sc,1});
		
		//최초 좌표는 1(방문 가능한 좌표)임을 보장하기 떄문에 방문 즉시 2로 변경한다.
		map[0][0] = 2;
		
		//4방 탐색을 위해 해당 좌표로 방문할 수 있는 direction 배열을 만든다.
		int [][] dir= {{-1,0},{1,0},{0,-1},{0,1}};
		
		
		while(!nodes.isEmpty()) {
			//queue에 저장된 좌표중 가장 낮은(?)레벨의 좌표를 가지고온다.
			int [] cur = nodes.poll();
			
			//가장 짧은 거리를 최신화 시킨다.
			shortestDistance = cur[2];
			
			//4방으로 방문가능한 좌표들을 찾는다.
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dir[d][0];
				int nc = cur[1] + dir[d][1];
				
				//접근이 가능한 좌표인지 확인한다.
				//map범위안에 있어야한다.
				//map에서 진행 가능한 위치인지 확인한다. (1이면 가능 0이면 접근 불가)
				//map이 이미 방문한 위치인지 확인한다.
				if(nr<0 || nr>=N || nc<0 || nc>=M || map[nr][nc]==0 || map[nr][nc]==2) continue;
				
				//만약에 좌표가 목적지 좌표라면 shortestDistance에 +1을 통해 level을 최신화 시켜준다. 
				//loop를 탈출한다.
				if(nr==er && nc==ec) return shortestDistance+1;
				
				//해당 좌표가 접근 가능한 좌표라면 방문표시를 하고(map의 칸을 2로 변경) 
				//queue에 offer한다. 해당 level은 기존 level+1
				map[nr][nc] = 2;
				nodes.offer(new int [] {nr,nc,cur[2]+1});
//				print();
			}
		}
		return shortestDistance;
	}
//	static void print() {
//		System.out.println();
//		for (int r = 0; r < N; r++) {
//			for (int c = 0; c < M; c++) {
//				System.out.print(map[r][c]+" ");
//			}
//			System.out.println();
//		}
//	}
}