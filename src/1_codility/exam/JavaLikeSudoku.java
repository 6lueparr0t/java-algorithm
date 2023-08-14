package exam;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class JavaLikeSudoku {
    public String solution(int U, int L, int[] C) {
        // write your code in Java SE 8
        int len = C.length;
        int[] r1 = new int[len];
        int[] r2 = new int[len];

        int count = 0;
        for (int i=0; i< len; i++) {
            if (C[i] == 2) {
                r1[i] = r2[i] = 1;
                U--;
                L--;
            } else if (C[i] == 1) {
                count++;
            }
        }

        if (U<0 || L<0 || count != U+L) return "IMPOSSIBLE";

        int index = 0;
        while (U + L > 0) {
            while (U > 0) {
                if (C[index] == 1) {
                    r1[index] = 1;
                    U--;
                }
                index++;
            }

            while (L > 0) {
                if (C[index] == 1) {
                    r2[index] = 1;
                    L--;
                }

                index++;
            }
        }

        String result = "";
        
        for (int i : r1) {
            result += i;
        }
        
        result += ",";
        
        for (int i : r2) {
            result += i;
        }

        return result;
    }
}
