// https://programmers.co.kr/learn/courses/30/lessons/12934
// 제곱근 찾고 제곱근에 +1 후 제곱값 리턴하기
public class Java12934 {
  public static long solution(long n) {
    long sqrt = (long) Math.sqrt(n);

    if(sqrt*sqrt == n) {
        sqrt++;
        return sqrt*sqrt;
    } else {
        return -1;
    }
  }
}
