package FinalExam_04;

import java.util.Scanner;

public class PasswordReset_01 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String password=scanner.nextLine();
        StringBuilder passwordBuilder=new StringBuilder(password);

        String command=scanner.nextLine();
        while (!command.equals("Done")){
            String [] tokens=command.split(" ");
            if (command.contains("TakeOdd")){
                String odd="";
                for (int i = 0; i < passwordBuilder.length(); i++) {
                        if (i % 2 != 0){
                            String oddText=String.valueOf(passwordBuilder.toString().charAt(i));
                            odd += oddText;
                        }
                    }
                passwordBuilder.delete(0,passwordBuilder.length());
                passwordBuilder.append(odd);
                System.out.println(passwordBuilder);

            }else  if (command.contains("Cut")){
                int index=Integer.parseInt(tokens[1]);
                int length=Integer.parseInt(tokens[2]);
                passwordBuilder.delete(index,length+index);
                System.out.println(passwordBuilder);

            }else if (command.contains("Substitute")){
                String oldText=tokens[1];
                String newText=tokens[2];
                if (passwordBuilder.toString().contains(oldText)){
                    String changedText=passwordBuilder.toString().replace(oldText,newText);
                    passwordBuilder=new StringBuilder(changedText);
                    System.out.println(passwordBuilder);
                }else{
                    System.out.println("Nothing to replace!");
                }
            }
            command=scanner.nextLine();
        }
        System.out.println("Your password is: " + passwordBuilder);
    }
}
