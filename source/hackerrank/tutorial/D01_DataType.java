import java.util.Scanner;

public class D01_DataType {
	
    public static void main(String[] args) {
        // int i = 4;
        // double d = 4.0;
        String s = "HackerRank ";
		
        Scanner scan = new Scanner(System.in);

        /* Declare second integer, double, and String variables. */
        /* Read and save an integer, double, and String to your variables.*/
        // Note: If you have trouble reading the entire String, please go back and review the Tutorial closely.
        int i2 = scan.nextInt();
        double d2 = scan.nextDouble();
        scan.nextLine();
        String s2 = scan.nextLine();
        
        /* Print the sum of both integer variables on a new line. */
        System.out.printf("%d\n", i2+(int)4);

        /* Print the sum of the double variables on a new line. */
        System.out.printf("%.1f\n", d2+4);
		
        /* Concatenate and print the String variables on a new line; 
        	the 's' variable above should be printed first. */
        System.out.printf("%s%s", s, s2);

        scan.close();
    }
}
