import java.util.Scanner;

public class Digits {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int no;

    System.out.println("2자리의 정수를 입력해주세요.");

    do {
      System.out.print("입력 : ");
      no = scan.nextInt();
      // } while (no < 10 || no > 99); // 계속 조건
    } while (!(no >= 10 && no <= 99)); // 종료 조건

    System.out.printf("변수 no의 값은 %d 가(이) 되었습니다.\n", no);
    scan.close();
  }
}
