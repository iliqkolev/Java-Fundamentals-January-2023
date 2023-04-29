import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture_01 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        List<String> furnitureNameList=new ArrayList<>();

        String regex=">>(?<furnitureName>[A-Za-z]+)<<(?<price>[0-9]+\\.?[0-9]*)!(?<quantity>[0-9]+)";
        Pattern pattern=Pattern.compile(regex);

        //">>{furniture name}<<{price}!{quantity}"
        String input=scanner.nextLine();
        double priceSum=0;
        double totalSum=0;

        while (!input.equals("Purchase")){
            //input=">>Sofa<<312.23!3"
            Matcher matcher=pattern.matcher(input);
            //find
            //true-> input отговаря на regex
            //false-> input не отговаря на regex
            if (matcher.find()){
                //input is valid
                String furnitureName= matcher.group("furnitureName");
                double price=Double.parseDouble(matcher.group("price"));
                int quantity=Integer.parseInt(matcher.group("quantity"));

                furnitureNameList.add(furnitureName);
                priceSum=price*quantity;
                totalSum+=priceSum;
            }
            input=scanner.nextLine();
        }
        System.out.println("Bought furniture: ");
        furnitureNameList.forEach(System.out::println);

        System.out.printf("Total money spend: %.2f",totalSum);

    }
}
