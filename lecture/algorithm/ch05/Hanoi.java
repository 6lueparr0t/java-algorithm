import java.util.Scanner;

public class Hanoi {
  // no개의 원반을 x번 기둥에서 y번 기둥으로 옮김
  static void move(int no, int x, int y) {
    if (no>1)  move(no-1, x, 6-x-y);

    System.out.printf("원반[%d]을 %d 기둥에서 %d 기둥으로 옮김\n", no, x, y);

    if (no>1) move(no-1, 6-x-y, y);
  }
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.println("하노이의 탑");

    System.out.print("원반 개수 : ");
    int n = scan.nextInt();

    move(n, 1, 3);

    scan.close();
  }
}
