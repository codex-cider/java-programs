import java.util.ArrayList;
import java.util.Scanner;

public class Bike {

    String company;
    String name;
    String cc;

    static ArrayList<Bike> bikes = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    void addDetailAndSave(){

        Bike bike = new Bike();
        System.out.println("Enter bike company ");
        bike.company = scanner.nextLine();

        // Name

        // CC

        bikes.add(bike);

    }

    void printBikes(){

        bikes.forEach(bike -> {
            System.out.println("Company -- "+bike.company);
        });



    }

    void init(){
        addDetailAndSave();
    }


}
