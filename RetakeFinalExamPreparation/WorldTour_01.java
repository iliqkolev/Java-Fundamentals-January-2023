package FinalExamRetake_02;

import java.util.Scanner;

public class WorldTour_01 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String stops=scanner.nextLine();
        StringBuilder stopsBuilder=new StringBuilder(stops);
        String command=scanner.nextLine();

        while (!command.equals("Travel")){
            String [] tokens=command.split(":");
            if (command.contains("Add Stop")){
                int index=Integer.parseInt(tokens[1]);
                String  city =tokens[2];
                if (index >= 0 && index <= stopsBuilder.length() - 1){
                    stopsBuilder.insert(index, city);
                }
            }else if (command.contains("Remove Stop")){
                int startIndex=Integer.parseInt(tokens[1]);
                int endIndex=Integer.parseInt(tokens[2]);
                if (startIndex >= 0 && endIndex <= stopsBuilder.length() - 1){
                    stopsBuilder.delete(startIndex,endIndex + 1);
                }
            }else if (command.contains("Switch")){
                String oldText=tokens[1];
                String newText=tokens[2];
                if (stopsBuilder.toString().contains(oldText)){
                    String updatedText=stopsBuilder.toString().replace(oldText,newText);
                    stopsBuilder= new StringBuilder(updatedText);
                }
            }
            System.out.println(stopsBuilder);
            command=scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " +  stopsBuilder);
    }
}
