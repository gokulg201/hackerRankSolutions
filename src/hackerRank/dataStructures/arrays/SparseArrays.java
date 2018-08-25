//$Id$
package hackerRank.dataStructures.arrays;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class SparseArrays {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int stringsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        HashMap<String, Integer> stringFrequency = new HashMap<String, Integer>();
        for (int i = 0; i < stringsCount; i++) {
            String str = scanner.nextLine();
    		if(stringFrequency.containsKey(str)){
    			stringFrequency.put(str, stringFrequency.get(str) + 1);
    		}else{
    			stringFrequency.put(str, 1);
    		}
        }

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < queriesCount; i++) {
            String query = scanner.nextLine();
            if(stringFrequency.containsKey(query)){
            	System.out.println(stringFrequency.get(query));
    		}else{
    			System.out.println(0);
    		}
        }
        scanner.close();
    }
}
