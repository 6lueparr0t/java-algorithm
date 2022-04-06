package lecture.algorithm.ch02;

import java.util.Scanner;

public class DayOfYear {

  // 각 달의 일수
  static int[][] mdays = {
    {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
    {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
  };

  // 서기 year 년은 윤년인가? (윤년 : 1 / 평년 : 0)
  static int isLeap(int year) {
    return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
  }

  // 서기 y년 m월 d일의 그 해 경과 일 수를 구함
  static int dayOfYear(int y, int m, int d) {
    m = m-1;
    while(m > 0) {
      d += mdays[isLeap(y)][m-- - 1];
    }

    return d;
  }

  static int leftDayOfYear(int y, int m, int d) {
    m = m-1;
    while(m > 0) {
      d += mdays[isLeap(y)][m-- - 1];
    }

    return (365+isLeap(y))-d;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int retry;

    System.out.println("그 해 경과 일수를 구합니다.");

    do {
      System.out.print("연도 : "); int year = scan.nextInt();
      System.out.print("월 : "); int month = scan.nextInt();
      System.out.print("일 : "); int day = scan.nextInt();

      System.out.printf("그 해 %d일째 입니다.\n", dayOfYear(year, month, day));
      System.out.printf("그 해 남은 일 수는 %d일 입니다.\n", leftDayOfYear(year, month, day));

      System.out.print("한 번 더 할까요? (1. 예 / 0. 아니오) : ");
      retry = scan.nextInt();
    } while (retry == 1);

    scan.close();
  }
}
