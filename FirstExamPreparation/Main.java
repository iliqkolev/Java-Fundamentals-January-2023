import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);

        int energy=Integer.parseInt(scanner.nextLine());
        String insert=scanner.nextLine();
        boolean enoughEnergy=true;
        int wonBattles=0;


        while (!insert.equals("End of battle")){
            int distance=Integer.parseInt(insert);

             if ((energy - distance)  < 0){
                 enoughEnergy=false;
                 break;
             }else{
                 energy -=distance;
                 wonBattles++;
                 if (wonBattles % 3 == 0){
                     energy += wonBattles;
                 }
             }
            insert=scanner.nextLine();
        }
        if (enoughEnergy){
            System.out.printf("Won battles: %d. Energy left: %d\n", wonBattles,energy);
        }else{
            System.out.printf("Not enough energy! Game ends with %d won battles and %d energy\n",wonBattles,energy);
        }
    }
}