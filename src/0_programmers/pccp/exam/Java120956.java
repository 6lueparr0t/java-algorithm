// https://school.programmers.co.kr/learn/courses/30/lessons/120956?language=java
package exam;

public class Java120956 {
  public static int solution(String[] babbling) {
    String[] babblingList = { "aya", "ye", "woo", "ma" };

    int answer = 0;
    int len = 0;
    for (String target : babbling) {
      len = target.length();
      for (String b : babblingList) {
        if (target.contains(b)) {
          len -= b.length();
        }
      }

      if (len == 0)
        answer++;
    }

    return answer;
  }

  public static void show(String caseTitle, int results) {
    System.out.printf(" ********** %s start **********\n\n", caseTitle);
    System.out.println(results);

    System.out.printf("\n\n");
  }

  public static void main(String[] args) {
    String[] case1 = { "aya", "yee", "u", "maa", "wyeoo" };
    show("case1", solution(case1));

    String[] case2 = { "ayaye", "uuuma", "ye", "yemawoo", "ayaa" };
    show("case2", solution(case2));
  }
}
