import java.util.*;

public class Dictionary_03 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);


        Map<String, List<String>> notebook = new LinkedHashMap<>();
        for (String word : scanner.nextLine().split("\\s+\\|\\s+")) {
            String[] wordAndDefinition = word.split(": ");
            notebook.putIfAbsent(wordAndDefinition[0], new ArrayList<>());
            notebook.get(wordAndDefinition[0]).add(wordAndDefinition[1]);
        }
        List<String> teacherWords = new ArrayList<>(Arrays.asList(scanner.nextLine().split("\\s+\\|\\s+")));
        String command = scanner.nextLine();
        if ("Test".equals(command)) {
            teacherWords.forEach(item -> {
                if (notebook.containsKey(item)) {
                    System.out.printf("%s:\n", item);
                    notebook.get(item).forEach(definition -> System.out.printf(" -%s\n", definition));
                }
            });
        } else if ("Hand Over".equals(command)) {
            System.out.println(String.join(" ", notebook.keySet()));
        }
    }
}
