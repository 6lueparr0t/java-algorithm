// https://school.programmers.co.kr/learn/courses/30/lessons/68645?language=java
/**
 * 1. n x n 2차원 배열 선언
 * 2. 숫자를 채울 현재 위치를 (0,0) 으로 설정
 * 3. 방향에 따라 이동할 수 없을 때까지 반복하면서 숫자 채우기
 * - a. 아래로 이동하면서 숫자 채우기
 * - b. 오른쪽으로 이동하면서 숫자 채우기
 * - c. 왼쪽 위로 이동하면서 숫자 채우기
 * 4. 채워진 숫자를 차례대로 1차원 배열에 옮겨서 반환
 */
public class Q02Improve {
  // (x,y) 좌표를 기준으로
  // 아래(x, y+1), 오른쪽(x+1, y), 왼쪽 위(x-1, y-1)
  private static final int[] dx = {0, 1, -1};
  private static final int[] dy = {1, 0, -1};

  public static int[] solution(int n) {
    // n x n 2차원 배열 선언
    int[][] triangle = new int[n][n];
    int v = 1;

    // 숫자를 채운 현재 위치를 (0,0) 으로 설정
    int x = 0;
    int y = 0;
    // 방향
    int d = 0;

    // 방향에 따라 이동할 수 없을 때까지 반복하면서 숫자 채우기
    while (true) {
      triangle[y][x] = v++;

      int nx = x + dx[d];
      int ny = y + dy[d];

      if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
        // 방향 전환을 한다.
        d = (d+1) % 3;
        nx = x + dx[d];
        ny = y + dy[d];
        // 모든 방향에 값이 다 있는 경우
        if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) break;
      }

      x = nx;
      y = ny;
    }

    int[] results = new int[v - 1];
    int index = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= i; j++) {
        results[index++] = triangle[i][j];
      }
    }

    return results;
  }

  public static void show(String caseTitle, int[] results) {
    System.out.printf(" ********** %s start **********\n\n", caseTitle);
    // 배열을 출력합니다.
    for (int i = 0; i < results.length; i++) {
      System.out.printf("%d,", results[i]);
    }

    System.out.printf("\n\n");
  }

  public static void main(String[] args) {
    int case1 = 4;
    show("case1", solution(case1));

    int case2 = 5;
    show("case2", solution(case2));

    int case3 = 6;
    show("case3", solution(case3));
  }
}
