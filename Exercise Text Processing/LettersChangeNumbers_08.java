import java.util.Scanner;

public class LettersChangeNumbers_08 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String[] codes=scanner.nextLine().split("\\s+");
        double totalSum=0;

        for (String word: codes){
             double modifiedNumber = getModifiedNumber(word);
             totalSum += modifiedNumber;
        }
        System.out.printf("%.2f",totalSum);
    }
    private static double getModifiedNumber(String code){
        //"A12b"
        char letterBeforeNum=code.charAt(0); // 'A'
        char letterAfterNum=code.charAt(code.length() - 1); // 'b'
        double number=Double.parseDouble(code.replace(letterBeforeNum,' ') // "A12b" -> "12b"
                       .replace(letterAfterNum, ' ') // " 12 "
                       .trim()); // "12" -> 12

        //проверка за буквата преди -> letterBeforeNum
        if (Character.isUpperCase(letterBeforeNum)){
            //главна буква -> 65 до 90
            int positionUpperLetter=(int) letterBeforeNum - 64;
             number /=  positionUpperLetter;
        } else {
            //малка буква -> 97 до 122
            int positionLowerLetter=(int) letterBeforeNum - 96;
            number *= positionLowerLetter;
        }

        //проверка за буквата след -> letterAfterNum
        if (Character.isUpperCase(letterAfterNum)){
            //главна буква -> 65 до 90
            int positionUpperLetter=(int) letterAfterNum - 64;
            number -=  positionUpperLetter;
        } else {
            //малка буква -> 97 до 122
            int positionLowerLetter=(int) letterAfterNum - 96;
            number +=  positionLowerLetter;
        }
        return number;
    }
}
