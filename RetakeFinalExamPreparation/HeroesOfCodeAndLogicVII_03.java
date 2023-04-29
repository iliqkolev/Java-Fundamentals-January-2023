package FinalExam_04;

import java.util.*;

public class HeroesOfCodeAndLogicVII_03 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int heroes=Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> map = new LinkedHashMap<>();

        for (int i = 1; i <= heroes ; i++) {
            String [] tokens=scanner.nextLine().split(" ");
            String name=tokens[0];
            int health=Integer.parseInt(tokens[1]);
            int manaPoints=Integer.parseInt(tokens[2]);
            map.put(name, new ArrayList<>());
            map.get(name).add(0, health);
            map.get(name).add(1, manaPoints);
        }

        String command=scanner.nextLine();
        while (!command.equals("End")){
            String [] tokens=command.split(" - ");
            if (command.contains("CastSpell")){
                String name=tokens[1];
                int manaPointsNeeded=Integer.parseInt(tokens[2]);
                String spellName=tokens[3];
                int manaPointsLeft= map.get(name).get(1) - manaPointsNeeded;
                if (manaPointsLeft <= 0){
                    System.out.printf("%s does not have enough MP to cast %s!\n", name, spellName);
                }else{
                    map.get(name).remove(1);
                    map.get(name).add(1, manaPointsLeft);
                    System.out.printf("%s has successfully cast %s and now has %d MP!\n", name, spellName, manaPointsLeft);
                }

            } else if (command.contains("TakeDamage")) {
                String name=tokens[1];
                int damage=Integer.parseInt(tokens[2]);
                String attacker=tokens[3];
                int healthLeft=map.get(name).get(0) - damage;
                if (healthLeft <= 0){
                    map.remove(name);
                    System.out.printf("%s has been killed by %s!\n", name, attacker);
                }else{
                    map.get(name).remove(0);
                    map.get(name).add(0, healthLeft);
                    System.out.printf("%s was hit for %d HP by %s and now has %d HP left!\n", name, damage, attacker, healthLeft);
                }

            }else if (command.contains("Recharge")){
                String name=tokens[1];
                int amount=Integer.parseInt(tokens[2]);
                int manaPointsLeft=map.get(name).get(1) + amount;
                int sumManaPoints=0;
                if (manaPointsLeft > 200){
                    int mana=200;
                    sumManaPoints=200-(manaPointsLeft-amount);
                    map.get(name).remove(1);
                    map.get(name).add(1, mana);
                    System.out.printf("%s recharged for %d MP!\n", name, sumManaPoints);
                }else{
                    map.get(name).remove(1);
                    map.get(name).add(1, manaPointsLeft);
                    System.out.printf("%s recharged for %d MP!\n", name, amount);
                }

            }else if (command.contains("Heal")){
                String name=tokens[1];
                int amount=Integer.parseInt(tokens[2]);
                int healthLeft=map.get(name).get(0) + amount;
                int sumHealth=0;
                if (healthLeft > 100){
                    int health=100;
                    sumHealth=100 - (healthLeft-amount);
                    map.get(name).remove(0);
                    map.get(name).add(0, health);
                    System.out.printf("%s healed for %d HP!\n", name, sumHealth);
                }else{
                    map.get(name).remove(0);
                    map.get(name).add(0, healthLeft);
                    System.out.printf("%s healed for %d HP!\n", name, amount);
                }

            }

            command=scanner.nextLine();
        }

        for (Map.Entry<String, List<Integer>> entry: map.entrySet()){
            System.out.printf("%s\n", entry.getKey());
            System.out.printf("HP: %d\n", entry.getValue().get(0));
            System.out.printf("MP: %d\n", entry.getValue().get(1));
        }
    }
}
