import java.util.*;
import java.util.stream.Collectors;

public class exercise_2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int[] archeryField = Arrays.stream(scanner.nextLine().split("\\|"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int collectedTournamentPoints = 0;
        String userInput = scanner.nextLine();

        while (!userInput.equals("Game over")) {

            String command = commandExtractor(userInput);
            switch (command) {
                case "Shoot":
                    collectedTournamentPoints += executeShootCommand(userInput, archeryField);
                    break;
                case "Reverse":
                    executeReverseCommand(archeryField);
                    break;
            }

            userInput = scanner.nextLine();
        }
        /*
         * Обърни внимание, че когато подготяме някакъв String, в него НЕ поставямв нови редове
         * те са си проблем на тоя който вика нашия метод. Ние само осигуряваме String, a caller-а
         * да си го печата/праща/сортира/конкатинира или прави каквото реши за уместно.
         * Ние даваме само plain Sting.
         * */
        System.out.println(convertArcheryFieldToString(archeryField));
        System.out.println("John finished the archery tournament with " + collectedTournamentPoints + " points!");

    }

    private static String convertArcheryFieldToString(int[] archeryField) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < archeryField.length; i++) {
            sb.append(archeryField[i]);
            if (i + 1 < archeryField.length) {
                sb.append(" - ");
            }
        }
        return sb.toString();
    }

    private static int executeShootCommand(String userInput, int[] archeryField) {
        String[] splitCommand = userInput.split("\\s+");
        String commandInstructions = splitCommand[2]; //commandInstructions now looks like: "Left@0@2" or "Right@6@5"
        String[] tokenizedCommand = commandInstructions.split("@");
        String walkDirections = splitCommand[1];
        int startWalkingAtPosition = Integer.parseInt(tokenizedCommand[1]);
        int stepsToTake = Integer.parseInt(tokenizedCommand[2]);
        int reslut = 0;

        if (!(startWalkingAtPosition >= 0 && startWalkingAtPosition < archeryField.length)) {
            //ignore the command and return 0 as we gave promise to the caller that will return an int value
            return 0;
        }

        /*
        the startWalkingAtPosition is valid and is inside the archeryField
        We need to do the walk and determine at witch target we need to pint our bow
        and do the rest of the instructions as per task
        */

        int targetIndex = startWalkingAtPosition;
        /*
         * The following line of code is not a must but will reduce extra spins in loops
         * caused by the times that you might be forced to walk the archeryField and
         * practically doing nothing but just counting steps while walking. Since we know
         * the exact length of the archeryField and thanks to the Maths magic of Modulo we can tell how many
         * full circles you will have to walk in archeryField and prevent you those extra "k" full spins;
         *
         * */

        stepsToTake = stepsToTake % archeryField.length; //optimize the code a bit you can ignore it if you want.
        if (walkDirections.equals("Left")) {
            for (int walkedSteps = 0; walkedSteps < stepsToTake; walkedSteps++) {
                if (targetIndex == 0) {
                    targetIndex = archeryField.length - 1;
                    continue;
                }
                targetIndex--; //Заради факта, че трябва да се местим наляво.
            }
        } else  if (walkDirections.equals("Right")){
            for (int walkedSteps = archeryField.length-1; walkedSteps > 0; walkedSteps--) {
                if (targetIndex == archeryField.length - 1) {
                    targetIndex = 0;
                    continue;
                }
                targetIndex++; //Защото се движим "надясно" и това изисквам индекса да расте с по една на всяка крачка
            }
        }
        /*
         * Next we gonna do is to extract and target's health status and see how much blood it had :)
         * Based on the result we will update the targets healthLevel and will assign tournamentPoints
         * to our archer. Keep in mind that the max pints the archer can get is +5 per hit. And special
         * hit gain condition applies in case the target's HP is less than 5 points;
         * */

        int targetHealthLevel = archeryField[targetIndex];
        if (targetHealthLevel >= 5) {
            archeryField[targetIndex] = targetHealthLevel - 5;
            reslut = 5;
        } else {
            archeryField[targetIndex] = 0;
            reslut = targetHealthLevel;
        }
        return reslut;
    }

    private static void executeReverseCommand(int[] archeryField) {
        for (int i = 0; i < archeryField.length / 2; i++) {
            int tempValue = archeryField[archeryField.length - 1 - i];
            archeryField[archeryField.length - 1 - i] = archeryField[i];
            archeryField[i] = tempValue;
        }
    }

    private static String commandExtractor(String userInput) {
        String[] command = userInput.split("\\s+");
        return command[0];
    }

}