import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students_05 {
    static class Student{
            String firstname;
            String lastname;
            String age;
            String town;

            public Student(String firstname,String lastname, String age,String town){
                this.firstname=firstname;
                this.lastname=lastname;
                this.age=age;
                this.town=town;
            }

        public String getFirstname() { return this.firstname; }

        public String getLastname() {
            return this.lastname;
        }

        public String getAge() {
            return this.age;
        }

        public String getTown() {
            return this.town;
        }

    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String input=scanner.nextLine();

        List<Student> studentList=new ArrayList<>();

        while(!input.equals("end")){
            String [] studentsDataArr=input.split(" ");
            String firstname=studentsDataArr[0];
            String lastname=studentsDataArr[1];
            String age=studentsDataArr[2];
            String town=studentsDataArr[3];

            Student currentStudent=new Student(firstname,lastname,age,town);
            studentList.add(currentStudent);

            input=scanner.nextLine();
        }
        String homeTown=scanner.nextLine();

        for (Student student: studentList) {
            if (homeTown.equals(student.getTown())){
                System.out.printf("%s %s is %s years old\n",student.getFirstname(),student.getLastname(),student.getAge());
            }
        }


    }
}
