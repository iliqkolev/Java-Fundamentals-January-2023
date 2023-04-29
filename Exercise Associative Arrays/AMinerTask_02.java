import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask_02 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String command=scanner.nextLine();

        Map<String,Integer> countMap=new LinkedHashMap<>();
        while (!command.equals("stop")){
            int number=Integer.parseInt(scanner.nextLine());

            if (!countMap.containsKey(command)){
                countMap.put(command,number);
            }else{
                int currentCount=countMap.get(command);
                countMap.put(command,currentCount + number);
            }

            command=scanner.nextLine();
        }

        countMap.forEach((key,value) -> System.out.println(key + " -> " + value));

    }
}
