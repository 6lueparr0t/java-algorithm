// https://programmers.co.kr/learn/courses/30/lessons/12931
// 자리 수 더하기
public class Java12931 {
  public int solution(int n) {
    int num = n;
    int sum = 0;
    while(num>0) {
        sum += num % 10;
        num /= 10;
    }

    return sum;
  }
}