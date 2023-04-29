import java.util.Scanner;

public class TheImitationGame_01 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String encryptedMessage=scanner.nextLine(); //криптирано съобщение

        StringBuilder modifyMessage=new StringBuilder(encryptedMessage);

        String input=scanner.nextLine();

        while (!input.equals("Decode")){

            if (input.contains("Move")){
                //input="Move {number of letters}":" -> "Move|5"
            int lettersCount=Integer.parseInt(input.split("\\|")[1]);
                //"owyouh" -> "howyou"
                String  firstLetters=modifyMessage.substring(0,lettersCount); //буквите за местене
                modifyMessage.replace(0,lettersCount,""); //заместваме с нищо
                //messageBuilder.delete(0,lettersCount); // изтриваме нужните букви
                modifyMessage.append(firstLetters);

            } else if (input.contains("Insert")){
                //input="Insert {index} {value} -> Insert|2|o
                int index=Integer.parseInt(input.split("\\|")[1]); //индекс на който ще вмъкваме
                String textToInsert=input.split("\\|")[2]; // буквата която ще заместваме
                modifyMessage.insert(index,textToInsert);

            } else if (input.contains("ChangeAll")){
                //input="ChangeAll|abc|wqe"
                String textForChange=input.split("\\|")[1]; //текст, който ще трябва да се променя
                String replacement=input.split("\\|")[2]; //текст, който ще замества

                String currentMessage=modifyMessage.toString(); //моментното съобщение
                currentMessage = currentMessage.replace(textForChange,replacement);
                modifyMessage = new StringBuilder(currentMessage);

            }

            input =scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s", modifyMessage);
    }
}
