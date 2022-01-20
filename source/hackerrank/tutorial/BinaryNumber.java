package source.hackerrank.tutorial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BinaryNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        
        List<Integer> digit = new ArrayList<Integer>();
        while(n>0) {
            digit.add(n%2);
            n = n/2;
        }
        
        int result = 0;
        int cnt = 0;
        for(int i=digit.size()-1; i>=0; i--) {
            if(digit.get(i) == 0) {
                if(result < cnt) {
                    result = cnt;
                }
                cnt = 0;
            } else {
                cnt++;
            }
        }
        
        System.out.printf("%d\n", (result>cnt)?result:cnt);

        bufferedReader.close();
    }
}
