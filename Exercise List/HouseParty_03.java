import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty_03 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int countCommand=Integer.parseInt(scanner.nextLine());

        List<String> guests=new ArrayList<>(); //списък с гости

        for (int i = 1; i <=countCommand ; i++) {
            String command=scanner.nextLine();
            String name= command.split(" ")[0]; // кой е човекът който ще идва на партито
            if (command.contains("is going!")){
                //command="{name} is going!"

                //1.да го има в списъка
                    if (guests.contains(name)){
                        System.out.println(name + " is already in the list!");
                    }
                //2.да го няма в списъка
                    else{
                        guests.add(name);
                    }
            }else if(command.contains("is not going!")){
                //command="{name} is not going!"
                //1.ако го има в списъка -> премахвам
                    if (guests.contains(name)){
                        guests.remove(name);
                    }
                //2.ако го няма в списъка
                    else{
                        System.out.println(name +" is not in the list!");
                    }
            }
        }

        for (String name:guests) {
            System.out.println(name);
        }
    }
}
