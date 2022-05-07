package exam;
public class SmallestNumber {
    public static int sum(int num) {
        int sum = 0;

        while(num != 0) {
            sum = sum + num % 10;
            num = num / 10;
        }

        return sum;
    }

    static void smallestNumber(int N)
    {
        int answer = 0;

        int first = sum(N);
        while(true) {
            if(first == sum(answer) && answer > N) break;
            answer++;
        }

        System.out.println(answer);
    }
    
    public static void main(String[] args)
    {
        // 28=37, 734=743, 1990=2089, 1000=10000
        int N = 1000;
        smallestNumber(N);
    }
}
