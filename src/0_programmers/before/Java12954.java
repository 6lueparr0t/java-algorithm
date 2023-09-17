// https://programmers.co.kr/learn/courses/30/lessons/12954
// x : 초기 값, n : 반복할 수
// 쉬워보이지만 long type 으로 변환하는 것이 포인트

public class Java12954 {
  public static long[] solution(int x, int n) {
    long[] answer = new long[n];
    long longX = x;

    for (int i = 1; i <= n; i++) {
      answer[i - 1] = longX * i;
    }
    return answer;
  }

  public static void main(String[] args) {
    long[] result = solution(2, 5);

    for(int i=0; i<result.length; i++) {
      System.out.print(result[i]+ " ");
    }
    System.out.println();
  }
}