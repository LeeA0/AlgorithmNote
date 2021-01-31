package final_algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*Silver 3*/
public class BOJ_1706_크로스워드 {
	
	static int R,C;
	static char map[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		/*input*/
		for (int i = 0; i < R; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = input[j];
			}
		}
		//TreeSet을 이용하여 정렬
		TreeSet<String> tree = new TreeSet<>();
		StringBuilder sb = null;
		
		for (int i = 0; i < R; i++) {
			sb = new StringBuilder();
			for (int j = 0; j < C; j++) {
				//금지된 칸이 아닐경우
				if(map[i][j] !='#') {
					//Stringbuilder에 추가
					sb.append(map[i][j]+"");
				}else {
					//금지된 칸을 만났을때.
					if(sb.length()>1) {
						//문자열의 길이가 2이상일 경우
						tree.add(sb.toString());
					}else {
						//아닐경우 초기화
						sb = new StringBuilder();
					}
				}
			}
			//가로가 끝났을때 해당 저장되있는 문자열 점검
			if(sb.length()>1) {
				tree.add(sb.toString());
			}
		}
		
		//반대 경우 확인.
		for (int i = 0; i < C; i++) {
			sb = new StringBuilder();
			for (int j = 0; j < R; j++) {
				if(map[j][i] !='#') {
					sb.append(map[j][i]+"");
				}else {
					if(sb.length()>1) {
						tree.add(sb.toString());
					}else {
						sb = new StringBuilder();
					}
				}
			}
			if(sb.length()>1) {
				tree.add(sb.toString());
			}
		}
		
		//사전식 순으로 가장 앞서있는 낱말 출력
		System.out.println(tree.pollFirst());
	}
}
