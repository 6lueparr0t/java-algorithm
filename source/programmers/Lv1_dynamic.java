package source.programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lv1_dynamic {
    // 전역 변수로 호출
    static int min = Integer.MAX_VALUE;
    
    public static int solution(int N, int number) {
        // 함수 호출
        dfs(0, N, number, 0);
        
        // 값에 변화가 없으면 -1 리턴
        if (min == Integer.MAX_VALUE) return -1;
        return min;
    }
    
    public static void dfs(int depth, int N, int number, int current) {
        // depth 가 8 이상이면 -1
        if (depth > 8) {
            return;
        }
        
        // 요청 값과 계산 값이 같으면
        if (number == current) {
            min = Math.min(depth, min);
            return;
        }
        
        int temp = 0;
            
        for (int i = 0; i < 8; i++) {
            if (depth + i < 8) {
                temp = temp * 10 + N;
                dfs(depth + i + 1, N, number, current + temp);
                dfs(depth + i + 1, N, number, current - temp);
                dfs(depth + i + 1, N, number, current / temp);
                dfs(depth + i + 1, N, number, current * temp);     
            }      
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(bufferedReader.readLine().trim());

        int number = Integer.parseInt(bufferedReader.readLine().trim());

        int answer = solution(N, number);

        System.out.printf("%d\n", answer);
    }
}
