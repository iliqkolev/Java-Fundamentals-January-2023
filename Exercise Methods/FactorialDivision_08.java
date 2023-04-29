import java.util.Scanner;

public class FactorialDivision_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());

        long fact1=calculateFactorial(num1);
        long fact2=calculateFactorial(num2);

        double result=fact1* 1.0 / fact2;
        System.out.printf("%.2f",result);

    }

    public static long calculateFactorial (int number) {
        //number = 5
        // 5!= 1 * 2 * 3 * 4 * 5
        long fact=1;
        for (int i = 1; i <= number; i++) {
                fact=fact*i;
        }
            return fact;
    }
}
