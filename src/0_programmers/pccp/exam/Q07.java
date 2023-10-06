// https://school.programmers.co.kr/learn/courses/30/lessons/120812?language=java
package exam;

import java.util.Arrays;

public class Q07 {
  public static int[] solution(int n) {
    int[] answer;
    answer = (n % 2 == 1) ? new int[n / 2 + 1] : new int[n / 2];

    int j = 0;
    for (int i = 0; i <= n; i++) {
      if (i % 2 == 1) {
        answer[j] = i;
        j++;
      }
    }

    return answer;
  }

  public static void show(String caseTitle, int[] results) {
    System.out.printf(" ********** %s start **********\n\n", caseTitle);

    for (int i : results) {
      System.out.printf("%d, ", i);
    }

    System.out.printf("\n\n");
  }

  public static void main(String[] args) {
    show("case1", solution(10));

    show("case2", solution(15));

    show("case3", solution(1));

    show("case4", solution(0));
  }
}
