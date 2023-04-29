import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders_03 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String data=scanner.nextLine();
        Map<String,Integer> productsQuantity=new LinkedHashMap<>(); //product -> quantity
        Map<String,Double> productsPrice=new LinkedHashMap<>(); //product -> price

        while (!data.equals("buy")){
            String product=data.split("\\s+")[0];
            double price=Double.parseDouble(data.split("\\s+")[1]);
            int quantity=Integer.parseInt(data.split("\\s+")[2]);

            if (!productsQuantity.containsKey(product)){
                productsQuantity.put(product, quantity);
            }else{
                int currentQuantity=productsQuantity.get(product);
                productsQuantity.put(product, currentQuantity + quantity);
            }

            //за цена -> всеки път да добавяме срещу продукта въведената
            productsPrice.put(product, price);

            data=scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry: productsQuantity.entrySet()){
            String productName= entry.getKey();
            double sum = productsQuantity.get(productName) * productsPrice.get(productName);

            System.out.printf("%s -> %.2f\n",productName,sum);
        }
    }
}
