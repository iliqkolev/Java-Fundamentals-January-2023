package FinalExamRetake_01;

import java.util.Scanner;

public class TheImittationGame_01 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String encryptedMessage=scanner.nextLine();
        String command=scanner.nextLine();
        StringBuilder textBuilder=new StringBuilder(encryptedMessage);

        while (!command.equals("Decode")){
            String [] tokens=command.split("\\|");
            String nameOfCommand=tokens[0];

            if (nameOfCommand.contains("Move")){
                int numOfLetters=Integer.parseInt(tokens[1]);
                String takenLetters=textBuilder.substring(0,numOfLetters);
                textBuilder.delete(0,numOfLetters);
                textBuilder.append(takenLetters);

            }else if (nameOfCommand.contains("Insert")){
                int index=Integer.parseInt(tokens[1]);
                String value=tokens[2];
                textBuilder.insert(index,value);

            }else if (nameOfCommand.contains("ChangeAll")){
                String oldText=tokens[1];
                String newText=tokens[2];
                String currentMessage=textBuilder.toString();
                currentMessage=currentMessage.replace(oldText,newText);
                textBuilder=new StringBuilder(currentMessage);
            }

            command=scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s\n",textBuilder.toString());

    }
}
