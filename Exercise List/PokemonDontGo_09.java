import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo_09 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        List<Integer> numbers= Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        //повтаряме: въвеждаме индекс
        //стоп: когато нямаме елементи в списъка (numbers.size <= 0)
        //продължаваме: имаме елементи в списъка

        int sum=0; //сума на премахнатите елементи

        while (numbers.size() > 0){
            int index=Integer.parseInt(scanner.nextLine());
            //1. индекс < 0
                if (index < 0){
                    //1. взимам кой е първия елемент в списъка
                    int firstElement=numbers.get(0);
                    //2.премахвам елемента от първото място -> сумиране
                        numbers.remove(0);
                        sum += firstElement;
                    //3.взимам кой е последния елемент в списъка
                        int lastElement= numbers.get(numbers.size() - 1);
                    //4. ще сложим последния елемент на първо място
                        numbers.add(0,lastElement);
                    //5.модификация спрямо премахнатия елемент
                        modifyList(numbers, firstElement);
                }


            //2. индекс > последния индекс в списъка
                else if (index > numbers.size() - 1){
                    //1. взимаме последния индекс
                        int lastElement=numbers.get(numbers.size() - 1);
                    //2.премахваме го -> сумиране
                        numbers.remove(numbers.size() - 1);
                        sum +=lastElement;
                    //3. взимаме първия елемент
                        int firstElement=numbers.get(0);
                    //4.вкъкваме първия елемент на последно място в списъка
                        numbers.add(firstElement);
                    //5. модифицираме списъка спрямо премахнатия елемент
                    modifyList(numbers, lastElement);

                }


            //3.индекс да е валиден - > индекс >= 0 и индекс<=последния
                else if (index >= 0 && index <= numbers.size() - 1) {
                    //1. взимам кой е елемента на дадения индекс
                    int removedNumber=numbers.get(index);
                    sum +=removedNumber;
                    //2.премахваме елемента от дадения индекс
                    numbers.remove(index);
                    //3.модифицирам списъка спрямо премахнатото число
                    modifyList(numbers,removedNumber);
                }
        }

        System.out.println(sum);
    }

    private static void modifyList(List<Integer> numbers, int removedNumber) {
        for (int index = 0; index <= numbers.size() - 1 ; index++) {
            int currentElement=numbers.get(index); // текущ елемент
            if (currentElement <= removedNumber){
                currentElement +=removedNumber;
            }else{
                currentElement -=removedNumber;
            }

            numbers.set(index, currentElement);

        }
    }
}
