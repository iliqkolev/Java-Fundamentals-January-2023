import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       /*int n=Integer.parseInt(scanner.nextLine());
        int sum=0;
        while (n > 0){
            int lastDigit=n % 10;
            sum += lastDigit;
            n=n /10;
        }
        System.out.println(sum);
    }
    */
        String name = scanner.nextLine();
        System.out.println(name.toLowerCase().toCharArray());
    }
}
