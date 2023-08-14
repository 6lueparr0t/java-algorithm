import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Lv1_binary {
    public static long solution(int n, int[] times) {
        // 모든 사람이 심사를 받는데 걸리는 시간의 최솟값
        long answer = Long.MAX_VALUE;
        
        Arrays.sort(times);
        
        long start, mid, end;
        start = 0;
        end = Long.MAX_VALUE;
        long sum;
        
        // 모든 사람이 심사 받는데 걸리는 시간 이분 탐색
        // mid : 심사를 받는데 주어진 시간
        // sum : 주어진 시간(mid)동안 심사를 받을 수 있는 사람 수 
        while(start <= end) {
            mid = (start + end) / 2;
            System.out.printf("%d\n", mid);
            
            sum = 0;
            // 주어진 시간동안 몇명 검사 할 수 있는지 누적합
            for(int i=0; i<times.length; i++) {
                sum += mid / times[i];
                System.out.printf("sum(%d) += mid(%d) / times[%d](%d)\n", sum, mid, i, times[i]);

                if(sum >= n) break;
            }
            
            // 비교 대상(사람 수)
            // 검사 다 못할 때(시간 부족)
            if(n > sum){
                start = mid + 1;
            } else {
                // 검사 다 했을 때 (시간이 남음)
                // 최소 시간 찾아야함
                end = mid - 1;
                answer = Math.min(answer, mid);
            }
        }
        
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(bufferedReader.readLine().trim());

        int[] times = Arrays.stream(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .mapToInt(Integer::valueOf)
        .toArray();

        long answer = solution(N, times);

        System.out.printf("%d\n", answer);
    }
}
