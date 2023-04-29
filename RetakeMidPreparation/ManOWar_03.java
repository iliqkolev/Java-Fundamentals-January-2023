package MidExamRetake_6;

import java.util.Arrays;
import java.util.Scanner;

public class ManOWar_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //12>13>11>20>66
        int[] pirateShip = Arrays.stream(scanner.nextLine().split(">"))
                .mapToInt(Integer::parseInt)
                .toArray();
        //12>22>33>44>55>32>18
        int[] warship = Arrays.stream(scanner.nextLine().split(">"))
                .mapToInt(Integer::parseInt)
                .toArray();
        //70
        int maxHPCapacity = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        while (!command.equals("Retire")) {
            // "Fire {index} {damage}" -> Fire 2 11
            if (command.contains("Fire")) {
                int index = Integer.parseInt(command.split(" ")[1]);
                int damage = Integer.parseInt(command.split(" ")[2]);
                if (index >= 0 && index <= warship.length) {

                    warship[index] -= damage;

                    if (warship[index] <= 0) {
                        System.out.println("You won! The enemy ship has sunken.");
                        return;
                    }
                }

            } else if (command.contains("Defend")) {
                // "Defend {startIndex} {endIndex} {damage}" -> Defend 3 6 11
                int startIndex = Integer.parseInt(command.split(" ")[1]);
                int endIndex = Integer.parseInt(command.split(" ")[2]);
                int damage = Integer.parseInt(command.split(" ")[3]);
                if (startIndex >= 0 && endIndex <= pirateShip.length) {
                    for (int i = startIndex; i <= endIndex; i++) {

                        pirateShip[i] -= damage;

                        if (pirateShip[i] <= 0) {
                            System.out.println("You lost! The pirate ship has sunken.");
                            return;
                        }
                    }
                }

            } else if (command.contains("Repair")) {
                // "Repair {index} {health} -> "Repair 1 33
                int index = Integer.parseInt(command.split(" ")[1]);
                int health = Integer.parseInt(command.split(" ")[2]);
                if (index >= 0 && index <= pirateShip.length) {
                    if (health <= maxHPCapacity){
                        int takenIndex=pirateShip[index];
                        int addedHealth=takenIndex + health;
                        pirateShip[index] = addedHealth;
                    }
                }

            }else if (command.equals("Status")){
                int sectionForRepair=0;
                double repairSum=maxHPCapacity*0.2;

             for (int number: pirateShip){
                 if (number < repairSum){
                     sectionForRepair++;
                 }
             }
                System.out.printf("%s sections need repair.\n",sectionForRepair);
            }
            command = scanner.nextLine();
        }


        System.out.printf("Pirate ship status: %d\n", Arrays.stream(pirateShip).sum());
        System.out.printf("Warship status: %d\n", Arrays.stream(warship).sum());

    }
}
