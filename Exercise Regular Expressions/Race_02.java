import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race_02 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String names=scanner.nextLine();
        List<String> racerNames= Arrays.stream(names.split(", "))
                                            .collect(Collectors.toList());
        Map<String, Integer> racerDistance=new LinkedHashMap<>();
        //име на състезател -> дистанция
        racerNames.forEach(racer -> racerDistance.put(racer, 0));

        String input=scanner.nextLine();

        //Regex -> Letter
        String letterRegex="[A-Za-z]";
        Pattern patternLetter=Pattern.compile(letterRegex);

        //Regex-> Number
        String digitRegex="[0-9]";
        Pattern patternDigit=Pattern.compile(digitRegex);


        while (!input.equals("end of race")){

            //input="G!32e%o7r#32g$235@!2e"
            //име на състезателя => само буквите
            StringBuilder nameBuilder=new StringBuilder(); //името на състезателя
            Matcher matcherLetter= patternLetter.matcher(input); //всички букви -> ["G", "e", "o", "r", "g", "e"]
            while (matcherLetter.find()){
                nameBuilder.append(matcherLetter.group());
            }

            //дистанция на състезателя -> сумата от цифрите които имаме
            int distance=0;
            Matcher matcherDigit=patternDigit.matcher(input);
            while (matcherDigit.find()){
                distance += Integer.parseInt(matcherDigit.group());
            }

            //? има ли такъв състезател -> добавяме дистанцията към състезателя
            String racerName=nameBuilder.toString();
            if (racerNames.contains(racerName)){
                //име на състезател -> дистанция
                int currentDistance=racerDistance.get(racerName);
                racerDistance.put(racerName,currentDistance + distance);
            }

            input=scanner.nextLine();
        }

        for (int index = 0; index < 3; index++) {
            String racer= racerNames.get(index);
            if (index == 0){
                System.out.printf("1st place: %s\n", racer);
            } else if (index == 1){
                System.out.printf("2nd place: %s\n", racer);
            }else if (index == 2){
                System.out.printf("3rd place: %s\n", racer);
            }
        }
    }
}
