import java.util.Scanner;

public class Student {

    static final int  TOTAL_STUDENT = 10;
    static Student[] students = new Student[TOTAL_STUDENT];
    static int currentIndex = -1;
    static Scanner scanner = new Scanner(System.in);
    String name;
    String mobile;
    String rollNo;
    String dob;

    void start(){
        int option;
        System.out.println("\n");
        System.out.println("Enter 1 fot Add Student");
        System.out.println("Enter 2 for Print All Student");
        option = scanner.nextInt();
        switch (option) {
            case 1 -> addStudent();
            case 2 -> printStudent();
            default -> System.out.println("Not a Valid option");
        }
    }

    void init(){
        int continueProcess = 0;
        do{
            start();
            System.out.print("Wants to continue press 1");
            continueProcess = scanner.nextInt();
        }while (continueProcess == 1);
    }

    void addStudent(){

        if(currentIndex >= TOTAL_STUDENT - 1){
            System.out.println("Seat is full");
        }else{
            int studentNumber = ++currentIndex;
            students[studentNumber] = new Student();

            scanner.nextLine();

            System.out.print("Enter Student Name ");
            students[studentNumber].name = scanner.nextLine();

            System.out.print("Enter Student Mobile ");
            students[studentNumber].mobile = scanner.nextLine();

            System.out.print("Enter Student Roll No. ");
            students[studentNumber].rollNo = scanner.nextLine();

            System.out.print("Enter Student DOB ");
            students[studentNumber].dob = scanner.nextLine();
        }

    }

    void printStudent(){
        for (int i =0; i<= currentIndex; i++){
            System.out.println("/********************************/");
            System.out.println("Student Name     " + students[i].name );
            System.out.println("Student Roll No. " + students[i].name );
            System.out.println("Student Mobile   " + students[i].name );
            System.out.println("Student DOB      " + students[i].name );
            System.out.println("/********************************/\n");
        }
    }

}
