import java.util.Scanner;

public class RepeatString_07 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String inputText=scanner.nextLine();
        int n=Integer.parseInt(scanner.nextLine());


        System.out.println(repeatString(n,inputText));

    }
    public static String repeatString(int n,String text ){
        String result="";
        for (int i = 0; i < n; i++) {
            result += text;
        }
        return  result;
    }
}
