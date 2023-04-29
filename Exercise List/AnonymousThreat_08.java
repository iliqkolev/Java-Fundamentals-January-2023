import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> texts = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("3:1")) {

            if (command.contains("merge")) {
                //command = merge {startIndex} {endIndex}
                int startIndex = Integer.parseInt(command.split(" ")[1]);
                int lastIndex = Integer.parseInt(command.split(" ")[2]);
                //проверка дали startIndex < 0
                if (startIndex < 0) {
                    startIndex = 0;
                }
                //проверка за lastIndex
                if (lastIndex > texts.size() - 1) {
                    lastIndex = texts.size() - 1;
                }
                //валидиране на индексите
                if (startIndex >= 0 && startIndex <=texts.size() - 1 && lastIndex >= 0 && lastIndex <= texts.size() - 1) {


                    //{"Ivo", "Johny", "Tony", "Bony","Mony"}
                    //merge 1 3
                    //1.взимаме елементите и ги обединяваме
                    String resultMerge = "";
                    for (int index = startIndex; index <= lastIndex; index++) {
                        String current = texts.get(index);
                        resultMerge += current;
                    }
                    //resultMerge= "JohnyTonyBony"
                    //2.премахваме обединените елементи
                    for (int index = startIndex; index <= lastIndex; index++) {
                        texts.remove(startIndex);
                    }
                    //{"Ivo", "Mony"}
                    //3.добавяме обединението на startIndex
                    texts.add(startIndex, resultMerge);
                    //{"Ivo", "JohnyTonyBony", "Mony"}
                }

            } else if (command.contains("divide")) {
                //command = divide {index} {partitions}
                int index = Integer.parseInt(command.split(" ")[1]);
                int parts = Integer.parseInt(command.split(" ")[2]); // брой на частите

                //валидираме индекса от който ще взимаме някакъв текст
                if (index >= 0 && index <= texts.size() - 1) {
                    // {"abcdef", "ghi", "jkl"}
                    //divide 0 3
                    String textForDivide = texts.get(index); //"abcdef"
                    texts.remove(index);
                    //{"ghi", "jkl"}

                    //1.колко символа ще има всяка част
                    int countSymbolsPerParts = textForDivide.length() / parts;

                    //всички равни части без последната
                    int beginIndex = 0;
                    for (int part = 1; part < parts; part++) {
                        String textPerParts = textForDivide.substring(beginIndex, beginIndex + countSymbolsPerParts);
                        texts.add(index, textPerParts);
                        index++; //място на поставяне на разбитата част в главния списък
                        beginIndex += countSymbolsPerParts;
                    }
                    //последна част
                    String textLastParts = textForDivide.substring(beginIndex, textForDivide.length());
                    texts.add(index, textLastParts);
                }
            }

            command = scanner.nextLine();
        }
        //1. НАЧИН
        //отпечатваме  списък с текстове
        //String.join -> работи само със списък с текстове
        System.out.println(String.join(" ", texts));


        //2.НАЧИН
        /*for (String text: texts) {
            System.out.println(text + " ");
        }*/
    }
}
