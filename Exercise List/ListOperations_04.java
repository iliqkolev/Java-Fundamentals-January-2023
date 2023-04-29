import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations_04 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        List<Integer> numbers= Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command=scanner.nextLine();

        while(!command.equals("End")){

            if (command.contains("Add")) {
                int numberToAdd = Integer.parseInt(command.split("\\s+")[1]);
                numbers.add(numberToAdd);

            }else if(command.contains("Insert")){
                String [] commandParts=command.split("\\s+"); //Insert {index} {number}
                int numberToInsert=Integer.parseInt(commandParts[1]);
                int index=Integer.parseInt(commandParts[2]);
                //искам да вмъкна на индекс (index) числото (number)
                //1.проверявам в списък дали съществува такъв индекс
                //валиден индекс: от първия (0) до последния (дължината на листа - 1) индекс
                    if (index >= 0 && index <= numbers.size() - 1){
                        //валиден индекс
                        //2.добавям числото на дадения индекс
                        numbers.add(index,numberToInsert);
                    }else{
                        //невалиден индекс
                        System.out.println("Invalid index");
                    }

            }else if(command.contains("Remove")){
                int numberToRemove=Integer.parseInt(command.split("\\s+")[1]);
                //искам да вмъкна на индекс (index) числото (number)
                //1.проверявам в списък дали съществува такъв индекс
                //валиден индекс: от първия (0) до последния (дължината на листа - 1) индекс
                if (numberToRemove >= 0 && numberToRemove <=numbers.size() - 1){
                    //валиден индкес
                    //2.премахва числото на дадения индекс
                    numbers.remove(numberToRemove);
                }else{
                    //невалиден индекс
                    System.out.println("Invalid index");
                }

            }else if(command.contains("Shift left")){
                //command = "Shift left 5"
                int countShiftLeft=Integer.parseInt(command.split("\\s+")[2]);
                // повтаряме дадено нещо -> count на брой пъти
                for (int i = 1; i <=countShiftLeft ; i++) {
                    //първото число става първо
                    //{1, 23, 29, 18, 43, 21, 20}
                    //1.взимам кое е първото число
                    int firstNumber=numbers.get(0); //първото число от списъка

                    //2.премахвам първото число от списъка ->  //{23, 29, 18, 43, 21, 20}

                    numbers.remove(0);

                    //3.добавям го накрая на списъка ->  //{23, 29, 18, 43, 21, 20, 1}

                    numbers.add(firstNumber);
                }

            }else if(command.contains("Shift right")){
                //command = "Shift right 5"
                int countShiftRight=Integer.parseInt(command.split("\\s+")[2]);
                for (int i = 1; i <= countShiftRight ; i++) {
                    //последното число става първо
                    //{23, 29, 18, 43, 21, 20, 1}
                    //1.взимам последното число от списъка
                    int lastNumber=numbers.get(numbers.size() - 1); //последното число от списъка
                    //2.премахвам последното число от списъка
                        numbers.remove(numbers.size() - 1); //{23, 29, 18, 43, 21, 20}
                    //3.вмъквам последното число на първо място
                        numbers.add(0,lastNumber); //{1, 23, 29, 18, 43, 21, 20}
                }
            }

            command= scanner.nextLine();
        }

            //1 начин на отпечатване -> с цикъл
        for (int number:numbers) {
            System.out.print(number + " ");
        }

        //2 начин на отпечатване -> без цикъл

//        System.out.println(numbers.toString()   //[1, 23, 29, 18, 43, 21, 20]
//                .replace("[","")    //1, 23, 29, 18, 43, 21, 20]
//                .replaceAll("]","")  //1, 23, 29, 18, 43, 21, 20
//                .replace(",",""));      //1 23 29 18 43 21 20

    }
}
