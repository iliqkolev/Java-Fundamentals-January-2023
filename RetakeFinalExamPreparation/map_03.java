package FinalRetake;

import java.util.*;
import java.util.function.DoubleFunction;

public class map_03 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String command=scanner.nextLine();
        Map<String, List<Double>> clientsMap=new LinkedHashMap<>();
        Map<String, List<Double>> distributorMap=new LinkedHashMap<>();

        while (!command.equals("End")){
            String [] tokens=command.split(" ");

            if (command.contains("Deliver")){
            String distributorName=tokens[1];
            double moneySpent=Double.parseDouble(tokens[2]);

            if (!distributorMap.containsKey(distributorName)){
                distributorMap.put(distributorName, new ArrayList<>());
                distributorMap.get(distributorName).add(moneySpent);
            }else{
                double currentMoney=distributorMap.get(distributorName).get(0) + moneySpent;
                distributorMap.get(distributorName).clear();
                distributorMap.get(distributorName).add(currentMoney);
            }

            }else if (command.contains("Return")) {
                String distributorName = tokens[1];
                double moneyReturned = Double.parseDouble(tokens[2]);


                if (distributorMap.containsKey(distributorName)) {
                    double decreasedMoney = distributorMap.get(distributorName).get(0) - moneyReturned;
                    distributorMap.get(distributorName).clear();
                    distributorMap.get(distributorName).add(decreasedMoney);
                    if ( decreasedMoney <= 0) {
                        clientsMap.remove(distributorName);
                    }
                }

            }else if (command.contains("Sell")){
                String clientName = tokens[1];
                double moneyEarned = Double.parseDouble(tokens[2]);

                if (!clientsMap.containsKey(clientName)){
                    clientsMap.put(clientName, new ArrayList<>());
                    clientsMap.get(clientName).add(0,moneyEarned);
                }else{
                    double currentMoney=clientsMap.get(clientName).get(0);
                    double earnedMoney=currentMoney+moneyEarned;
                    clientsMap.get(clientName).clear();
                    clientsMap.get(clientName).add(earnedMoney);
                }
            }

            command=scanner.nextLine();
        }

        for (Map.Entry <String, List<Double>> entry: clientsMap.entrySet()){
            System.out.printf("%s: %.2f\n", entry.getKey(), entry.getValue().get(0));
        }

        System.out.println("-----------");

        for (Map.Entry <String, List<Double>> entry: distributorMap.entrySet()){
            System.out.printf("%s: %.2f\n", entry.getKey(), entry.getValue().get(0));
        }

        System.out.println("-----------");

        double sum=0;
        for (Map.Entry<String, List<Double>> entry : clientsMap.entrySet()) {

            List<Double> values = entry.getValue();

            for (double value : values) {
                sum += value;
            }
        }
        System.out.printf("Total Income: %.2f", sum);
        System.out.println();
    }
}
