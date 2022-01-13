package source.hackerrank;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * https://www.hackerrank.com/domains/tutorials/10-days-of-statistics
 * 
 * Day 1-2
 * 
 * 사분위수 범위
 * 
 * STDIN           Function
 * -----           --------
 * 6               arrays size n = 6
 * 6 12 8 10 20 16 values = [6, 12, 8, 10, 20, 16]
 * 5 4 3 2 1 5     freqs = [5, 4, 3, 2, 1, 5]
 * 
 * 9.0
 * 
 * Lower half (L): 6, 6, 6, 6, 6, 8, 8, 8, 10, 10
 * Upper half (U): 12, 12, 12, 12, 16, 16, 16, 16, 16, 20
 * 
 * Q3 - Q1 = ((16+16)/2) - ((6+8)/2) = 16 - 7 = 9
 * 
 */
class Result_1_2 {

    /*
     * Complete the 'interQuartile' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY values
     *  2. INTEGER_ARRAY freqs
     */
    public static double mean(List<Integer> numList) {
        if (numList.size() % 2 == 0) {
            return ((double)numList.get(numList.size() / 2) + (double)numList.get((numList.size() / 2) - 1)) / 2;    
        }
        else {
            return (double)numList.get(numList.size() / 2);
        }
    }

    public static void interQuartile(List<Integer> values, List<Integer> freqs) {
        // Print your answer to 1 decimal place within this function
        List<Integer> s = new ArrayList<Integer>();
        for(int i=0; i < freqs.size(); i++) {
            for(int j=0; j < freqs.get(i); j++) {
                s.add(values.get(i));
            }
        }
        
        Collections.sort(s);
        
        List<Integer> lower = new ArrayList<Integer>();
        List<Integer> upper = new ArrayList<Integer>();
        
        for(int i=0; i<s.size(); i++) {
            if (i < Math.ceil((double)s.size()/2)) {
                lower.add(s.get(i));
                //System.out.printf("%d lower %d\n", i, s.get(i));
            } else {
                upper.add(s.get(i));
                //System.out.printf("%d upper %d\n", i, s.get(i));
            }
        }
        
        double q1 = mean(lower);
        double q3 = mean(upper);
        
        System.out.printf("%.1f", q3 - q1);
    }

}

public class InterquartileRange {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> val = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> freq = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result_1_2.interQuartile(val, freq);

        bufferedReader.close();
    }
}
