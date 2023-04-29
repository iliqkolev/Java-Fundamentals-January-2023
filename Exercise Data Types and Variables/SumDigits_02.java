import java.util.Scanner;

public class SumDigits_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        while (num > 0) {
            //1.Взимаме последна цифра
            int lastDigit = num % 10;
            //2.Събираме последната цифра
            sum +=lastDigit;
            //3.Премахвам взетата цифра от числото
            num /= 10;
        }
        System.out.println(sum);

    }
}
