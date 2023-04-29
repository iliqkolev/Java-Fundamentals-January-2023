package FinalExamRetake_01;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra_02 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String text=scanner.nextLine();
        String regex="(\\|{1}|\\#{1})(?<food>[A-z\\s+]+)(\\1)(?<bestTo>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})(\\1)(?<calories>\\d{1,5})(\\1)";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher1= pattern.matcher(text);
        Matcher matcher2= pattern.matcher(text);
        int day=0;

        while (matcher1.find()){
            int current=Integer.parseInt(matcher1.group("calories"));
            day += current;
        }

        System.out.printf("You have food to last you for: %d days!\n",day /2000);

        while (matcher2.find())
        {
            System.out.printf("Item: %s, Best before: %s, Nutrition: %s\n", matcher2.group("food"),
                    matcher2.group("bestTo"), matcher2.group("calories"));

        }
    }
}
