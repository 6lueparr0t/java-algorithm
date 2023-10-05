// https://school.programmers.co.kr/learn/courses/30/lessons/000?language=java
/**
 */
public class Q04 {

  public static int[][] solution(int[][] arr1, int[][] arr2) {
    int[][] arr = new int[arr1.length][arr2[0].length];
    // 행렬 곱셈

    for(int i=0; i<arr.length; i++) {
      for (int j=0; j<arr[i].length; j++) {
        // arr[i][j] 의 값 구하기
        arr[i][j] = 0;
        for (int k=0; k<arr1[i].length; k++) {
          arr[i][j] += arr1[i][k] * arr2[k][j];
        }
      }
    }
    return arr;
  }

  public static void show(String caseTitle, int[][] results) {
    System.out.printf(" ********** %s start **********\n\n", caseTitle);
    // 배열을 출력합니다.
    for (int i = 0; i < results.length; i++) {
      for (int j = 0; j < results[i].length; j++) {
        System.out.printf("%d, ", results[i][j]);
      }
      System.out.println("");
    }

    System.out.printf("\n\n");
  }

  public static void main(String[] args) {
    int[][] case1_arr1 = {
        {1,4},
        {3,2},
        {4,1},
    };
    int[][] case1_arr2 = {
        {3,3},
        {3,3},
    };
    show("case1", solution(case1_arr1, case1_arr2));

    int[][] case2_arr1 = {
        {2,3,2},
        {4,2,4},
        {3,1,4},
    };
    int[][] case2_arr2 = {
        {5,4,3},
        {2,4,1},
        {3,1,1},
    };
    show("case2", solution(case2_arr1, case2_arr2));
  }
}
