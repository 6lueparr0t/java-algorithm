package source.codility;

public class Balloon {
    public static void main(String[] args) {
        String s = "QAWABAWONL";
                // String s = "BAOOLLNNOLOLGBAX";
                char[] balloon = new char[7];
        
                char[] tmp = s.toCharArray();
                int sw = 7;
                int answer = 0;
                
                while(true) {
                    balloon = "BALLOON".toCharArray();
                    for(int i=0; i<tmp.length; i++) {
                        for(int j=0; j<balloon.length; j++) {
                            if(tmp[i] == balloon[j]) {
                                tmp[i] = '.';
                                balloon[j] = ' ';
                                sw--;
                            }
                        }
                    }
        
                    if(sw != 0) {
                        System.out.printf("sw = 0\n");
                        break;
                    }
                    sw = 7;
                    answer++;
                }
        
                for(int i=0; i<tmp.length;i++) System.out.print(tmp[i]);
                System.out.println();
                System.out.println(answer);
    }
}
