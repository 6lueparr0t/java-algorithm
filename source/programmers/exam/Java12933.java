// https://programmers.co.kr/learn/courses/30/lessons/12933
// 정수 내림차순으로 배치하기
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Java12933 {
  // public static String res;
  public static long solution(long n) {
    List<Long> list = new ArrayList<>();

    long repeat = n;
    while(true) {
      list.add(repeat % 10);
      repeat /= 10;

      if (repeat <= 0)
        break;
    }

    Collections.sort(list);

    long answer = 0;
    long count = 1;
    for (Long i : list) {
      answer += i * count;
      count *= 10;
    }

    return answer;

    // 이런 방법도 있다고 하는데 참고만..
    // res = "";
    // Long.toString(n).chars().sorted().forEach(c -> res = Character.valueOf((char)c) + res);
    // return Integer.parseInt(res);
  }

  public static void main(String[] args) {
    System.out.println(solution(118372));
  }
}
