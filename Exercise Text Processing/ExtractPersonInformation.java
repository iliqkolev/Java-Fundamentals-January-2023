import java.util.Scanner;

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= n ; i++) {
            String input=scanner.nextLine();
            int beginName=input.indexOf('@');
            int endName=input.indexOf('|');
            int beginNum=input.indexOf('#');
            int endNum=input.indexOf('*');
            System.out.printf("%s is %s years old.\n", input.substring(beginName + 1,endName), input.substring(beginNum + 1, endNum));

        }
    }
}
