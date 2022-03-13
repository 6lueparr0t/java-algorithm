package source.codility;

public class FixCode {
    public static boolean solution(int[] A, int K) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] > A[i+1])
                return false;
        }
        if (A[0] != 1 || A[n-1] != K)
            return false;
        else
            return true;
    }
    public static void main(String[] args) {
        int[] A = {1,1,2,3,3};
        int K = 3;

        System.out.println(solution(A, K)); //true

        int[] A2 = {1,1,3};
        int K2 = 2;

        System.out.println(solution(A2, K2)); //false

        int[] A3 = {1,2,2};
        int K3 = 2;

        System.out.println(solution(A3, K3)); //true

        int[] A4 = {1,2,3};
        int K4 = 2;

        System.out.println(solution(A4, K4)); //false
    }    
}
