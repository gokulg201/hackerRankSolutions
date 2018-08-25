//$Id$
package moodyCodeSprint;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProfitTarget {
	public static void main(String[] args) throws IOException{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		int q = Integer.parseInt(bufferedReader.readLine().trim());
		if(q >= 1 && q <= Math.pow(10, 3)){
			for(int i = 0;i < q;i++){
				int n = Integer.parseInt(bufferedReader.readLine().trim());
				if(n >= 1 && n <= Math.pow(10, 4)){
					long carry = 0;
					for(int j =0 ;j < n;j++){
						String[] profitsRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
						long actual = Long.parseLong(profitsRowTempItems[0]);
						long estimated = Long.parseLong(profitsRowTempItems[1]);
						if(actual >= 1 && estimated >= 1 && actual <= Math.pow(10, 9) && estimated <= Math.pow(10, 9)){
							estimated = estimated + carry;
							carry = 0;
							if(actual < estimated){
								carry = (estimated - actual);
							}
						}else{
							return;
						}
					}
					bufferedWriter.write(String.valueOf(carry == 0 ? 0:1));
		            bufferedWriter.newLine();
//					System.out.println(carry == 0 ? 0:1);
				}
			}
		}
		bufferedWriter.close();
		bufferedReader.close();
	}
}
