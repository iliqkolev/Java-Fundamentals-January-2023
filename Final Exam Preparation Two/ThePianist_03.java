import java.util.*;

public class ThePianist_03 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        //1. СЪХРАНИМ ИНФОРМАЦИЯТА ЗА ПИЕСИТЕ
        int countPieces=Integer.parseInt(scanner.nextLine());
        //запис: пиеса -> списък с информация (композитор, тоналност)
        Map<String, List<String>> piecesMap=new LinkedHashMap();


        for (int i = 1; i <= countPieces; i++) {
            //"{piece}|{composer}|{key}".split("\\|")->["piece", "composer", "key"]
            String []pieceData=scanner.nextLine().split("\\|");
            String pieceName=pieceData[0]; //име на пиесата
            String composer=pieceData[1]; //композитор на пиесата
            String tone=pieceData[2]; //тоналност на пиесата

            //създаваме списък с информацията за тази пиеса
            List <String> piecesInfo=new ArrayList<>(); //празен списък
            piecesInfo.add(0,composer); //[0] - първо място
            piecesInfo.add(1, tone); ////[1] - второ място
            piecesMap.put(pieceName,piecesInfo);

        }
        //2. МОДИФИЦИРАМЕ ИНФОРМАЦИЯТА ЗА ПИЕСИТЕ СПРЯМО КОМАНДИТЕ
        String input=scanner.nextLine();
        while (!input.equals("Stop")){

            if (input.contains("Add")){
                String pieceName=input.split("\\|")[1];
                String composer=input.split("\\|")[2];
                String key=input.split("\\|")[3];

                //имаме такава пиеса
                if (piecesMap.containsKey(pieceName)){
                    System.out.println(pieceName + " is already in the collection!");
                } else{
                    //нямаме такава пиеса -> добавяме
                    List <String> inputInfo=new ArrayList<>(); //празен списък
                    inputInfo.add(0,composer); //[0] - първо място
                    inputInfo.add(1, key); ////[1] - второ място
                    piecesMap.put(pieceName,inputInfo);
                    System.out.printf("%s by %s in %s added to the collection!\n", pieceName, composer, key);
                }

            }else if (input.contains("Remove")){
                String pieceToRemove=input.split("\\|")[1];
                //имаме такава пиеса
                if (piecesMap.containsKey(pieceToRemove)){
                    piecesMap.remove(pieceToRemove);
                    System.out.printf("Successfully removed %s!\n",pieceToRemove);
                } else{
                    //нямаме такава пиеса
                    System.out.printf("Invalid operation! %s does not exist in the collection.\n",pieceToRemove);
                }

            }else if (input.contains("ChangeKey")) {
                String pieceName=input.split("\\|")[1];
                String newTone=input.split("\\|")[2];

                //няма такава пиеса
                if (!piecesMap.containsKey(pieceName)){
                    System.out.printf("Invalid operation! %s does not exist in the collection.\n", pieceName);
                }else{
                    //има такава пиеса
                    List<String> pieceInfo=piecesMap.get(pieceName); //списък: (композитор, тоналност)
                    pieceInfo.set(1, newTone); //променяме текущата тоналност
                    piecesMap.put(pieceName,pieceInfo);
                    System.out.printf("Changed the key of %s to %s!\n", pieceName, newTone);
                }
            }
            input=scanner.nextLine();
        }
        //"{Piece} -> Composer: {composer}, Key: {key}"
        //entry: пиеса -> списък с инф. [0] -> композитор, [1] -> тоналност
        //entry.getKey() -> име на пиесата
        //entry.getValue() -> [0] -> композитор, [1] -> тоналност
        //entry.getValue().get(0) -> композитор
        //entry.getValue().get(1) -> тоналност
        piecesMap.entrySet() //всички записи
                .forEach(entry -> System.out.printf("%s -> Composer: %s, Key: %s\n",
                         entry.getKey(), entry.getValue().get(0), entry.getValue().get(1)));
    }
}
