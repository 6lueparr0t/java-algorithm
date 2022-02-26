package source.programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Lv1_stack_queue {
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];

        int day = -1;
        for(int i=0; i < progresses.length; i++) {
            while(progresses[i] + (day * speeds[i]) < 100) {
                day++;
            }

            dayOfend[day]++;
        }

        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 : 90 30 5
        int[] progresses = Arrays.stream(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .mapToInt(Integer::valueOf)
        .toArray();

        // 입력 : 1 30 5
        int[] speeds = Arrays.stream(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .mapToInt(Integer::valueOf)
        .toArray();
        
        int[] answer = solution(progresses, speeds);

        System.out.println("");
        for(int i=0; i < answer.length; i++) {
            System.out.printf("%d 번째 : %d 건 완성\n", i+1, answer[i]);
        }

        bufferedReader.close();
    }
}


// public static int[] solution(int[] progresses, int[] speeds) {
//     int[] dayOfend = new int[100];
//     int day = -1;
//     for(int i=0; i<progresses.length; i++) {
//         System.out.printf("progress: %d\n", progresses[i] + (day*speeds[i]));
//         while(progresses[i] + (day*speeds[i]) < 100) {
//             System.out.printf("%d 번째 날 : %d < 100\n", day, progresses[i] + (day*speeds[i]));
//             day++;
//         }
//         System.out.printf("%d 번째 날 : %d 번째 작업 완성\n", day, i+1);
//         dayOfend[day]++;
//     }

//     // for(int i=0; i<dayOfend.length; i++) {
//     //     System.out.printf("dayOfend[%d] : %d\n", i, dayOfend[i]);
//     // }
//     return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
// }