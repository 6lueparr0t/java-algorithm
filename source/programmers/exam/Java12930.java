// https://programmers.co.kr/learn/courses/30/lessons/12930
// 이상한 문자 만들기

public class Java12930 {
  public String solution(String s) {
    String answer = "";
    int count = 0;
    String[] wordList = s.split("");

    for(String word : wordList) {
        if(" ".equals(word)) {
            count = 0;
        } else {
            count++;
        }
        
        if(count%2 == 0) {
            answer += word.toLowerCase();
        } else {
            answer += word.toUpperCase();
        }
    }
    
    return answer;
}
}
