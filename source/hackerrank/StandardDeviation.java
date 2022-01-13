package source.hackerrank;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

class Result {

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

        Result.stdDev(vals);

        bufferedReader.close();
    }
}