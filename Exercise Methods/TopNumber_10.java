import java.util.Scanner;

public class TopNumber_10 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());

        for (int number = 1; number <= n ; number++) {



            if (isSumoFDigitsIsDivisibleBy8(number) && isContainsOddDigit(number)){
                System.out.println(number);
            }
        }


    }
    public static boolean isSumoFDigitsIsDivisibleBy8 (int number){
        int sum=0;
        while (number > 0){
            int lastDigit=number % 10;
            sum+=lastDigit;
            number=number / 10;
        }
        if (sum % 8 == 0){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isContainsOddDigit (int number){
        //5674
        while ( number > 0){
            int lastDigit=number% 10;
            if (lastDigit % 2 != 0){
                //четна цифра -> поне една нечетна
                    return true;
            }else{
                //четна цифра -> премахваме
                number /= 10;
            }
        }
        return false;
    }
}
