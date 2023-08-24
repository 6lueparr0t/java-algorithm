// https://programmers.co.kr/learn/courses/30/lessons/12940

// 최대 공약수와 최대 공배수 구하기

public class Java12940 {
  public int[] solution(int n, int m) {
    int[] answer = new int[2];
    int length = (n > m) ? n : m;

    answer[0] = 1; // 최소 공배수
    answer[1] = 1; // 최대 공약수

    int i = 2;
    while (i <= length) {
      if (m % i == 0 && n % i == 0) {
        m /= i;
        n /= i;

        answer[0] *= i;
      } else {
        i++;
      }
    }
    answer[1] = answer[0] * m * n;

    return answer;
  }
}
