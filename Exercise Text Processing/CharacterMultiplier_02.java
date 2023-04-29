import java.util.Map;
import java.util.Scanner;

public class CharacterMultiplier_02 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String[] names=scanner.nextLine().split("\\s+");
        int sum=0;
        String firstText=names[0];
        String secondText=names[1];

        int minLength= Math.min(firstText.length(), secondText.length());
        int maxLength= Math.max(firstText.length(), secondText.length());

        for (int index = 0; index < minLength; index++) {
            sum += firstText.charAt(index) * secondText.charAt(index);
        }
        //еднакви дължинни на текстовете
        if (maxLength == minLength){
            System.out.println(sum);
            return;
        }
        //кой е по дългия текст -> останалите букви които не са участвали в умножението
        if (maxLength == firstText.length()){
            //първия текст ми е по-дълъг -> взимам останалите символи
            for (int index = minLength; index < firstText.length() ; index++) {
                sum += firstText.charAt(index);
            }
        }else {
            //втория текст да ни е по дълъг -> взимам останалите символи
            for (int index = minLength; index < secondText.length(); index++) {
                sum += secondText.charAt(index);
            }
        }

        System.out.println(sum);

    }
}
