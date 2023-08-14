// https://programmers.co.kr/learn/courses/30/lessons/12928?language=java
// 약수의 합
public class Java12928 {
  public int solution(int n) {
      int sum = 0;
      for(int i=1; i<=n/2; i++) {
          if(n % i == 0) {
              sum += i;
          }
      }
      
      int answer = sum+n;
      
      return answer;
  }
}
