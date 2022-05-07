import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Lv1_sort {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
 
        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }
 
        return answer;
    }

    public static void main(String[] args) throws IOException {
        // /java-algorithm/source/hackerrank/tutorial/D28_Regex.java 참고
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // 입력 : 1, 5, 2, 6, 3, 7, 4
        int[] inputArray = Arrays.stream(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .mapToInt(Integer::valueOf)
        .toArray();
        
        System.out.printf("몇 번 수행할 것인지? : ");
        int N = Integer.parseInt(bufferedReader.readLine().trim());

        // 입력 : [[2, 5, 3], [4, 4, 1], [1, 7, 3]]
        // command : 시작인덱스, 끝인덱스, 위치
        int[][] command = new int[N][];

        for(int i = 0; i < N; i++ ) {
            command[i] = Arrays.stream(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .mapToInt(Integer::valueOf)
            .toArray();
        }

        int[] answer = solution(inputArray, command);
        for(int i=0; i < answer.length; i++) {
            System.out.printf("%d ", answer[i]);
        }
        System.out.println("");


        bufferedReader.close();
    }
}
