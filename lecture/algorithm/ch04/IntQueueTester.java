import java.util.Scanner;

public class IntQueueTester {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    IntQueue s = new IntQueue(64);

    while (true) {
      System.out.println("현재 데이터 수 : " + s.size() + " / " + s.capacity());

      System.out.print("(1)푸시 (2)팝 (3)피크 (4)덤프 (0)종료 : ");

      int menu = scan.nextInt();
      if (menu == 0)
        break;

      int x;
      switch (menu) {
        case 1:
          System.out.print("데이터 : ");
          x = scan.nextInt();
          try {
            s.enque(x);
          } catch (IntStack.OverflowIntStackException e) {
            System.out.println("큐가 가득 찼습니다.");
          }

          break;
        
        case 2:
          try {
            x = s.deque();
            System.out.println("pop한 데이터는 " + x + " 입니다.");
          } catch (IntStack.EmptyIntStackException e) {
            System.out.println("큐가 비어 있습니다.");
          }
          break;
        case 3:
          try {
            x = s.peek();
            System.out.println("peek 데이터는 " + x + " 입니다.");
          } catch (IntStack.EmptyIntStackException e) {
            System.out.println("큐가 비어 있습니다.");
          }
          break;
        case 4:
          s.dump();
          break;
      }

    }
    scan.close();
  }
}
