package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1049_기타줄 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int minPackage = Integer.MAX_VALUE;
		int minSingle = Integer.MAX_VALUE;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int tmpPackage = Integer.parseInt(st.nextToken());
			int tmpSingle = Integer.parseInt(st.nextToken());
			if(tmpPackage < minPackage) {
				minPackage = tmpPackage;
			}
			if(tmpSingle < minSingle) {
				minSingle = tmpSingle;
			}
		}
//		System.out.println(minPackage + " " + minSingle);
		if(minPackage > minSingle * 6) {
			System.out.println(minSingle * N);
		}else{
//			System.out.println(N/6 + "곱하기 패키지 " + (N%6) + " 곱하기 낱개");
//			System.out.println((N/6 * minPackage) + );
			int tmp = (N/6*minPackage);
			if((N%6) * minSingle < minPackage) {
				System.out.println(tmp + (N%6) * minSingle);
			}else if(N%6 != 0) {
				System.out.println(tmp + minPackage);
			}else {
				System.out.println(tmp);
			}
		}
	}
}
