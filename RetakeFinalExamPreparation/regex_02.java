package FinalRetake;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex_02 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int inputsCount=Integer.parseInt(scanner.nextLine());
        String regex="([U][$])(?<name>[A-Z][a-z]{2,})([U][$])([P][@][$])(?<password>[a-zA-z]{5,}[0-9]{1,})([P][@][$])";
        Pattern pattern = Pattern.compile(regex);
        int validCount=0;


        for (int i = 1; i <= inputsCount; i++) {
            String text=scanner.nextLine();
            Matcher matcher= pattern.matcher(text);

            if (matcher.find()){
                validCount++;
                String name= matcher.group("name");
                String password= matcher.group("password");


                System.out.println("Registration was successful");
                System.out.printf("Username: %s, Password: %s\n", name,password);

            }else{
                System.out.println("Invalid username or password");
            }
        }

        System.out.printf("Successful registrations: %d\n", validCount);

    }
}
