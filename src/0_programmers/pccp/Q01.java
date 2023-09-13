
/**
 * 1. 모든 직선 쌍에 대해 반복
 * a. 교점 좌표 구하기
 * b. 정수 좌표만 저장
 * 2. 저장된 정수들에 대해 x, y 좌표의 최댓값, 최솟값 구하기
 * 3. 구한 최댓값, 최솟값을 이용하여 2차원 배열의 크기 결정
 * 4. 2차원 배열에 별 표시
 * 5. 문자열 배열로 변환 후 반환
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Q01 {
  private static class Point {
    public final long x, y;

    private Point(long x, long y) {
      this.x = x;
      this.y = y;
    }
  }

  private static Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
    // 교점 구해서 반환
    double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
    double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);

    if (x % 1 != 0 || y % 1 != 0)
      return null;

    return new Point((long) x, (long) y);
  }

  private static Point getMinimumPoint(List<Point> points) {
    // 가장 작은 좌표 찾기
    long x = Long.MAX_VALUE;
    long y = Long.MAX_VALUE;

    for (Point p : points) {
      if (p.x < x)
        x = p.x;
      if (p.y < y)
        y = p.y;
    }
    return new Point(x, y);
  }

  private static Point getMaximumPoint(List<Point> points) {
    // 가장 큰 좌표 찾기
    long x = Long.MIN_VALUE;
    long y = Long.MIN_VALUE;

    for (Point p : points) {
      if (p.x > x)
        x = p.x;
      if (p.y > y)
        y = p.y;
    }
    return new Point(x, y);
  }

  public static String[] solution(int[][] line) {
    List<Point> points = new ArrayList<>();
    for (int i = 0; i < line.length; i++) {
      for (int j = i + 1; j < line.length; j++) {
        Point intersection = intersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);

        if (intersection != null) {
          points.add(intersection);
        }
      }
    }

    Point minimum = getMinimumPoint(points);
    Point maximum = getMaximumPoint(points);

    int width = (int) (maximum.x - minimum.x + 1);
    int height = (int) (maximum.y - minimum.y + 1);

    char[][] arr = new char[height][width];
    for (char[] row : arr) {
      Arrays.fill(row, '.');
    }

    for (Point p : points) {
      // 2차원 배열에 별 찍기

      int x = (int) (p.x - minimum.x);
      int y = (int) (maximum.y - p.y);
      arr[y][x] = '*';
    }

    String[] result = new String[arr.length];
    for (int i = 0; i < result.length; i++) {
      result[i] = new String(arr[i]);
    }

    return result;
  }

  public static void show(String title, String[] results) {
    System.out.printf(" ********** %s start **********\n\n", title);
    // 배열을 출력합니다.
    for (int i = 0; i < results.length; i++) {
      System.out.println(results[i]);
    }

    System.out.printf("\n\n");
  }

  public static void main(String[] args) {
    int[][] case1 = {
        { 2, -1, 4 },
        { -2, -1, 4 },
        { 0, -1, 1 },
        { 5, -8, -12 },
        { 5, 8, 12 }
    };
    show("case1", solution(case1));

    int[][] case2 = { { 0, 1, -1 }, { 1, 0, -1 }, { 1, 0, 1 } };
    show("case2", solution(case2));

    int[][] case3 = { { 1, -1, 0 }, { 2, -1, 0 } };
    show("case3", solution(case3));

    int[][] case4 = { { 1, -1, 0 }, { 2, -1, 0 }, { 4, -1, 0 } };
    show("case4", solution(case4));
  }
}
