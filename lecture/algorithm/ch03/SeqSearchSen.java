package lecture.algorithm.ch03;

import java.util.Scanner;

public class SeqSearchSen {
  static int seqSearchSen(int[] a, int n, int key) {
    int i=0;

    a[n] = key;

    while(true) {
      if(a[i]==key) break;
      i++;
    }

    return i==n?-1:i;
  }
  
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.print("개수? : ");
    int num = scan.nextInt();
    int[] x = new int[num+1];

    for  (int i=0; i<num; i++) {
      System.out.printf("x[%d] :", i);
      x[i] = scan.nextInt();
    }

    System.out.print("검색할 값: ");
    int key = scan.nextInt();

    int idx = seqSearchSen(x, num, key);

    if (idx == -1) {
      System.out.println("결과를 찾지 못했습니다.");
    } else {
      System.out.printf("%d ==> x[%d]:%d", key, idx, x[idx]);
    }

    scan.close();
  }
}
