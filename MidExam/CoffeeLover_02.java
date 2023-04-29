import java.util.*;
import java.util.stream.Collectors;

public class CoffeeLover_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 1; i <= n; i++) {
            String command = scanner.nextLine();
            if (command.contains("Include")) {
                String coffee = command.split("\\s+")[1];
                names.add(coffee);

                }  else if (command.contains("Remove")) {
                String firstOrLast = command.split("\\s+")[1];
                int number = Integer.parseInt(command.split("\\s+")[2]);
                if (names.size() < number) {
                    continue;
                }
                if (command.split(" ")[1].equals("first")) {
                    for (int j = 0; j < number; j++) {
                        names.remove(0);
                    }
                } else if (command.split(" ")[1].equals("last")) {
                    for (int j = 0; j < number; j++) {
                        names.remove(names.size() - 1);
                    }

                }
                } else if (command.contains("Prefer")) {
                    int firstNum = Integer.parseInt(command.split("\\s+")[1]);
                    int secondNum = Integer.parseInt(command.split("\\s+")[2]);
                    if (firstNum >= 0 && firstNum <= names.size() - 1 && secondNum >= 0 && secondNum <= names.size() - 1) {
                        String element = names.get(firstNum);
                        String element2 = names.get(secondNum);
                        names.set(secondNum, element);
                        names.set(firstNum, element2);
                    }

                } else if (command.contains("Reverse")) {

                    Collections.reverse(names);
                }


        }
        System.out.println("Coffees: ");
        System.out.println(String.join(" ", names));
    }
}
