import java.util.*;

public class TreasureHunt_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] lootsChestArr = scanner.nextLine().split("\\|");
        List<String> chestList = new LinkedList<>(Arrays.asList(lootsChestArr));

        List<String> commandList = Arrays.asList(scanner.nextLine().split(" "));

        while ((!"Yohoho!".equals(commandList.get(0)))) {

            String command = commandList.get(0);

            switch (command) {
                case "Loot":
                    List<String> loots = commandList.subList(1, commandList.size());
                    for (String item : loots) {
                        if (!chestList.contains(item)) {
                            chestList.add(0, item);
                        }
                    }
                    break;

                case "Drop":
                    int index = Integer.parseInt(commandList.get(1));
                    if (index >= 0 && index < chestList.size()) {
                        String removedItem = chestList.get(index);
                        chestList.remove(removedItem);
                        chestList.add(removedItem);
                    }
                    break;

                case "Steal":
                    int count = Integer.parseInt(commandList.get(1));
                    int result = chestList.size() - count;
                    List<String> stolenItems = new ArrayList<>();
                    if (result >= 0) {
                        for (int i = result; i < chestList.size(); i++) {
                            String item = chestList.remove(i--);
                            stolenItems.add(item);
                        }
                    } else {

                        for (int i = 0; i < chestList.size(); i++) {
                            String item = chestList.remove(i--);
                            stolenItems.add(item);
                        }
                    }
                    System.out.println(String.join(", ", stolenItems));
                    break;
            }

            commandList = Arrays.asList(scanner.nextLine().split(" "));
        }
        if (chestList.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        } else {
            double sum = 0;
            for (String item : chestList) {
                sum = sum + item.length();
            }
            double averageGain = sum / chestList.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.\n", averageGain);
        }

    }
}
