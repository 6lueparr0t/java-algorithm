import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Lv1_hash {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();

        // System.out.printf("HashMap 리스트를 셋팅한다.\n");
        for (String player : participant) {
            hm.put(player, hm.getOrDefault(player, 0) + 1);
            System.out.printf("Key : %s | Value : %d\n", player, hm.getOrDefault(player, 0));
        }

        // System.out.printf("HashMap 에서 completion 을 뺀다.\n");
        for (String player : completion) {
            hm.put(player, hm.get(player) - 1);
            System.out.printf("Key : %s | Value : %d\n", player, hm.getOrDefault(player, 0));
        }

        // System.out.printf("HashMap 에서 키만 가져와 값이 0 이 아닌 것을 리턴한다.\n");
        for (String key : hm.keySet()) {
            System.out.printf("%s : %d\n", key, hm.get(key));
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        // /java-algorithm/source/hackerrank/tutorial/D28_Regex.java 참고
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 : a a b c
        String[] participant = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        String[] completion = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        
        // 입력 : a b c
        String answer = solution(participant, completion);

        // 출력 : a
        System.out.println(answer);

        bufferedReader.close();
    }
}
