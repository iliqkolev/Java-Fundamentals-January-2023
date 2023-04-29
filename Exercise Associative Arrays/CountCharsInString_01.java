import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;



public class CountCharsInString_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();

        Map<Character, Integer> characterCounts = new LinkedHashMap<>();

        //"Ivan" -> ['I' 'v' 'a' 'n']
        for (char symbol : word.toCharArray()) {
            if (symbol == ' ') {
                continue;
            }
            //да сме го срещали
            if (characterCounts.containsKey(symbol)) {
                int currentCount = characterCounts.get(symbol);
                characterCounts.put(symbol, currentCount + 1);
            }
            //да не сме го срещали
            else {
                characterCounts.put(symbol, 1);
            }
        }
        characterCounts.forEach((key,value) -> System.out.println(key + " -> " + value));

    }
}
