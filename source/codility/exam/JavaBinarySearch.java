package exam;

// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int key = 0;
        for(int i=0; i<A.length; i++) {
            key = -A[i];
            int idx = Arrays.binarySearch(A, key);

            if (idx < 0) {
                break;
            } else {
                return key;
            }
        }

        return 0;
    }
}
