public class HelloWorld {
    public static void main(String[] args) {
        String test = "Test";
        for (int i=2; i <= 9; i++) {
            System.out.println(test + "=========="+i+"단 ==========");

            for (int j=1; j <= 9; j++) {
                System.out.println(i + " * " + j + " = " + j*i);
            }

            System.out.println("====================");
        }
    }
}