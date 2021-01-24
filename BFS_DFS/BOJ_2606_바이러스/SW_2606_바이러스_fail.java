package final_algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스_fail {

	static boolean computers[];
	static int countCom, network;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		countCom = Integer.parseInt(br.readLine());
		network = Integer.parseInt(br.readLine());
		computers = new boolean[countCom + 1];

		int comOne = 0, comTwo = 0;
		boolean check = false;
		for (int i = 0; i < network; i++) {
			st = new StringTokenizer(br.readLine()," ");
			comOne = Integer.parseInt(st.nextToken());
			comTwo = Integer.parseInt(st.nextToken());
			ckeckComputer(comOne, comTwo, check);
		}
		
		int count = 0;
		for (int i = 2; i < computers.length; i++) {
			if (computers[i]) {
				count++;
			}
		}
		System.out.println(count);
	}

	public static void ckeckComputer(int comOne, int comTwo, boolean ckeck) {
		for (int i = 0; i < computers.length; i++) {
			if (comOne == 1) {
				ckeck = true;
				computers[1] = true;
				computers[comTwo] = true;
			}
			if (computers[comOne] || computers[comTwo]) {
				if (computers[comOne]) {
					computers[comTwo] = true;
				}
				else {
					computers[comOne] = true;
				}
			}
		}
	}
}
