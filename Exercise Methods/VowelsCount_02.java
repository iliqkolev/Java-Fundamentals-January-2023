import java.util.Scanner;

public class VowelsCount_02 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String text=scanner.nextLine();

        printVowelsCount(text);

    }
public static void printVowelsCount(String text){
        //гласни букви а, е ,и , о, у
    int count=0;
    for (char symbol: text.toLowerCase().toCharArray()) {
                if (symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u' ){
                            count++;
                }
        }
    System.out.println(count);
    }
}
