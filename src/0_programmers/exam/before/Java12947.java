// https://programmers.co.kr/learn/courses/30/lessons/12947

public class Java12947 {
  public static boolean solution(int x) {
    String[] list = String.valueOf(x).split("");
    int sum = 0;

    for (String s : list) {
      sum += Integer.parseInt(s);
    }

    if (x % sum == 0) {
      return true;
    } else {
      return false;
    }
  }
}
