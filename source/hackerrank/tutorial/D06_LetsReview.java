import java.util.Scanner;

public class D06_LetsReview {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        
        int num = scan.nextInt();
        
        String[] strList = new String[num];
        scan.nextLine();
        for(int i = 0; i < num; i++) {
            strList[i] = scan.nextLine();
        }
        
        for(int i = 0; i < num; i++) {
            char[] charArray = strList[i].toCharArray();
            for(int j = 0; j < 2; j++) {
                for(int k = j; k < strList[i].length(); k=k+2) {
                    System.out.printf("%c", charArray[k]);
                }
                System.out.printf(" ");
            }
            System.out.println("");
        }
        
        scan.close();
    }
}
