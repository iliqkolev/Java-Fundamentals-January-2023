import java.util.Scanner;

public class ReverseStrings_01 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String line=scanner.nextLine();

        while(!line.equals("end")){
            String reversed="";
            for (int i = line.length() - 1; i >= 0; i--) {
               char symbol=line.charAt(i);
               reversed += symbol;

            }

            System.out.printf("%s = %s%n", line,reversed);


            line= scanner.nextLine();
        }
    }
}
