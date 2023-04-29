import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords_02 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String text=scanner.nextLine();
        String regex="(@|#)(?<first>[A-Za-z]{3,})\\1\\1(?<second>[A-Za-z]{3,})\\1";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher= pattern.matcher(text);

        //списък с валидни двойки думи
        List<String> validPairs=new ArrayList<>();
        int countAllPairs=0;

        while (matcher.find()){
            String firstWord= matcher.group("first");
            String secondWord=matcher.group("second");
            countAllPairs++; //броя всяка намерена двойка думи
            //първата дума = втората дума обърната наобратно
            String secondWordReversed=new StringBuilder(secondWord).reverse().toString();

            if (firstWord.equals(secondWordReversed)){
                //валидна двойка: {първа дума} <=> {втора дума}
                validPairs.add(firstWord + " <=> " + secondWord);
            }
        }

        //ако нямаме намерени двойки думи
        if (countAllPairs == 0){
            System.out.println("No word pairs found!");
        }else{
            System.out.println(countAllPairs + " word pairs found!");
        }

        //отпечатваме само ВАЛИДНИТЕ ДВОЙКИ ДУМИ
        if (validPairs.size() == 0){
            //нямаме валидни двойки
            System.out.println("No mirror words!");
        }else{
            //имаме валидни двойки
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", validPairs));
        }
    }
}
