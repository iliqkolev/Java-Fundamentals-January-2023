package FinalExamRetake_03;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords_02 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String text=scanner.nextLine();
        String regex="(@|#)(?<first>[A-Za-z]{3,})(\\1)(\\1)(?<second>[A-Za-z]{3,})(\\1)";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher= pattern.matcher(text);

        int countAllPairs=0;
        List<String> validPairs=new ArrayList<>();

        while (matcher.find()){
            String first= matcher.group("first");
            String second= matcher.group("second");
            String secondWordReversed= new StringBuilder(second).reverse().toString();
            countAllPairs++;

            if (first.equals(secondWordReversed)){
                validPairs.add(first + " <=> " + second);
            }
        }
        if (countAllPairs == 0){
            System.out.println("No word pairs found!");
        }else{
            System.out.println(countAllPairs + " word pairs found!");
        }

        if (validPairs.size() == 0){
            System.out.println("No mirror words!");
        }else{
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", validPairs));
        }
    }
}
