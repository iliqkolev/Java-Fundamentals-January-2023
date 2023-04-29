package FinalExam_05;

import java.util.Scanner;

public class ActivationKeys_01 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String rawKey=scanner.nextLine();
        StringBuilder key=new StringBuilder(rawKey);

        String input=scanner.nextLine();

        while (!input.equals("Generate")){
            String [] tokens=input.split(">>>");

            if (input.contains("Contains")){
                //	"Contains>>>{substring}"
                String text=tokens[1];
                if (key.toString().contains(text)){
                    System.out.printf("%s contains %s\n", key, text);
                }else{
                    System.out.println("Substring not found!");
                }

            }else if (input.contains("Upper")){
                int startIndex=Integer.parseInt(tokens[2]);
                int endIndex=Integer.parseInt(tokens[3]);
                String takenWord=key.substring(startIndex, endIndex);
                String upperCase=takenWord.toUpperCase();
                key.delete(startIndex,endIndex);
                String gotWord=key.substring(0, startIndex ) + upperCase + key.substring(startIndex, key.length());
                key=new StringBuilder(gotWord);
                System.out.println(key);

            }else if (input.contains("Lower")){
                int startIndex=Integer.parseInt(tokens[2]);
                int endIndex=Integer.parseInt(tokens[3]);
                String takenWord=key.substring(startIndex, endIndex);
                String upperCase=takenWord.toLowerCase();
                key.delete(startIndex,endIndex);
                String gotWord=key.substring(0, startIndex) + upperCase + key.substring(startIndex, key.length());
                key=new StringBuilder(gotWord);
                System.out.println(key);

            }else if (input.contains("Slice")){
                int startIndex=Integer.parseInt(tokens[1]);
                int endIndex=Integer.parseInt(tokens[2]);
                key.delete(startIndex,endIndex);
                System.out.println(key);
            }
            input=scanner.nextLine();
        }
        System.out.println("Your activation key is: " + key.toString());
    }
}
