import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations_11 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int firstNum=Integer.parseInt(scanner.nextLine());
        String operator=scanner.nextLine();
        int secondNum=Integer.parseInt(scanner.nextLine());

        DecimalFormat df=new DecimalFormat("0.##");

        double result=calculations(firstNum,secondNum,operator);

        System.out.println(df.format(result));
    }
    public static double calculations(int firstNum,int secondNum,String operator){
        double result=0;
            switch (operator){
                case "+":
                    result=firstNum+secondNum;
                    break;
                case "-":
                    result=firstNum-secondNum;
                    break;
                case "*":
                    result=firstNum*secondNum;
                    break;
                case "/":
                    result=firstNum*1.0/secondNum;
                    break;
            }
            return result;
    }
}
