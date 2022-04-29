import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class D11_TwoArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = -9*6;
        int tmp = -10;
        for(int j=0; j<arr.size()-2; j++) {
            for(int k=0; k<arr.get(j).size()-2; k++) {
                tmp = arr.get(j).get(k);
                tmp += arr.get(j).get(k+1);
                tmp += arr.get(j).get(k+2);
                
                tmp += arr.get(j+1).get(k+1);
                
                tmp += arr.get(j+2).get(k);
                tmp += arr.get(j+2).get(k+1);
                tmp += arr.get(j+2).get(k+2);

                if(result < tmp) result = tmp;
            }
                                
            if(j+2 == arr.size()) break;
        }
        
        System.out.printf("%d\n", result);
        
        bufferedReader.close();
    }
}

