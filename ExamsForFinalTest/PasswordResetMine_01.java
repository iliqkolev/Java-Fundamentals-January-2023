import java.util.Scanner;

public class PasswordResetMine_01 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String text=scanner.nextLine();
        String command=scanner.nextLine();

        StringBuilder passwordBuilder=new StringBuilder();
        while (!command.equals("Done")){
            if (command.contains("TakeOdd")) {
                for (int i = 0; i < text.length(); i++) {
                    if (i % 2 == 1) {
                        String oddText = String.valueOf(text.charAt(i));
                        passwordBuilder.append(oddText);
                    }
                }
                System.out.println(passwordBuilder);

            }else if(command.contains("Cut")){
                //"Cut {index} {length}"
                int index= Integer.parseInt(command.split(" ")[1]);
                int length= Integer.parseInt(command.split(" ")[2]);
                String cutText= String.valueOf(passwordBuilder.delete(index,index + length));
                System.out.println(passwordBuilder);

            }else if (command.contains("Substitute")){
                //Substitute {substring} {substitute}"
                String oldText=command.split(" ")[1];
                String newText=command.split(" ")[2];
                if (!passwordBuilder.toString().contains(oldText)){
                    System.out.println("Nothing to replace!");
                }else{
                    String updatedText=passwordBuilder.toString().replace(oldText,newText);
                    passwordBuilder=new StringBuilder(updatedText);
                    System.out.println(passwordBuilder);
                }
            }
            command=scanner.nextLine();
        }
        System.out.printf("Your password is: %s",passwordBuilder);
    }
}
