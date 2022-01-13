package source.hackerrank;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

/**
 * https://www.hackerrank.com/domains/tutorials/10-days-of-statistics
 * 
 * Day 1-3
 * 
 * 표준편차
 * 
 * STDIN           Function
 * -----           --------
 * 5               arr[] size n = 5
 * 10 40 30 50 20  arr =[10, 40, 30, 50, 20]
 * 
 * 14.1
 * 
 * arr를 다 더한 후 size로 나누고, 이걸 mean 라고 부른다.
 * 각 배열의 인자에 mean 을 빼고 제곱하여 더하고
 * 마지막에 size 로 나누고 루트를 적용함.
 * 
 */
class Result_1_3 {

    /*
     * Complete the 'stdDev' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void stdDev(List<Integer> arr) {
        // Print your answers to 1 decimal place within this function
        double mean = 0;
        for(int i=0; i<arr.size(); i++) {
            mean += arr.get(i);
        }
        mean = (double) mean / arr.size();
        
        double result = 0;
        for(int i=0; i<arr.size(); i++) {
            result += Math.pow(arr.get(i) - mean, 2);
        }
        
        System.out.printf("%.1f", Math.sqrt(result / arr.size()));
    }

}

public class StandardDeviation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> vals = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

            Result_1_3.stdDev(vals);

        bufferedReader.close();
    }
}