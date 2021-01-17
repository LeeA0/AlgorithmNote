import java.io.BufferedReader;
import java.util.Scanner;

public class SW_16505_별 {

	static int N,length;
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        N = sc.nextInt();
	        length = (int)Math.pow(2, N);
	 
	        map = new char[length][length];
	 
	        func(0, 0, length);
	 
	        for (int i = 0; i < length; i++) {
	            for (int j = 0; j < length; j++) {
	                if (j == length - i) break;
	                if (map[i][j] == '*') bw.write(map[i][j]);
	                else bw.write(' ');
	            }
	        }
	}
	private static void func(int x, int y, int length) {
        if (length == 1) {
            map[x][y] = '*';
            return;
        }
 
        int newLength = length/2;
        func(x, y, newLength);
        func(x, y + newLength, newLength);
        func(x + newLength, y, newLength);
    }

}
