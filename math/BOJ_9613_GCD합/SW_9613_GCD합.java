package final_algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*Silver 3*/
public class BOJ_9613_GCD합 {

	static int T, n, nums[]; 
	static long result;
	static boolean check[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			/* 초기화 */
			result = 0;
			n = 0;
			/* input start */
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			nums = new int[n];
			check = new boolean[n];
			for (int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			/* input end */

			checkNums();
			System.out.println(result);
		}
	}

	/* 비교를 한 num값인지 확인하기, 했을경우 true 안했을 경우 false */
	static void checkNums() {
		for (int i = 0; i < n; i++) {
			if (!check[i]) {
				check[i] = true;
				sumGcdByNums(i);
			}
		}
	}

	/* 비교 안한 쌍끼리 최대 공약수 구하기 */
	static void sumGcdByNums(int index) {
		int tmp = 0;
		for (int i = index + 1; i < n; i++) {
			tmp = getGCD(nums[index], nums[i]);
			result += tmp;
		}
	}

	/* 최대 공약수 구하기 */
	static int getGCD(int x, int y) {
		if (y > x) {
			int tmp = x;
			x = y;
			y = tmp;
		}
		while (x % y != 0) {
			int tmp = x % y;
			x = y;
			y = tmp;
		}
		return y;
	}
}
