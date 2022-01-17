import java.util.Scanner;

public class sdf {
    static final int TOTAL_STUDENTS=10;
    static int currentIndex=-1;
    static Student student[] = new Student[TOTAL_STUDENTS];
    static Scanner sc = new Scanner(System.in);

    String name;
    String mobile;
    String roll_number;
    String dob;
    void start(){
        int option;


        System.out.println("press 1 to Add Students"+"\n"+"press 2 to print all Students");
        option = sc.nextInt();
        switch(option){
            case 1 :
                addStudent();
                break;
            case 2 :
                System.out.println("call print Students");
                break;
            default:
                System.out.println("not a valid option");

        }}
    void addStudent(){
        int StudentNumber=currentIndex++;
        student[StudentNumber]= new Student();
        System.out.print("Enter Student Name: ");
        student[StudentNumber].name = sc.nextLine();
    }

}
