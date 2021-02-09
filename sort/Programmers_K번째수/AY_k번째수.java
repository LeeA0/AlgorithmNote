package day;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// 프로그래머스_k번째 수_레벨1
public class Programmers_k번째수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		int X = Integer.parseInt(br.readLine());
		int Y = Integer.parseInt(br.readLine());
		int[][] commands = new int[X][Y];
		for (int i = 0; i < X; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < Y; j++) {
				commands[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(Arrays.toString(solution(array, commands)));
	}

	static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for (int i = 0; i < commands.length; i++) {
			ArrayList<Integer> temp = new ArrayList<>();
			for (int j = commands[i][0] - 1; j <= commands[i][1] - 1; j++) {
				temp.add(array[j]);
			}
			Collections.sort(temp);
			answer[i] = temp.get(commands[i][2]-1);
		}

		return answer;
	}
}
