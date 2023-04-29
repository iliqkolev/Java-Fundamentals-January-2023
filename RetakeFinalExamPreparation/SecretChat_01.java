package FinalExamRetake_03;

import java.util.Scanner;

public class SecretChat_01 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String input=scanner.nextLine();
        StringBuilder chatBuilder=new StringBuilder(input);

        String command=scanner.nextLine();

        while (!command.equals("Reveal")){
            String [] tokens=command.split(":\\|:");
            if (command.contains("InsertSpace")){
            int index=Integer.parseInt(tokens[1]);
            chatBuilder.insert(index," ");
            System.out.println(chatBuilder);

            }else if (command.contains("Reverse")){
                String text=tokens[1];
                StringBuilder reversedText=new StringBuilder(text);
                if (chatBuilder.toString().contains(text)){
                  String reverse = String.valueOf(reversedText.reverse());
                  String replacedText=chatBuilder.toString().replace(text,reverse);
                  chatBuilder=new StringBuilder(replacedText);
                  System.out.println(chatBuilder);
                }else{
                    System.out.println("error");
                }

            } else if (command.contains("ChangeAll")) {
                String oldText=tokens[1];
                String newText=tokens[2];
                String replacedWord=chatBuilder.toString().replace(oldText,newText);
                chatBuilder=new StringBuilder(replacedWord);
                System.out.println(chatBuilder);
            }

            command=scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s\n",chatBuilder);
    }
}
