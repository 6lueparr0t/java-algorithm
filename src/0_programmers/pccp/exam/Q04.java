// https://school.programmers.co.kr/learn/courses/30/lessons/181856?language=java
package exam;

import java.util.Arrays;

public class Q04 {
  public static int solution(int[] arr1, int[] arr2) {
    int answer = 0;

    int sum1 = Arrays.stream(arr1).sum();
    int sum2 = Arrays.stream(arr2).sum();

    if (arr1.length > arr2.length || (arr1.length == arr2.length && sum1 > sum2)) {
      answer = 1;
    } else if (arr1.length < arr2.length || (arr1.length == arr2.length && sum1 < sum2)) {
      answer = -1;
    } else {
      answer = 0;
    }

    return answer;
  }

  public static void show(String caseTitle, int results) {
    System.out.printf(" ********** %s start **********\n\n", caseTitle);

    System.out.printf("%d ", results);

    System.out.printf("\n\n");
  }

  public static void main(String[] args) {
    show("case1", solution(new int[] { 49, 13 }, new int[] { 70, 11, 2 }));

    show("case2", solution(new int[] { 100, 17, 84, 1 }, new int[] { 55, 12, 65, 36 }));

    show("case3", solution(new int[] { 1, 2, 3, 4, 5 }, new int[] { 3, 3, 3, 3, 3 }));
  }
}
