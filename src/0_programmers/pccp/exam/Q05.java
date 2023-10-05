// https://school.programmers.co.kr/learn/courses/30/lessons/120863?language=java
package exam;

public class Q05 {
  public static String solution(String polynomial) {
    int count = 0;
    int x = 0;

    for (String term : polynomial.split(" ")) {
      if (term.contains("x")) {
        x += term.equals("x") ? 1 : Integer.parseInt(term.substring(0, term.length() - 1));
      } else if (!term.equals("+")) {
        count += Integer.parseInt(term);
      }
    }

    String answer = "0";
    if (count > 0 && x > 0) {
      answer = (x == 1 ? "" : x) + "x + " + count;
    } else if (count > 0 && x == 0) {
      answer = Integer.toString(count);
    } else if (count == 0 && x > 0) {
      answer = (x == 1 ? "" : x) + "x";
    }

    return answer;
  }

  public static void show(String caseTitle, String results) {
    System.out.printf(" ********** %s start **********\n\n", caseTitle);

    System.out.printf("%s ", results);

    System.out.printf("\n\n");
  }

  public static void main(String[] args) {
    show("case1", solution("3x + 7 + x"));

    show("case2", solution("x + x + x"));

    show("case3", solution("x + 1"));
  }
}
