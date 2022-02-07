package source.hackerrank.tutorial;

import java.util.Scanner;

// Referenced : https://www.hackerrank.com/challenges/30-running-time-and-complexity/editorial
public class D25_RunningTimeAndComplexity {
    private static void printStats(int count, int n, boolean isPrime){
        String caller = Thread.currentThread().getStackTrace()[2].getMethodName();
        System.err.println( caller + " performed " + count + " checks, determined " + n
        + ( (isPrime) ? " is PRIME." : " is NOT PRIME." ) );
    }
    
    public static boolean primeCheck(int n) {
        int count = 0;
        // check lower boundaries on primality
        if( n == 2 ){ 
            printStats(++count, n, true);
            return true;
        } // 1 is not prime, even numbers > 2 are not prime
        else if( n == 1 || (n & 1) == 0){
            printStats(++count, n, false);
            return false;
        }

        // Check for primality using odd numbers from 3 to sqrt(n)
        for(int i = 3; i <= Math.sqrt(n); i += 2){
            count++;
            // n is not prime if it is evenly divisible by some 'i' in this range
            if( n % i == 0 ){ 
                printStats(++count, n, false);
                return false;
            }
        }
        // n is prime
        printStats(++count, n, true);
        return true;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        
        int a[] = new int[n];
        for(int i=0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        scanner.close();
        
        for(int i=0; i < n; i++) {
            primeCheck(a[i]);
        }       
    }
}