
public class Template {

  public static String[] solution(int[][] line) {
    return null;
  }

  public static void show(String caseTitle, String[] results) {
    System.out.printf(" ********** %s start **********\n\n", caseTitle);
    // 배열을 출력합니다.
    for (int i = 0; i < results.length; i++) {
      System.out.println(results[i]);
    }

    System.out.printf("\n\n");
  }

  public static void main(String[] args) {
    int[][] case1 = {
        {},
    };
    show("case1", solution(case1));
  }
}
