import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber_02 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String phones=scanner.nextLine();

        //+359-2-222-2222 or +359 2 222 2222
        String regex="\\+359([ -])2\\1[\\d]{3}\\1[\\d]{4}\\b";

        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(phones);

        List<String> numbersList=new ArrayList<>();

        while (matcher.find()){
            String validPhone= matcher.group();
            numbersList.add(validPhone);
        }

        System.out.println(String.join(", ",numbersList));
    }
}
