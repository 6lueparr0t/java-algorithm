// https://programmers.co.kr/learn/courses/30/lessons/92334
import java.util.*;

public class Java92334 {
  public static int[] solution(String[] id_list, String[] report, int k) {
    int[] answer = new int[id_list.length];

    Map<String, HashSet<String>> map = new HashMap<>();
    Map<String, Integer> idxMap = new HashMap<>();

    for (int i = 0; i < id_list.length; i++) {
      String name = id_list[i];
      map.put(name, new HashSet<>());
      idxMap.put(name, i);
    }

    for (String s : report) {
      String[] str = s.split(" ");
      String from = str[0];
      String to = str[1];
      map.get(to).add(from);
    }

    // 값 확인용
    // for (String key : map.keySet()) {
    // System.out.println(String.format("키 : %s, 값 : %s", key, map.get(key)));
    // }

    for (int i = 0; i < id_list.length; i++) {
      HashSet<String> send = map.get(id_list[i]);
      if (send.size() >= k) {
        for (String name : send) {
          answer[idxMap.get(name)]++;
        }
        System.out.println();
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    String[] id_list = { "muzi", "frodo", "apeach", "neo" };
    String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };

    int[] result = solution(id_list, report, 2);

    for (int i : result) {
      System.out.printf("%d,", i);
    }
    System.out.println();
  }
}
