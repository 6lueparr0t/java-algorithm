import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Lv1_heap {
    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> mixingHeap = new PriorityQueue<>();
        for(int i=0; i < scoville.length; i++) {
            mixingHeap.offer(scoville[i]);
        }

        while(mixingHeap.peek() < K) {
            if(mixingHeap.size() < 2) {
                answer = -1;
                break;
            }

            mixingHeap.add(mixingHeap.poll() + (mixingHeap.poll() * 2));
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        // /java-algorithm/source/hackerrank/tutorial/D28_Regex.java 참고
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // 입력 : 1, 2, 3, 9, 10, 12
        int[] scoville = Arrays.stream(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .mapToInt(Integer::valueOf)
        .toArray();
        
        // 입력 : 7
        int K = Integer.parseInt(bufferedReader.readLine().trim());

        int answer = solution(scoville, K);

        System.out.printf("%d\n", answer);

        bufferedReader.close();
    }
    
}
