import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EncryptingPassword_02 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());
        String regex="(\\S+)\\>(?<numbers>\\d{3})\\|(?<lowerL>[a-z]{3})\\|(?<upperL>[A-Z]{3})\\|(?<symbols>[^><]{3})\\<(\\S+)";
        Pattern pattern=Pattern.compile(regex);

        for (int i = 0; i < n ; i++) {
            String password=scanner.nextLine();
            Matcher matcher= pattern.matcher(password);

            if (matcher.find()){
                System.out.println("Password: " + matcher.group("numbers") + matcher.group("lowerL")
                        + matcher.group("upperL") + matcher.group("symbols"));
            } else{
                System.out.println("Try another password!");
            }


        }
    }
}
