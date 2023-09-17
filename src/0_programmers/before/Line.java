import java.util.Arrays;
import java.util.Comparator;

public class Line {
  public static void solution(int[][] L) {
    Arrays.sort(L, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[1] == o2[1]) {
          return o1[0] - o2[0];
        } else {
          return o1[1] - o2[1];
        }
      }
    });

    // int[] tmp = new int[2];
    for (int i = 0; i < L.length; i++) {
      System.out.printf("%d,%d | ", L[i][0], L[i][1]);
    }
    System.out.println();

    // return answer;
  }

  public static void main(String[] args) {
    int[][] request = { { 7, 0 }, { 5, 0 }, { 5, 3 }, { 6, 1 } }; // 맞지만 다른 TC에선 틀림
    solution(request);
  }
}