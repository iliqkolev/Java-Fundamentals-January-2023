package FinalExam_05;

import java.util.*;

public class Pirates_03 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String input=scanner.nextLine();
        Map<String, List<Integer>> crewList=new LinkedHashMap<>();


        while (!input.equals("Sail")){
            String [] tokens=input.split("\\|\\|");
            String cities=tokens[0];
            int population=Integer.parseInt(tokens[1]);
            int gold=Integer.parseInt(tokens[2]);

            if (crewList.containsKey(cities)){
               int increasePopulation = crewList.get(cities).get(0)+population;
               int increaseGold=crewList.get(cities).get(1)+ gold;
               crewList.put(cities, new ArrayList<>());
               crewList.get(cities).add(0,increasePopulation);
               crewList.get(cities).add(1, increaseGold);
            }else{
                crewList.putIfAbsent(cities, new ArrayList<>());
                crewList.get(cities).add(0,population);
                crewList.get(cities).add(1, gold);
            }

            input=scanner.nextLine();
        }

        String command=scanner.nextLine();

        while (!command.equals("End")){
            if (command.contains("Plunder")){
                String town=command.split("=>")[1];
                int people=Integer.parseInt(command.split("=>")[2]);
                int gold=Integer.parseInt(command.split("=>")[3]);
                if (crewList.containsKey(town)){
                    int decreasePopulation= crewList.get(town).get(0) - people;
                    int decreaseGold=crewList.get(town).get(1) - gold;
                    crewList.get(town).clear();
                    crewList.get(town).add(0, decreasePopulation);
                    crewList.get(town).add(1, decreaseGold);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.\n", town, gold, people);

                    if (crewList.get(town).get(0) <= 0 || crewList.get(town).get(1) <= 0){
                        crewList.remove(town);
                        System.out.printf("%s has been wiped off the map!\n", town);
                    }
                }
            }else if (command.contains("Prosper")){
                String town=command.split("=>")[1];
                int gold=Integer.parseInt(command.split("=>")[2]);
                if (gold > 0){
                    int increaseGold=crewList.get(town).get(1) + gold;
                    crewList.get(town).add(1, increaseGold);
                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.\n", gold, town, increaseGold);
                }else{
                    System.out.printf("Gold added cannot be a negative number!\n");
                }
            }
            command=scanner.nextLine();
        }



        System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:\n", crewList.size());
        for (Map.Entry <String, List<Integer>> entry: crewList.entrySet()){

            System.out.printf("%s -> Population: %d citizens, Gold: %d kg\n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1));
        }
    }
}
