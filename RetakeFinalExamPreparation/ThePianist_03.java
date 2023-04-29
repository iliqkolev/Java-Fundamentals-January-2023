package FinalExamRetake_01;

import java.util.*;

public class ThePianist_03 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> listMap=new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String[] text = scanner.nextLine().split("\\|");
            String piece=text[0];
            String composer=text[1];
            String key=text[2];
            listMap.putIfAbsent(piece,new ArrayList<>());
            listMap.get(piece).add(0,composer);
            listMap.get(piece).add(1,key);
        }

        String command=scanner.nextLine();

        while (!command.equals("Stop")){
            String [] tokens=command.split("\\|");
            String name=tokens[0];
            if (name.contains("Add")){
                String piece=tokens[1];
                String composer=tokens[2];
                String key=tokens[3];
                if (!listMap.containsKey(piece)){
                    listMap.put(piece, new ArrayList<>());
                    listMap.get(piece).add(0,composer);
                    listMap.get(piece).add(1, key);
                    System.out.printf("%s by %s in %s added to the collection!\n", piece,composer,key);
                }else{
                    System.out.printf("%s is already in the collection!\n", piece);
                }

            }else if (name.contains("Remove")){
                String piece=tokens[1];
                if (listMap.containsKey(piece)){
                    listMap.remove(piece);
                    System.out.printf("Successfully removed %s!\n", piece);
                }else{
                    System.out.printf("Invalid operation! %s does not exist in the collection.\n",piece);
                }

            }else if (name.contains("ChangeKey")){
                String piece=tokens[1];
                String newTone=tokens[2];
                if (listMap.containsKey(piece)){
                    listMap.get(piece).set(1,newTone);
//                    List<String> pieceInfo=listMap.get(piece);
//                    pieceInfo.set(1, newTone);
//                    listMap.put(piece,pieceInfo);
                    System.out.printf("Changed the key of %s to %s!\n", piece, newTone);
                }else{
                    System.out.printf("Invalid operation! %s does not exist in the collection.\n", piece);
                }
            }
            command=scanner.nextLine();
        }
        ////"{Piece} -> Composer: {composer}, Key: {key}"
        listMap.entrySet().
                forEach(entry -> System.out.printf("%s -> Composer: %s, Key: %s\n", entry.getKey(),entry.getValue().get(0), entry.getValue().get(1)));
    }
}
