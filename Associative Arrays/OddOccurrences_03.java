import java.util.*;

public class OddOccurrences_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] wordArr = scanner.nextLine().split(" ");

        LinkedHashMap<String, Integer> wordsMap = new LinkedHashMap<>();

        for (String item : wordArr) {

            item = item.toLowerCase();
            wordsMap.putIfAbsent(item, 0);
            wordsMap.put(item, wordsMap.get(item) + 1);

//        item=item.toLowerCase();
//        if (!wordsMap.containsKey(item)){
//            wordsMap.put(item,1);
//
//            }else{
//            int value=wordsMap.get(item);
//            wordsMap.put(item , value+ 1);
//            }
//        }
    }
        List<String> resultList=new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            if (entry.getValue() % 2 != 0){
                resultList.add(entry.getKey());
            }
        }
        System.out.println(String.join(", ", resultList));

    }
}
