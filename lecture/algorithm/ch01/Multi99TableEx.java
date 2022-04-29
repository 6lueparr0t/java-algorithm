public class Multi99TableEx {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.print((i==0)?" ":i);
            System.out.printf(" | ");
            for (int j = 1; j < 10; j++) {

                System.out.printf("%3d ", (i==0)?j:i+j);
            }
            if (i == 0) {
                System.out.printf("\n--+---------------------------------------");
            }
            System.out.printf("\n");
        }
    }
}
