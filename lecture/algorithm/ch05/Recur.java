import java.util.Scanner;

public class Recur {
  static void recurExam(int n) { // 4
    if (n>0) {
      recurExam(n-2);
      System.out.println(n);
      recurExam(n-1);
    }
  }
/*

     recur(2)                4            recur(3)
  recur(0) 2 recur(1)             recur(1)      3     recur(2)
         recur(-1) 1 recur(0) recur(-1) 1 recur(0) recur(0) 2 recur(1)
                                                                recur(-1) 1 recur(0)

2 1 4 1 3 2 1
*/


  static void recur1(int n) {
    // if (n>0) {
    //   recur1(n-1);
    //   System.out.println(n);
    //   recur1(n-2);
    // }

    while (n>0) {
      recur1(n-1);
      System.out.printf("%d ", n);
      n = n - 2;
    }
  }
  /*
  step1 :
        recur(3) 4
      recur(2) 3
       recur(0) 1
    recur(1) 2
  recur(0) 1

  step2 :
    recur(1) 2
  recur(0) 1
  */

  //재귀 함수
  static void notRecur1(int n) {
    IntStack s = new IntStack(n);

    while (true) {
      if (n>0) {
        s.push(n);
        n = n - 1;
        continue;
      }

      if(s.isEmpty() != true) {
        n = s.pop();
        System.out.printf("%d ", n);
        n = n - 2;
        continue;
      }

      break;
    }
  }

  static void recur2(int n) {
    if (n>0) {
      recur2(n-1);
      recur2(n-2);
      System.out.printf("%d ", n);
    }
  }
  /*
  4
              recur(3) recur(2) 4
  recur(2) recur(1) 3    1 0 2
    1 0 2
                 1 
  1 2 1 3 1 2 4
  */

  static void notRecur2(int n) {
    IntStack numStack = new IntStack(n);
		IntStack swStack = new IntStack(n);
		int sw = 0;

		while (true) {
			if (n > 0) {
				numStack.push(n);
				swStack.push(sw);

				if (sw == 0)
					n = n - 1;
				else if (sw == 1) {
					n = n - 2;
					sw = 0;
				}
				continue;
			}

			while(true) {
				n = numStack.pop();
				sw = swStack.pop() + 1;

				if (sw == 2) {
					System.out.printf("%d ", n);
					if (numStack.isEmpty() == true || swStack.isEmpty() == true) return;
				} else {
          break;
        }
			}
		}
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.print("정수를 입력하세요. : ");
    int x = scan.nextInt();

    recur1(x);
    System.out.println();
    notRecur1(x);
    System.out.println();

    System.out.println();

    recur2(x);
    System.out.println();
    notRecur2(x);
    System.out.println();
    
    scan.close();
  }
}
