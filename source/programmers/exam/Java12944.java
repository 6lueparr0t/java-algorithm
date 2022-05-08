// https://programmers.co.kr/learn/courses/30/lessons/12944

public class Java12944 {
  public static double solution(int[] arr) {
    double sum = 0;
    for (int i : arr) {
      double j = i;
      sum += j;
    }

    return sum / arr.length;
  }
}
