// https://school.programmers.co.kr/learn/courses/30/lessons/120812?language=java
package exam;

import java.util.Arrays;

public class Q06 {
  public static int solution(int[] array) {
    Arrays.sort(array);
    int max = array[array.length - 1];

    int[] count = new int[max + 1];
    for (int i = 0; i < array.length; i++) {
      count[array[i]]++;
    }

    max = count[0];
    int answer = 0;
    for (int i = 1; i < count.length; i++) {
      if (max < count[i]) {
        max = count[i];
        answer = i;
      } else if (max == count[i]) {
        answer = -1;
      }
    }

    return answer;
  }

  public static void show(String caseTitle, int results) {
    System.out.printf(" ********** %s start **********\n\n", caseTitle);

    System.out.printf("%d ", results);

    System.out.printf("\n\n");
  }

  public static void main(String[] args) {
    show("case1", solution(new int[]{1, 2, 3, 3, 3, 4}));

    show("case2", solution(new int[]{1, 1, 2, 2}));

    show("case3", solution(new int[]{1}));
  }
}
