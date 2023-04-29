package MidExam_5;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory_03 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        List<String> list= Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String command=scanner.nextLine();

        while (!command.equals("Craft!")){
            String [] tokens=command.split(" - ");
            String input=tokens[0];
            String index=tokens[1];

            switch (input){
                case "Collect":
                    if (!list.contains(index)){
                        list.add(index);
                    }
                    break;

                case "Drop":
                        list.remove(index);
                    break;

                case "Combine Items":
                    String [] splitArr=index.split(":");
                    String oldItem=splitArr[0];
                    String newItem=splitArr[1];
                    if (list.contains(oldItem)){
                        int indexOfOldItem=list.indexOf(oldItem) + 1;
                        list.add(indexOfOldItem, newItem);
                    }
                    break;

                case "Renew":
                    if (list.contains(index)){
                        list.remove(index);
                        list.add(index);
                    }
                    break;
            }

            command=scanner.nextLine();
        }
        System.out.println(String.join(", ", list));
    }
}
