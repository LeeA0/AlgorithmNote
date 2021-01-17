package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074_Z {
	static int N, R, C, answer=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		divNCon(0,0,1<<N); // 1<<(N) == 2^N		
	}
	
	private static void divNCon(int nr, int nc, int s) {
		//basis step
		if(s==1) {
			if(nr==R && nc==C) {
				System.out.println(answer);
			}
			return ;
		}
		
		//inductive step
		int w = s/2; //2로 크기를 나눈다.
		
		if(nr<=R && nc<=C && nr+w>R && nc+w>C) { //왼쪽 위에 위치할 경우
			divNCon(nr,nc,w);		// O X
									// X X
		}
		else if(nr<=R && nc+w<=C && nr+w>R && nc+s>C) { //오른쪽 위에 위치할 경우
			//1번은 모두 지나왔다고 본다.
			answer += w*w;			// X O
			divNCon(nr,nc+w,w);		// X X
		}
		else if(nr+w<=R && nc<=C && nr+s>R && nc+w>C) { //왼쪽 아래에 위치할 경우
			//1번,2번은 모두 지나왔다고 본다.
			answer += w*w*2;		// X X
			divNCon(nr+w,nc,w);		// O X
		}
		else if(nr+w<=R && nc+w<=C && nr+s>R && nc+s>C) { //오른쪽 아래에 위치할 경우
			//1번,2번,3번은 모두 지나왔다고 본다.
			answer += w*w*3;		// X X
			divNCon(nr+w,nc+w,w);	// X O
		}
	}
}
