import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, ArrayList<String>> wordsMap=new LinkedHashMap<>();
        ArrayList<String> arr= wordsMap.get("cute");
        arr.add("asd");
        String demo=arr.get(0);
    }
}