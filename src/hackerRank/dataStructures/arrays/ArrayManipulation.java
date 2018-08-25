//$Id$
package hackerRank.dataStructures.arrays;

import java.util.Scanner;

public class ArrayManipulation {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int querySize = in.nextInt();
		long[] arr = new long[(int) size+1];
		for(int i = 0;i < querySize;i++){
			int p = in.nextInt();
			int q = in.nextInt();
			int sum = in.nextInt();
			arr[p]+=sum;
			if((q+1)<=size) arr[q+1]-=sum;
		}
		long x = 0;
		long max = 0;
		for(int i = 1; i<=size ;i++){
			x+=arr[i];
			if(max < x) max = x;
		}
		System.out.println(max);
	}
}
