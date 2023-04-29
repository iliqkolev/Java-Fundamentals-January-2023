import java.util.Scanner;

public class Hogwarts_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String spell = scanner.nextLine();
        String command = scanner.nextLine();

        while (!command.equals("Abracadabra")) {

                if (command.contains("Abjuration")) {
                    String upperCaseSpell = spell.toUpperCase();
                    spell = upperCaseSpell;
                    System.out.println(spell);
                } else if (command.contains("Necromancy")) {
                    String lowerCaseSpell = spell.toLowerCase();
                    spell = lowerCaseSpell;
                    System.out.println(spell);
                } else if (command.contains("Illusion")) {
                    int index = Integer.parseInt(command.split(" ")[1]);
                    String letter = command.split(" ")[2];
                    //ако е валиднен индекса
                    if (index >= 0 && index <= spell.length() - 1) {
                        String takenLetter = spell.substring(index, index + 1);
                        String replacedSpell = spell.replace(takenLetter, letter);
                        spell = replacedSpell;
                        System.out.println("Done!");
                    } else {
                        //не е валиден индекса
                        System.out.println("The spell was too weak.");
                    }
                } else if (command.contains("Divination")) {
                    String oldWord = command.split(" ")[1];
                    String newWord = command.split(" ")[2];
                    if (spell.contains(oldWord)) {
                        String changedLetters = spell.replace(oldWord, newWord);
                        spell = changedLetters;
                        System.out.println(spell);
                    }
                } else if (command.contains("Alteration")) {
                    String wordForRemove = command.split(" ")[1];
                    if (spell.contains(wordForRemove)) {
                        String removed = spell.replace(wordForRemove, "");
                        spell = removed;
                        System.out.println(spell);
                    }

                } else {
                System.out.println("The spell did not work!");
            }

            command = scanner.nextLine();
        }
    }
}
