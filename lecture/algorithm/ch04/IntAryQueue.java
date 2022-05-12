import java.util.Scanner;

public class IntAryQueue {
  private int max;
  private int num;
  private int[] queue;

  // 실행 시 예외 : 큐가 비어 있음
  public class EmptyIntAryQueueException extends RuntimeException {
    public EmptyIntAryQueueException() {}
  }

  // 실행 시 예외 : 큐가 가득 참
  public class OverflowIntAryQueueException extends RuntimeException {
    public OverflowIntAryQueueException() {}
  }

  // 생성자
  public IntAryQueue(int capacity) {
    num = 0;
    max = capacity;

    try {
      queue = new int[max];
    } catch (OutOfMemoryError e) {
      max = 0;
    }
  }

  public int push(int x) throws OverflowIntAryQueueException {
    if (num >= max) {
      throw new OverflowIntAryQueueException();
    }

    return queue[num++] = x;
  }

  // 큐에서 데이터를 팝(정상에 있는 데이터를 꺼냄)
  public int pop() throws EmptyIntAryQueueException {
    if (num <= 0) {
      throw new EmptyIntAryQueueException();
    }

    int result = queue[0];
    --num;

    for(int i=0; i<queue.length-1; i++) {
      queue[i] = queue[i+1];
    }


    return result;
  }

  // 큐에서 데이터를 피크(정상에 있는 데이터를 들여다봄)
  public int peek() throws EmptyIntAryQueueException {
    if (num <= 0) {
      throw new EmptyIntAryQueueException();
    }

    return queue[num - 1];
  }

	// 큐에서 x를 찾아 인덱스(없으면 –1)를 반환 
	public int indexOf(int x) {
		for (int i = num - 1; i >= 0; i--)				// 정상 쪽에서 선형 검색
			if (queue[i] == x)
				return i;								// 검색 성공
		return -1;										// 검색 실패
	}

  // 큐의 용량을 반환
	public int capacity() {
		return max;
	}

	// 큐에 쌓여 있는 데이터 수를 반환
	public int size() {
		return num;
	}

  // 큐가 비어있는지
  public boolean isEmpty() {
    return num <= 0;
  }

  // 큐가 가득 찼는지
  public boolean isFull() {
    return num >= max;
  }

  // 큐 안의 모든 데이터를 바닥 → 꼭대기 순서로 출력
	public void dump() {
		if (num <= 0)
			System.out.println("큐가 비어 있습니다.");
		else {
			for (int i = 0; i < num; i++)
				System.out.print(queue[i] + " ");
			System.out.println();
		}
	}

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    IntAryQueue s = new IntAryQueue(10);

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
            s.push(x);
          } catch (IntStack.OverflowIntStackException e) {
            System.out.println("큐가 가득 찼습니다.");
          }

          break;
        
        case 2:
          try {
            x = s.pop();
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
