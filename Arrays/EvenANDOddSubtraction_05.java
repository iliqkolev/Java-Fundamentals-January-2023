import java.util.Arrays;
import java.util.Scanner;

public class EvenANDOddSubtraction_05 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int [] numbersArr= Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sumEven=0;
        int sumOdd=0;

        for (int item:numbersArr) {
            if (item % 2 == 0){
                sumEven+=item;
            }else {
                sumOdd += item;
            }
        }
        System.out.println(sumEven-sumOdd);
    }
}
