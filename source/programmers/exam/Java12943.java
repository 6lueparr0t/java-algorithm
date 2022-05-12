// https://programmers.co.kr/learn/courses/30/lessons/12943
// 짝수면 2를 나누고, 홀수면 3을 곱하고 1을 더해서 1을 만든다.
class Solution {
  public int solution(int num) {
      // long 타입을 꼭 확인하자
      long lnum = num;
      int i=0;
      
      while(lnum != 1) {
          if(lnum % 2 == 0) {
              lnum /= 2;
          } else {
              lnum = (lnum * 3) + 1;
          }
          
          i++;
          if(i >= 400) {
              return -1;
          }
      }
      
      int answer = i;
      return answer;
  }
}