package exam;

import java.util.Arrays;

// woowa 문제
public class FixCode2 {
  public static int solution(int[] A, int[] B) {
    /* 원본 코드
      int n = A.length;
      int m = B.length;;

      Arrays.sort(A);
      Arrays.sort(B);

      int i = 0;
      for (int k=0; k<n; k++) {
        if(i<m-1 && B[i] < A[k])
          i+=1;
        if(A[k] == B[i])
          return A[k];

        System.out.printf("%d 번째 : %d %d\n", i, B[i], A[k]);
      }

      return -1;
     */

      // 해당 라인 추가
      if(A.length<B.length) {int[] tmp = A; A=B; B=tmp;}
      int n = A.length;
      int m = B.length;;

      Arrays.sort(A);
      Arrays.sort(B);

      int i = 0;
      for (int k=0; k<n; k++) {
        // -1 제거
        if(i<m && B[i] < A[k])
          i+=1;
        if(A[k] == B[i])
          return A[k];

        System.out.printf("%d 번째 : %d %d\n", k, B[i], A[k]);
      }

      return -1;
  }
  public static void main(String[] args) {
      int[] A = {99,98,97,96,95,94,93,14};
      int[] B = {14,15,13,12,11,10,9,8,7,6,5,4,3,2,1};

      System.out.println(solution(A, B));
  }    
}