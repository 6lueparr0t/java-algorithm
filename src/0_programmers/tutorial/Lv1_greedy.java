import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Lv1_greedy {
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 여벌 체육복을 가져온 학생이 도난당한 경우
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i] == reserve[j]){
                    answer++;
                    System.out.printf("lost : %d\n", lost[i]);
                    System.out.printf("reserve : %d\n", reserve[j]);
                    lost[i] = -1;
                    reserve[j] = -1; 
                    break;
                }
            }
        }

        // 도난당한 학생에게 체육복 빌려주는 경우
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if((lost[i]-1 == reserve[j]) || (lost[i]+1 == reserve[j])){
                    answer++;
                    System.out.printf("lost : %d\n", lost[i]);
                    System.out.printf("reserve : %d\n", reserve[j]);
                    reserve[j] = -1; 
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        // 2 4
        int[] lost = Arrays.stream(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .mapToInt(Integer::valueOf)
        .toArray();

        // 1 3 5
        int[] reverse = Arrays.stream(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .mapToInt(Integer::valueOf)
        .toArray();

        int answer = solution(n, lost, reverse);

        System.out.printf("%d\n", answer);
    }
}
