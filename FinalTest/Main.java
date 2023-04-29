import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        Map<String, List<String>> notebook=new LinkedHashMap<>();
        for (String word: scanner.nextLine().split("\\s+\\|\\s+")){
            String [] wordAndDefinition=word.split(":");
            notebook.putIfAbsent(wordAndDefinition[0], new ArrayList<>());
            notebook.get(wordAndDefinition[0]).add(wordAndDefinition[1]);
        }
        List<String> teacherWords=new ArrayList<>(Arrays.asList(scanner.nextLine().split("\\s+\\|\\s+")));
        String command=scanner.nextLine();
        if (command.equals("Test")){
            teacherWords.forEach(item -> {
                if (notebook.containsKey(item)){
                    System.out.printf("%s\n", item);
                    notebook.get(item).forEach(value -> System.out.printf("-%s\n",value));
                }
            });
        }else if (command.equals("Hand over")){
            System.out.println(String.join(" ", notebook.keySet()));
        }
    }
}