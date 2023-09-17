
/**
 * 1. 모든 직선 쌍에 대해 반복
 * - a. 교점 좌표 구하기
 * - b. 정수 좌표만 저장
 * 2. 저장된 정수들에 대해 x, y 좌표의 최댓값, 최솟값 구하기
 * 3. 구한 최댓값, 최솟값을 이용하여 2차원 배열의 크기 결정
 * 4. 2차원 배열에 별 표시
 * 5. 문자열 배열로 변환 후 반환
 *
 * 참고 사항
 * Ax + By + E = 0
 * Cx + Dy + F = 0 인 경우,
 * x = (BF - ED) / (AD - BC), y = (EC - AF) / (AD - BC), AD - BC = 0
 */

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Q01 {
  public static class Point {
    public final long x, y;

    private Point(long x, long y) {
      this.x = x;
      this.y = y;
    }
  }

  public static Point intersection(long a, long b, long e, long c, long d, long f) {
    double x = (double) (b*f - e*d) / (a*d - b*c);
    double y = (double) (e*c - a*f) / (a*d - b*c);

    if (x % 1 != 0 || y % 1 != 0) return null;

    return new Point((long) x, (long) y);
  }

  private static Point getMinimumPoint(List<Point> points) {
    long x = Long.MAX_VALUE;
    long y = Long.MAX_VALUE;

    for (Point p: points) {
      if(p.x<x) x = p.x;
      if(p.y<y) y = p.y;
    }

    return new Point(x, y);
  }

  private static Point getMaximumPoint(List<Point> points) {
    long x = Long.MIN_VALUE;
    long y = Long.MIN_VALUE;

    for (Point p: points) {
      if(p.x>x) x = p.x;
      if(p.y>y) y = p.y;
    }

    return new Point(x, y);
  }

  public static String[] solution(int[][] line) {
    List<Point> points = new ArrayList<>();

    // 0으로 떨어지는 교차점을 구한다.
    for(int i=0; i<line.length; i++) {
      for(int j=1+i; j<line.length; j++) {
        Point interPoint = intersection(
          line[i][0],
          line[i][1],
          line[i][2],

          line[j][0],
          line[j][1],
          line[j][2]
        );

        if(interPoint != null) points.add(interPoint);
      }
    }

    // 가장 크고 작은 점을 구한다.
    Point maxPoint = getMaximumPoint(points);
    Point minPoint = getMinimumPoint(points);

    // 최소 사각형을 구하기 위한 틀
    int width = (int) (maxPoint.x - minPoint.x + 1);
    int height = (int) (maxPoint.y - minPoint.y + 1);

    // . 으로 채운다.
    char[][] arr = new char[height][width];
    for (char[] row : arr) {
      Arrays.fill(row, '.');
    }

    // 교차점을 * 로 바꾼다.
    for (Point p: points) {
      int x = (int) (p.x - minPoint.x);
      int y = (int) (maxPoint.y - p.y);

      arr[y][x] = '*';
    }

    // 결과를 출력한다.
    String[] results = new String[arr.length];
    for(int i=0; i<arr.length; i++) {
      results[i] = new String(arr[i]);
    }

    return results;
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
