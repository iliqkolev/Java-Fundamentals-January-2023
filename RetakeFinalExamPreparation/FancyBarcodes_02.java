package FinalExam_04;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes_02 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());
        String regex="@#+(?<name>[A-Z][A-Za-z0-9]{4,}[A-Z])@#+";
        Pattern pattern=Pattern.compile(regex);
        for (int i = 1; i <=n ; i++) {
            String text=scanner.nextLine();
            Matcher matcher= pattern.matcher(text);

            if (matcher.find()){
                String name= matcher.group("name");
                String digits="";

                for (char symbol: name.toCharArray()){
                    if (Character.isDigit(symbol)){
                        digits += symbol;
                    }
                }
                if (digits.length() == 0){
                    digits = "00";
                }
                System.out.println("Product group: " + digits);
            }else{
                System.out.println("Invalid barcode");
            }
        }
    }
}
