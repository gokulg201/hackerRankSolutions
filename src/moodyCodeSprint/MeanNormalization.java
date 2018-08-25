//$Id$
package moodyCodeSprint;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MeanNormalization {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        double[] mean_i = new double[n];
        List<Double> p_i_j = new ArrayList<Double>();
        for(int a0 = 0; a0 < n; a0++){
            int m_i = Integer.parseInt(bufferedReader.readLine().trim());
            Double[] p_i = new Double[m_i];
            String p = bufferedReader.readLine().trim();
            for(int p_i_i = 0; p_i_i < m_i; p_i_i++){
                p_i[p_i_i] = Double.parseDouble(p.split(" ")[p_i_i]);
                p_i_j.add((double) p_i[p_i_i]);
            }
            mean_i[a0] = (double)sum(p_i) / m_i;
        }
        bufferedWriter.write(String.valueOf(findingMean(p_i_j, mean_i)));
        bufferedWriter.close();
		bufferedReader.close();
    }
	static double sum(Double[] ele){
		double sum = 0;
		for(int i =0;i < ele.length;i++){
			sum+= ele[i];
		}
		return sum;
	}
	static Double findingMean(List<Double> p_i_j , double[] mean_i){
		Double[] p = new Double[p_i_j.size()];
		p = p_i_j.toArray(p);
		Arrays.sort(mean_i);
		p_i_j.sort(new Comparator<Double>() {
			@Override
			public int compare(Double o1, Double o2) {
				if((o1 - o2) > 1){
					return 1;
				}else if((o1 - o2) < 1){
					return -1;
				}else{
					return 0;
				}
			}
		});
		Double result = (Double) null;
		Double cur = (Double) null;
		int j = 0;
		for(double mean:mean_i){
			int prefCnt = 0;int sufCnt = p_i_j.size();
			double prefSum = 0;double sufSum = sum(p);
			while(j < p_i_j.size() && p_i_j.get(j) <= mean){
				prefCnt+=1;
				prefSum+= p_i_j.get(j);
				sufCnt-=1;
				sufSum-= p_i_j.get(j);
				j+=1;
				cur = prefCnt*mean -prefSum + sufSum - sufCnt*mean;
				if(result!=null){
					if(cur < result)
						result = cur;
				}else{
					result = cur;
				}
			}
		}
		return result;
	}
}
