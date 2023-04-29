package FinalRetake;

import java.util.Scanner;

public class StringProcessing_01 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String text=scanner.nextLine();
        String command=scanner.nextLine();
        StringBuilder sb=new StringBuilder(text);

        while (!command.equals("Registration")){
            if (command.contains("Letters Lower")){
                String lowerL=sb.toString().toLowerCase();
                sb.delete(0,sb.length());
                sb.append(lowerL);
                System.out.println(sb);

            }else if (command.contains("Letters Upper")){
                String upperL= sb.toString().toUpperCase();
                sb.delete(0, sb.length());
                sb.append(upperL);
                System.out.println(sb);

            }else if (command.contains("Reverse")){
                int startIndex=Integer.parseInt(command.split(" ")[1]);
                int endIndex=Integer.parseInt(command.split(" ")[2]);
                StringBuilder reverseWord=new StringBuilder();
                if (startIndex >= 0 && endIndex <= sb.length()){
                    String reverse= sb.substring(startIndex,endIndex+1);
                    reverseWord.append(reverse).reverse();
                    System.out.println(reverseWord);
                }
            }else if (command.contains("Substring")){
                String substring=command.split(" ")[1];
                if (sb.toString().contains(substring)){
                    int startIndex=sb.indexOf(substring);
                    int endIndex=startIndex + substring.length();
                    sb.delete(startIndex,endIndex);
                    System.out.println(sb);
                }else{
                    System.out.printf("The username %s doesn't contain %s.\n", sb,substring);
                }

            }else if (command.contains("Replace")){
                String symbol=command.split(" ")[1];
                String replace=sb.toString().replace(symbol, "-");
                sb=new StringBuilder(replace);
                System.out.println(sb);

            }else if (command.contains("IsValid")){
                String symbol=command.split(" ")[1];
                if (sb.toString().contains(symbol)){
                    System.out.println("Valid username.");
                }else{
                    System.out.printf("%s must be contained in your username.\n", symbol);
                }
            }
            command=scanner.nextLine();
        }
    }
}
