package FinalExam_05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector_02 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String text=scanner.nextLine();
        long coolThreshold=1;

        for (char symbol: text.toCharArray()) {
            if (Character.isDigit(symbol)) {
                int number = Integer.parseInt(symbol + "");
                coolThreshold *= number;
            }
        }
        System.out.println("Cool threshold: " + coolThreshold);

        String regex="([:]{2}|[*]{2})(?<emoji>[A-Z][a-z]{2,})(\\1)";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher= pattern.matcher(text);

        int countValidEmojis=0;
        List<String> coolEmojis=new ArrayList<>();

        while (matcher.find()){
        countValidEmojis++;

        int coolLevelCurrentEmojis=0;
        String emoji= matcher.group("emoji");
        for (char symbol: emoji.toCharArray()){
            coolLevelCurrentEmojis += symbol;
        }

        if (coolLevelCurrentEmojis > coolThreshold){
            coolEmojis.add(matcher.group());
            }
        }

        System.out.printf("%d emojis found in the text. The cool ones are:%n", countValidEmojis);
        coolEmojis.forEach(System.out::println);

    }
}
