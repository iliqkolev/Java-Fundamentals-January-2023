import java.util.*;
import java.util.stream.Collectors;

public class exercise_3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        List<String> text = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());
        String command=scanner.nextLine();

        while (!command.equals("Shop!")){
            String [] tokens=command.split("%");

            if (tokens[0].contains("Important")){
                String product=tokens[1];
                if (text.contains(product)){
                    text.remove(product);
                    text.add(0,product);
                }else{
                    text.add(0,product);
                }
            }else if (tokens[0].contains("Add")){
                //add it at the end of the list
                String product=tokens[1];
                if (!text.contains(product)){
                    text.add(product);
                }else{
                    System.out.println("The product is already in the list.");
                }
            }else if (tokens[0].contains("Swap")){
                String product=tokens[1];
                String secondProduct=tokens[2];
                //if both products exist -> SWAP THEIR PLACES
                if (text.contains(product) && text.contains(secondProduct)){
                    int index1=text.indexOf(product);
                    int index2=text.indexOf(secondProduct);
                    text.set(index1, secondProduct);
                    text.set(index2, product);
                }else if(!text.contains(product)){
                    System.out.printf("Product %s missing!\n", product);
                }else if (!text.contains(secondProduct)){
                    System.out.printf("Product %s missing!\n", secondProduct);
                }

            }else if (tokens[0].contains("Remove")){
                String product=tokens[1];
                if (text.contains(product)){
                    text.remove(product);
                }else{
                    System.out.printf("Product %s isn't in the list", product);
                }
            }else if (tokens[0].equals("Reversed")){
                Collections.reverse(text);
            }

            command=scanner.nextLine();
        }

        for (int i = 0; i < text.size(); i++) {
            System.out.println(i + 1 + ". " + text.get(i));
        }
        System.out.println();
    }
}
