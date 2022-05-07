import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/domains/tutorials/10-days-of-statistics
 * 
 * Day 0
 * 
 * 평균, 중앙값, 모드(?) 찾기 
 * 
 * 1. 평균
 * - 말 그대로 평균
 * 
 * 2. 중앙값
 * - 받은 값 리스트 중에 중앙에 있는 값
 * 
 * ex) 1 2 3 4 5 중에서는 3
 * ex) 1 2 3 4 5 6 중에서는 (3+4)/2 = 3.5
 * 
 * 3. 모드
 * - 빈도 수가 가장 많은 수
 * ex) 1 2 3 4 5 중에서는 1 (없으면 가장 작은 수)
 * ex) 1 2 3 3 5 6 중에서는 3
 * 
 */
public class MeanMedianMode {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int cnt = scan.nextInt();
        int numList[] = new int[cnt];
        
        for(int i=0; i<cnt; i++){
            numList[i] = scan.nextInt();
        }
        
        scan.close();
        
        System.out.format("%.1f\n", mean(numList, cnt));
        System.out.format("%.1f\n",median(numList, cnt));
        System.out.println(mode(numList, cnt));
    }
    
    public static double mean(int numList[], int cnt){
        double sum = 0;
        
        for(int i=0; i<cnt; i++) {
            sum += numList[i];
        }
        
        double result = sum / (long) cnt;
        
        return result;
    }

    public static double median(int numList[], int cnt){
        Arrays.sort(numList);
        int center = cnt / 2;
        
        double result;
        if(cnt % 2 == 0) {
            result = ((double) numList[center] + (double) numList[center-1]) / 2;
        } else {
            result = (double) numList[center];
        }
        
        return result;
    }

    public static int mode(int X[], int cnt){
        int mode=0, max=0;
        int temp, count;
        
        Arrays.sort(X);
        
        for(int i=0; i<cnt; i++) {
            temp=X[i];
            count=0;
            
            for(int j=0; j<cnt; j++) {
                if(temp==X[j]) {
                    count++;
                }
                
                if(count>max) {
                    max=count;
                    if(max==1) {
                        mode=X[0];
                    }
                    mode=temp;
                }
            }           
        }
        return mode;
    }
}