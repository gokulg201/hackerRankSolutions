//$Id$
package moodyCodeSprint;

import java.util.Scanner;

public class GapUpGapDown {
	static final double N_UPPERLIMIT = Math.pow(10, 5);
	public static void main(String[] args){
		int n;
		int[] low, high, close;
		int gapUp = 0;
		int gapDown = 0;
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		low = new int[n];
		high = new int[n];
		close = new int[n];
		if(n >=2 && n<= N_UPPERLIMIT){
			for(int i = 0;i < n;i++){
				low[i] = in.nextInt();
			}
			for(int i = 0;i < n;i++){
				high[i] = in.nextInt();
			}
			for(int i = 0;i < n;i++){
				close[i] = in.nextInt();
			}
			for(int j = 1;j < n;j++){
				if(low[j] > close[j-1])
					gapUp++;
				if(high[j] < close[j-1])
					gapDown++;
			}
			System.out.println(gapUp+" "+gapDown);
		}
	}
}
