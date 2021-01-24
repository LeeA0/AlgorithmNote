package final_algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 문제점 파악: 나중에 들어오는 노드 정보를 파악하지 못한다.
 * @author multicampus
 *
 */
public class BOJ_2606_바이러스_fail {

	static int countCom, network;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		countCom = Integer.parseInt(br.readLine());
		network = Integer.parseInt(br.readLine());
		boolean computers[] = new boolean[countCom + 1];

		int comOne = 0, comTwo = 0;
		for (int i = 0; i < network; i++) {
			st = new StringTokenizer(br.readLine()," ");
			comOne = Integer.parseInt(st.nextToken());
			comTwo = Integer.parseInt(st.nextToken());
			ckeckComputer(computers,comOne, comTwo);
		}
		
		int count = 0;
		for (int i = 2; i < computers.length; i++) {
			if (computers[i]) {
				count++;
			}
		}
		System.out.println(count);
	}

	/**
	 * 감염여부에 따라 true, false를 computers[]에서 처리.
	 * @param comOne
	 * @param comTwo
	 * @param ckeck
	 */
	public static void ckeckComputer(boolean computers[],int comOne, int comTwo) {
		//전체 컴퓨터 갯수만큼 반복
		for (int i = 0; i < computers.length; i++) {
			// 1일경우
			if (comOne == 1) {
				computers[1] = true;
				computers[comTwo] = true;
			}
			// 이미 true처리되어 바이러스 감염된 컴퓨터인 경우 연결되어 들어오는 컴퓨터 또한 감염처리.
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
