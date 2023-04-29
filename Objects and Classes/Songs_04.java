import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs_04 {
        static class Song{
            String typeList;
            String name;
            String time;

            public Song (String typeList,String name, String time){
                this.typeList=typeList;
                this.name=name;
                this.time=time;
            }

            public String getName() {
                return this.name;
            }

            public String getTypeList() {
                return this.typeList;
            }
        }



    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());

        List<Song> songsList=new ArrayList<>();

        for (int i = 1; i <= n ; i++) {
            String input=scanner.nextLine();
            String [] inputSongsArr=input.split("_");
            String typeListInput=inputSongsArr[0];
            String nameInput=inputSongsArr[1];
            String timeInput=inputSongsArr[2];

            Song currentSong=new Song(typeListInput,nameInput,timeInput);

            songsList.add(currentSong);

        }
        String command=scanner.nextLine();
        if (command.equals("all")){
            for (Song item: songsList) {
                System.out.println(item.getName());
            }
        }else{
            for (Song item: songsList) {
                String currentTypeList=item.getTypeList();
                if (currentTypeList.equals(command)){
                    System.out.println(item.getName());
                }
            }
        }

    }
}
