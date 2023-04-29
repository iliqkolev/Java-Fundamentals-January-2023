import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced_05 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        List<Integer> numbers= Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command=scanner.nextLine();

        while (!command.equals("end")){

            if (command.startsWith("Contains")){
                //command="Contains 5".split(" ") -> ["Contains", "5"]
                int numberToCheck=Integer.parseInt(command.split(" ")[1]);
                printContains(numbers, numberToCheck);

            }else if(command.equals("Print even")){
                printEvenNumbers(numbers);

            } else if (command.equals("Print odd")) {
                printOddNumber(numbers);

            } else if (command.equals("Get sum")) {
                printSum(numbers);

            }else if (command.startsWith("Filter")){
                //command="Filter {condition} {number}" => "Filter >= 43".split(" ")
                //["Filter", ">=", "43"]
                String condition=command.split(" ")[1]; // '<', '>', ">=", "<="
                int numberToFilter=Integer.parseInt(command.split(" ")[2]); // "43"
                printFilterNumbers(numbers, condition, numberToFilter);
            }
            command=scanner.nextLine();
        }
    }

    public static void printContains(List<Integer> numbers, int numberToCheck) {
        //yes -> ако числото го има в списъка
        if (numbers.contains(numberToCheck)){
            System.out.println("Yes");
        }else{
            System.out.println("No such number");
        }
    }
    public static void printEvenNumbers(List<Integer> numbers){
        //numbers= {4,19,2,53,6,43}
        for (int number: numbers) {
            if (number % 2 == 0){
                System.out.print(number + " ");
            }

        }
        System.out.println();
    }
    public static void printOddNumber(List<Integer> numbers){
        //numbers= {4,19,2,53,6,43}
        for (int number: numbers) {
            if (number % 2 != 0){
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }
    public static void printSum(List <Integer> numbers){
        int sum=0;
        for (int number: numbers){
            sum += number;
        }
        System.out.println(sum);
    }
    public static void printFilterNumbers(List<Integer> numbers, String condition, int numberToFilter) {
        //condition= '<', '>', ">=", "<="
            switch (condition){
                case "<":
                    //отпечатвам всички числа от списъка numbers < numberToFilter
                    for (int number: numbers) {
                        if (number < numberToFilter){
                            System.out.print(number  + " ");
                        }
                    }
                    System.out.println();
                    break;

                case ">":
                    for (int number: numbers) {
                        if (number > numberToFilter){
                            System.out.print(number  + " ");
                        }
                    }
                    System.out.println();
                    break;


                case ">=":
                    for (int number: numbers) {
                        if (number >= numberToFilter){
                            System.out.print(number  + " ");
                        }
                    }
                    System.out.println();
                    break;

                case "<=":
                    for (int number: numbers) {
                        if (number <= numberToFilter){
                            System.out.print(number  + " ");
                        }
                    }
                    System.out.println();
                    break;
            }
    }
}
