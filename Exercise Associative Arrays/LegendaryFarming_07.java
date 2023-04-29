import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming_07 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        Map<String,Integer> materials=new LinkedHashMap<>();
        Map<String,Integer> junks=new LinkedHashMap<>();

        materials.put("shards", 0);
        materials.put("fragments", 0);
        materials.put("motes", 0);

        boolean isWin=false;

        while (!isWin){
            String input=scanner.nextLine();
            String [] inputData=input.split("\\s+");

            //inputData=["6", "leathers", "255", "fragments", ...]
            for (int index = 0; index <= inputData.length - 1 ; index+= 2)  {
                int quantity = Integer.parseInt(inputData[index]); //количество материал
                String material = inputData[index + 1].toLowerCase(); //вида на събрания материал

                //проверка какъв материал сме събрали -> събираме
                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                    int currentQuantity = materials.get(material);
                    materials.put(material, currentQuantity + quantity);
                } else {
                    //материалът е боклук
                    if (!junks.containsKey(material)) {
                        junks.put(material, quantity);
                    } else {
                        int currentQuantity = junks.get(material);
                        junks.put(material, currentQuantity + quantity);
                    }
                }

                //проверка дали сме спечелили легендарния предмет
                if (materials.get("shards") >= 250) {
                    System.out.println("Shadowmourne obtained!");
                    materials.put("shards", materials.get("shards") - 250);
                    isWin = true;
                    break;
                } else if (materials.get("fragments") >= 250) {
                    System.out.println("Valanyr obtained!");
                    materials.put("fragments", materials.get("fragments") - 250);
                    isWin = true;
                    break;
                } else if (materials.get("motes") >= 250) {
                    System.out.println("Dragonwrath obtained!");
                    materials.put("motes", materials.get("motes") - 250);
                    isWin = true;
                    break;
                }
            }

            if (isWin){
                break;
            }
        }

        //всички валидни материали -> materials
        //entry: материал(кey): количество(value)
        materials.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        //всички боклуци
        //entry: материал(кey): количество(value)
        junks.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

    }
}
