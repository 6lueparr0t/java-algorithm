// https://school.programmers.co.kr/learn/courses/30/lessons/120808?language=java
package exam;

public class Q03 {
  public static int[] solution(int numer1, int denom1, int numer2, int denom2) {
    int[] answer = new int[2];

    int num1 = (numer1 * denom2) + (numer2 * denom1);
    int num2 = denom1 * denom2;

    int g = 1;
    for (int i = 1; i <= num1; i++) {
      if (num1 % i == 0 && num2 % i == 0)
        g = i;
    }

    answer[0] = num1 / g;
    answer[1] = num2 / g;

    return answer;
  }

  public static void show(String caseTitle, int[] results) {
    System.out.printf(" ********** %s start **********\n\n", caseTitle);

    for(int i=0; i < results.length; i++) {
      System.out.printf("%d ", results[i]);
    }

    System.out.printf("\n\n");
  }

  public static void main(String[] args) {
    show("case1", solution(1,2,3,4));
  }
}
