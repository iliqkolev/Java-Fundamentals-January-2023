import java.util.Scanner;

public class WorldTour_01 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        //Hawai::Cyprys-Greece
        String allStops=scanner.nextLine(); //всички спирки
        StringBuilder stopsBuilder=new StringBuilder(allStops);

        String input=scanner.nextLine();
        while (!input.equals("Travel")){
            //команда
            if (input.contains("Add Stop")){
                //command="Add Stop:{index}:{string}:"
                //command=" Add Stop:2:Italy".split(":") -> ["Add Stop, "2", "Italy"]
                int index=Integer.parseInt(input.split(":")[1]);
                String stopName=input.split(":")[2];

                //[първия винаги е (0) до последния индекс (дължина - 1)]
                if (isValidIndex(index,stopsBuilder)){
                    stopsBuilder.insert(index,stopName);
                }

            }else if(input.contains("Remove Stop")){
                //command="Remove Stop:{start_index}:{end_index}":
                //command=" Remove Stop:11:16".split(":") -> ["Add Stop, "11", "16"]
                int startIndex=Integer.parseInt(input.split(":")[1]);
                int endIndex=Integer.parseInt(input.split(":")[2]);

                if (isValidIndex(startIndex, stopsBuilder) && isValidIndex(endIndex,stopsBuilder)){
                    stopsBuilder.delete(startIndex,endIndex + 1);
                }

            }else if(input.contains("Switch")){
                //command= "Switch:{old_string}:{new_string}"
                //command= "Switch:"Hawaii":"Bulgaria""
                String oldText=input.split(":")[1];
                String newText=input.split(":")[2];

                //!!!правим замяната на стария с новия само ако старият  съществува
                if (stopsBuilder.toString().contains(oldText)){
                    String updatedText=stopsBuilder.toString().replace(oldText,newText);
                    stopsBuilder=new StringBuilder(updatedText);
                }

            }
            System.out.println(stopsBuilder);
            input=scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + stopsBuilder);
    }
    public static  boolean isValidIndex(int index, StringBuilder stopsBuilder){
        return index >= 0 && index <=stopsBuilder.length() - 1;
        //return index >= 0 && index <stopsBuilder.length();
    }
}
