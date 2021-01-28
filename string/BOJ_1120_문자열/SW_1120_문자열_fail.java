package final_algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*Silver 4*/
public class BOJ_1120_문자열 {
	static int count;
	static char X[], Y[], tmpX[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		X = st.nextToken().toCharArray();
		Y = st.nextToken().toCharArray();

		int Xlength = X.length;
		int Ylength = Y.length;

		int tmp = 0;
		if (Xlength < Ylength) {
			tmp = Ylength - Xlength;
			tmpX = new char[Xlength + tmp];
			// A의 앞에 아무 알파벳이나 추가한다.
			for (int j = 0; j < tmp; j++) {
				tmpX[j] = Y[j];
			}
			for (int j = 0; j < Xlength; j++) {
				tmpX[j + tmp] = X[j];
			}
			solution(tmpX, Y);
			int frontXCount = count;

			// A의 뒤에 아무 알파벳이나 추가한다.
			tmpX = new char[Xlength + tmp];
			for (int j = 0; j < Xlength; j++) {
				tmpX[j] = X[j];
			}
			for (int k = Xlength; k < Ylength; k++) {
				tmpX[k] = Y[k];
			}
			solution(tmpX, Y);
			int backXCount = count;

			comparison(frontXCount, backXCount);

		} else {
			solution(X, Y);
			System.out.println(count);
		}
	}

	static void comparison(int frontXCount, int backXCount) {
		if (frontXCount < backXCount) {
			System.out.println(frontXCount);
		} else {
			System.out.println(backXCount);
		}
	}

	static int solution(char[] X, char[] Y) {
		count = 0;
		for (int i = 0; i < Y.length; i++) {
			if (X[i] != Y[i]) {
				count++;
			}
		}
		return count;
	}

	static void print(char[] X) {
		for (int i = 0; i < X.length; i++) {
			System.out.print(X[i] + " ");
		}
		System.out.println();
	}
}
