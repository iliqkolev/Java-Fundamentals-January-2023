import java.util.Scanner;

public class TreasureHunt_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] loots = scanner.nextLine().split("\\|");
        String command = scanner.nextLine();

        while (!command.equals("Yohoho!")) {
            String[] commandParts = command.split(" ");
            String commandName = commandParts[0];

            switch (commandName) {
                case "Loot":
                    break;
                case "Drop": //"Drop 4".split -> commandParts= ["Drop", "4"]
                    int dropIndex = Integer.parseInt(commandParts[1]); // "4"-> 4
                    //проверка на индекс
                    if (dropIndex < 0 || dropIndex >= loots.length - 1) {
                        //невалиден индекс -> индекс на който няма елемент
                        break;
                    } else {
                        //валиден индекс
                        //1.взимаме елемента за преместване
                        String currentLoot = loots[dropIndex];
                        //2. премествам всички елементи наляво след моя
                        for (int leftIndex = dropIndex; leftIndex < loots.length - 1; leftIndex++) {
                        loots[leftIndex]=loots[leftIndex+1];
                        }
                    //3.слагаме елемента за преместване
                        loots[loots.length -1]=currentLoot;
                    }
                    break;
                case "Steal":
                    break;
            }


            command = scanner.nextLine();
        }

    }
}
