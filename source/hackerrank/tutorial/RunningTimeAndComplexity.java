package source.hackerrank.tutorial;

import java.util.Scanner;

// Referenced : https://myjamong.tistory.com/139
// https://www.hackerrank.com/challenges/30-running-time-and-complexity/editorial
public class RunningTimeAndComplexity {
    public static Boolean primeCheck(int num) {
        if (num == 1) return false;
        
        for (int i=2; i*i<=num; i++) {
            if(num % i == 0) return false;
        }

        return true;
    }
    
    public static void main(String[] args) {
        try (/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in)) {
            int cnt = sc.nextInt();
            
            int a[] = new int[cnt];
            
            for(int i=0; i<cnt; i++){
                a[i] = sc.nextInt();
            }
            
            for (int i = 0; i < cnt; i++) {
                System.out.printf("%s\n", primeCheck(a[i])?"Prime":"Not prime");
            }
        }
    }
}