import java.util.*;
import java.util.stream.Collectors;

public class Numbers_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int sum = 0;
        //намиране на сума
        for (int number : numbers) {
            sum += number;
        }
        // намиране на средноаритметична стойност
        double average = sum * 1.0 / numbers.size();

        //списък който съдържа числа по големи от средната стойност
        List<Integer> greaterElements = new ArrayList<>();


        for (int number : numbers) {
            if (number > average) {
                greaterElements.add(number);
            }
        }

        //когато намерим числата в списъка трябва да ги принтираме от най-голямо към най-малко
        Collections.sort(greaterElements);
        Collections.reverse(greaterElements);

        //имаме числа в списъка greaterElements
        if (greaterElements.size() > 0) {
            if (greaterElements.size() < 5) {
                System.out.print(greaterElements.toString() //[2, 4, 5, 6]
                        .replace("[", "")      // 2, 4, 5, 6]
                        .replace("]", "")      // 2, 4, 5, 6
                        .replace(",", ""));    // 2 4 5 6
            } else {
                //имаме повече от 5 числа които са по големи -> принтираме само първите 5
                int count = 0; //броим колко числа сме отпечатали
                for (int number : greaterElements) {
                    {
                        System.out.print(number + " ");
                        count++;

                        if (count == 5) {
                            break;
                        }
                    }
                }
            }
        } else {
            //нямаме числа в greaterElements
            System.out.println("No");
        }
    }
}
