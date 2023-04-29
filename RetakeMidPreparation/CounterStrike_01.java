package MidExamRetake_3;

import java.util.Scanner;

public class CounterStrike_01 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int energy=Integer.parseInt(scanner.nextLine());
        String command=scanner.nextLine();
        int wonBattles=0;
        boolean enoughEnergy=true;
        int totalEnergy=energy;

        while (!command.equals("End of battle")){
            int distance=Integer.parseInt(command);
            if ((totalEnergy - distance) < 0){
                enoughEnergy=false;
                break;
            }else{
                totalEnergy -= distance;
                wonBattles++;

                if (wonBattles % 3 == 0){
                    totalEnergy += wonBattles;
                }
            }
            command=scanner.nextLine();
        }
        if (enoughEnergy){
            System.out.printf("Won battles: %d. Energy left: %d\n", wonBattles, totalEnergy);
        }else{
            System.out.printf("Not enough energy! Game ends with %d won battles and %d energy\n", wonBattles, totalEnergy);
        }
    }
}
