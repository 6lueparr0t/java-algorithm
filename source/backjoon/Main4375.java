package source.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main4375 {

    static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while((str = br.readLine()) != null) {
            int N = stoi(str);
            int cnt = 1;
            int tmp = 1;
            
            while(true) {
                // 모든 자리수가 1인 n의 배수가 항상 만들어짐
                if(tmp % N == 0) {
                    break;
                }
                
                cnt++;
                //1을 만들어서 왼쪽으로 shift 하기
                tmp = (tmp * 10 + 1) % N;
            }
            
            print(cnt);
        }
        
        br.close();
    }
    
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    static int stoi(String s) { return Integer.parseInt(s); }
    static long stol(String s) { return Long.parseLong(s); }
    static String itos(int opih) { return Integer.toString(opih); }
    static String itos(Integer opih) { return opih.toString(); }
    static void print(String s) { System.out.println(s); }
    static void print(int opih) { System.out.println(opih); }
    static void print(long opih) { System.out.println(opih); }    
    static void print(char opih) { System.out.println(opih); }    
    static void print(StringBuilder sb) { System.out.println(sb.toString()); }
    static void print() { System.out.println(); }
}