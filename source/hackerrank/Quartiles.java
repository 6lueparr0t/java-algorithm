package source.hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/*
 * Day 1-1
 * 
 * Quartiles (사분위수)
 * 
 * OUTPUT_PATH 때문에 정상 실행안되는 것 같다.
 */

class Result_1_1 {

    public static List<Integer> quartiles(List<Integer> arr) {
        // Write your code here
        List<Integer> result = new ArrayList<Integer>();
        Collections.sort(arr);
        
        int q1Max = (arr.size()/2)-1;
        int q2Max = arr.size()-1;
        
        int q3min = (arr.size()%2==0)?arr.size()/2:(arr.size()/2)+1;
        int q3Max = arr.size()-1;
        
        int q1 = (arr.get((0+q1Max)/2) + arr.get((0+q1Max+1)/2)) / 2;
        int q2 = (arr.get((0+q2Max)/2) + arr.get((0+q2Max+1)/2)) / 2;
        int q3 = (arr.get((q3min+q3Max)/2) + arr.get((q3min+q3Max+1)/2)) / 2;
        
        //Q1
        result.add(q1);
        
        //Q2
        result.add(q2);
        
        //Q3
        result.add(q3);
        
        return result;
    }

}

public class Quartiles {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> data = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> res = Result_1_1.quartiles(data);

        bufferedWriter.write(
            res.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}