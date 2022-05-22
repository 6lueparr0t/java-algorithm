// https://programmers.co.kr/learn/courses/30/lessons/12932
// 자연수 뒤집어 배열로 만들기
public class Java12932 {
  public int[] solution(long n) {
    String[] s = String.valueOf(n).split("");
    int length = s.length;
    
    int[] answer = new int[length];
    int count = 1;
    for(String i : s) {
        answer[length-count] = Integer.parseInt(i);
        count++;
    }
    
    return answer;
  }
}
