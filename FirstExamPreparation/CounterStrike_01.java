import java.util.Scanner;

public class CounterStrike_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        boolean enoughEnergy=true;
        int battleCount = 0;
        int totalEnergy = energy;
        while (!input.equals("End of battle")) {
            int distance = Integer.parseInt(input);

            if ((totalEnergy - distance) < 0) {
                enoughEnergy=false;
                break;
            } else {
                totalEnergy -= distance;
                battleCount++;
                if (battleCount % 3 == 0){
                    totalEnergy += battleCount;
                }
            }


            input = scanner.nextLine();
        }
        if (enoughEnergy){
            System.out.printf("Won battles: %d. Energy left: %d\n",battleCount,totalEnergy);
        }else{
            System.out.printf("Not enough energy! Game ends with %d won battles and %d energy\n", battleCount, totalEnergy);
        }

    }
}
