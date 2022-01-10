package source.hackerrank;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

/*
 * Day 0
 * 
 * 가중치 평균
 * 
 * 1. X[i]랑 W[i]랑 서로 곱한다.
 * 2. W 배열의 데이터를 다 더해서 나눈다.
 * 
 *  Sample Input
 STDIN           Function
 -----           --------
 5               X[] and W[] size n = 5
 10 40 30 50 20  X = [10, 40, 30, 50, 20]
 1 2 3 4 5       W = [1, 2, 3, 4, 5]
 
 Sample Output
 32.0
*/

class Result_0 {

    public static void weightedMean(List<Integer> X, List<Integer> W) {
        // Write your code here        
        double sum = 0.0f;
        int weight = 0;
        
        for(int i=0; i<X.size(); i++) {
            sum += (double)X.get(i) * (double)W.get(i);
            weight += (double)W.get(i);
        }
        
        System.out.printf("%.1f", sum/weight);
    }

}

public class WeightedMean {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> vals = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> weights = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

            Result_0.weightedMean(vals, weights);

        bufferedReader.close();
    }
}
