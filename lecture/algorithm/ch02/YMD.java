import java.util.Scanner;

public class YMD {
  int y; // 년
  int m; // 월 (1 ~ 12)
  int d; // 일 (1 ~ 31)

  // 각 달의 일수
  int[][] mdays = {
      { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },
      { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }
  };

  YMD(int y, int m, int d) {
    this.y = y;
    this.m = m;
    this.d = d;
  }

  static int isLeap(int year) {
    return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
  }

  YMD after(int n) {
    YMD nYmd = new YMD(this.y, this.m, this.d);

    if (n >= 365) {
      n = n % 365;
      nYmd.y++;
    }

    nYmd.d += n;
    int isLeap = isLeap(nYmd.y);

    while (nYmd.d >= mdays[isLeap][nYmd.m - 1]) {
      nYmd.d = nYmd.d - mdays[isLeap][(nYmd.m - 1)];
      nYmd.m++;
    }

    return nYmd;
  }

  YMD before(int n) {
    YMD nYmd = new YMD(this.y, this.m, this.d);

    if (n >= 365) {
      n = n % 365;
      nYmd.y--;
    }

    nYmd.d -= n;
    int isLeap = isLeap(nYmd.y);

    while (nYmd.d < 1) {
      nYmd.m--;
      if (nYmd.m < 1) {
        nYmd.y--;
        nYmd.m = 12;
      }

      nYmd.d = nYmd.d + mdays[isLeap][(nYmd.m - 1)];
    }

    return nYmd;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.print("날짜를 입력하세요.\n");
    System.out.print("년：");
    int y = scan.nextInt();
    System.out.print("월：");
    int m = scan.nextInt();
    System.out.print("일：");
    int d = scan.nextInt();
    YMD date = new YMD(y, m, d);

    System.out.print("몇 일 앞/뒤의 날짜를 구할까요?：");
    int n = scan.nextInt();

    YMD d1 = date.after(n);
    System.out.printf("%d일 뒤의 날짜는 %d년 %d월 %d일입니다.\n", n, d1.y, d1.m, d1.d);

    YMD d2 = date.before(n);
    System.out.printf("%d일 앞의 날짜는 %d년 %d월 %d일입니다.\n", n, d2.y, d2.m, d2.d);

    scan.close();
  }
}
