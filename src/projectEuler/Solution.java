//$Id$
package projectEuler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Solution {
	static long gcd(long a, long b){
		if(a == 0 || b == 0)
			return 0;
		if (a == b)
            return a;
		if (a > b)
            return gcd(a-b, b);
        return gcd(a, b-a);
	}
	static double area(int a, int b){
		return 0.5*a*b;
	}
	static boolean isPerfectSquare(long c){
		long sqrt = (long)Math.sqrt(c);
		if(sqrt*sqrt == c)
			return true;
		return false;
	}
	static boolean isPrimitive(long a, long b, long c) {
		return gcd(a, b) == 1 && gcd(b, c) == 1;
	}
	static boolean isSuperPerfect(long a, long b) {
		BigInteger area = BigInteger.valueOf(a).multiply(BigInteger.valueOf(b)).divide(BigInteger.valueOf(2));
		return area.mod(BigInteger.valueOf(28)).equals(BigInteger.ZERO) && area.mod(BigInteger.valueOf(6)).equals(BigInteger.ZERO);
	}
	public static void main(String[] args){
		int count = 0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    try {
			int q = Integer.parseInt(reader.readLine());
			for(long k = 0;k < q;k++){
				long limit = Integer.parseInt(reader.readLine());
				for(long x = 0;x < Math.sqrt(2*limit) ;x++){
					for(long y = 1;y < x;y++){
						if(x % 2 == y %2)
							continue;
						if(gcd(x, y)!= 1)
							continue;
						long a = x*x -y*y;
						long b = 2*x*y;
						long c = x*x + y*y;
						if(c > limit)
							break;
						if(!isPerfectSquare(c)){
							continue;
						}
//						if(!isPrimitive(a, b, c)){
//							continue;
//						}
						if(!isSuperPerfect(a, b)){
							count++;
							continue;
						}
					}
				}
			}
			System.out.println(count);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}
