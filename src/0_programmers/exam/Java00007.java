// 숫자게임 (B 가 이기는 횟수 찾기)
import java.util.Arrays;

public class Java00007 {
  class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A); //1 3 5 7
        Arrays.sort(B); //2 2 6 8

        int score = 0;
        int idxA = 0;
        int idxB = 0;

        for(int i=0; i<A.length; i++) {
            if(A[idxA] < B[idxB]) {
                idxA++;
                score++;
            }
            
            idxB++;
        }

        return score;
    }
}
}
