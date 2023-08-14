package exam;

// you can also use imports, for example:
import java.util.*;

// binarySearch 활용

class Solution {
    public static int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int key = 0;
        for(int i=0; i<A.length; i++) {
            key = -A[i];
            int idx = Arrays.binarySearch(A, key);

            if (idx > 0) {
                return key;
            }
        }

        return 0;
    }
}
