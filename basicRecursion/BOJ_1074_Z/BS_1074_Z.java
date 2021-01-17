package baekjoon.two;

import java.util.Scanner;

/**
 * 
 * @author BUMSEOK SEO
 * @problem 1074(silver) z
 *
 */
public class BOJ_1074_Z {
	static int N, size, r, c;

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		size = (int) Math.pow(2, N);
		r = scann.nextInt();
		c = scann.nextInt();

		fillMap(size, 0, 0, 0l);
	}
	private static void fillMap(int size, int sr, int sc, long sum) {
		if (size == 1) {
			System.out.println(sum);
			return;
		}

		if (r < sr + size / 2 && c < sc + size / 2) {
			fillMap(size / 2, sr, sc, sum);
		} else if (r < sr + size / 2 && c < sc + size) {
			fillMap(size / 2, sr, sc + size / 2, sum + (((long)size * size) / 4));
		} else if (r < sr + size && c < sc + size / 2) {
			fillMap(size / 2, sr + size / 2, sc, sum + (((long)size * size) / 2));
		} else {
			fillMap(size / 2, sr + size / 2, sc + size / 2, sum + ((((long)size * size) * 3) / 4));
		}
	}
}
