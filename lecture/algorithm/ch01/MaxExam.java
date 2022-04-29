public class MaxExam {
    public static int max4(int a, int b, int c, int d) {
        int max = a;
        if(max < b) max = b;
        if(max < c) max = c;
        if(max < d) max = d;
        return max;
    }

    public static int min(int a, int b, int c) {
        int min = a;
        if(min > b) min = b;
        if(min > c) min = c;
        return min;
    }

    public static int min4(int a, int b, int c, int d) {
        int min = c;
        if(min > b) min = b;
        if(min > c) min = c;
        if(min > d) min = d;
        return min;
    }

    public static void main(String[] args) {
        System.out.println(max4(6,2,1,10));
        System.out.println(min(2,1,10));
        System.out.println(min4(6,2,1,10));
    }
}
