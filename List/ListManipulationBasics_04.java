import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics_04 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);


        List<Integer> numbers= Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command=scanner.nextLine();
         while (!command.equals("end")){
            if (command.contains("Add")){
                //command = "Add {numbers}" -> "Add 4".split(" ") -> ["Add" , "4"]
                //[1] - > "4" parseToInt -> 4

                int elementToAdd =Integer.parseInt(command.split(" ")[1]); ;//кой елемент ще добавя накрая на списъка
                numbers.add(elementToAdd);

            }else if(command.contains("RemoveAt")){

                int indexToRemove=Integer.parseInt(command.split(" ")[1]);
                numbers.remove(indexToRemove); // премахвам елемента да дадения индекс

            }else if(command.contains("Remove")){

                int elementToRemove=Integer.parseInt(command.split(" ")[1]);
                numbers.remove(Integer.valueOf(elementToRemove)); // показвам че искам да премахна елемента


            }else if(command.contains("Insert")){
                String[] commandParts=command.split(" "); // "Insert 2 3".split(" ") -> ["Insert", "2" ,"3]
                int number=Integer.parseInt(commandParts[1]);//"2" -> 2
                int index=Integer.parseInt(commandParts[2]); //"3" -> 3

                numbers.add(index, number);

            }

            command=scanner.nextLine();
         }

        /*for (int number:numbers) {
            System.out.print(number + " ");
        }
        */

        System.out.println(numbers.toString()
                .replace("[" , "")
                .replace("]" , "")
                .replace(",",""));

    }
}
