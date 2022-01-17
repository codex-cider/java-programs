import java.io.*;
import java.util.*;


public class Bike {
    String company;
    String name;
    String cc;
    static int currentIndex = -1;
    static ArrayList<Bike> bikesArray = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static File bikeData;

    Bike() {
        bikeData = new File("bike");
        try {
            if (bikeData.createNewFile()) {
                System.out.println("File is Created");
            } else {
                System.out.println(" ");
            }
        } catch (IOException e) {
            System.out.println("can't create File");
        }
    }

    void start() {

        System.out.println("Press 1 to Add Bike Details: ");
        System.out.println("Press 2 to Print Bike Details: ");
        System.out.println("Press 3 to Search Bike : ");
        int option = sc.nextInt();
        sc.nextLine();
        switch (option) {
            case 1 -> addBike();
            case 2 -> printBikeDetails();
            case 3 -> searchBike();
            default -> System.out.println("Enter Valid Option ");

        }
    }

    void init() {
        readBikeDataFromFile();
        int continueProcess;

        do {
            start();
            System.out.print("press 1 to continue: ");
            continueProcess = sc.nextInt();
        } while (continueProcess == 1);
    }

    void addBike() {
        Bike bikes = new Bike();
        System.out.println("Enter bikes name: ");
        bikes.name = sc.nextLine();
        System.out.println("Enter bikes Company: ");
        bikes.company = sc.nextLine();
        System.out.println("Enter Engine CC: ");
        bikes.cc = sc.nextLine();
        String bikeData = (bikes.name + "|" + bikes.company + "|" + bikes.cc+"\n");
        bikesArray.add(bikes);
        addBikeDetailsToFile(bikeData);
    }

    void printBikeDetails() {
        bikesArray.forEach(bikes1 -> {
            System.out.println("Company: " + bikes1.company);
            System.out.println("name: " + bikes1.name);
            System.out.println("Engine Cc : " + bikes1.cc);
        });
    }

    void addBikeDetailsToFile(String data) {
        try {
            FileWriter fileWriter = new FileWriter(bikeData, true);
            //fileWriter.write(data);
            //System.out.println(data);
            fileWriter.write(data);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("file can't be Written");
        }
    }

    static void readBikeDataFromFile() {
        try {
            Scanner bikeScanner = new Scanner(bikeData);

            int count = 0;
            while (bikeScanner.hasNextLine()) {
                String studentRow = bikeScanner.nextLine();
                if (!studentRow.isEmpty()) {
                    String[] BikeArray = studentRow.split("\\|");
                    bikesArray.set(count, new Bike());
                    bikesArray.get(count).name = BikeArray[0];
                    bikesArray.get(count).company = BikeArray[1];
                    bikesArray.get(count).cc = BikeArray[2];
                    count++;
                    currentIndex++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void searchBike() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Bike Name : ");
        String bikeName = scanner.nextLine();
        for (int i = 0; i < currentIndex; i++) {
            if (bikeName.equalsIgnoreCase(bikesArray.get(i).name))
                System.out.println(bikesArray.get(i).name);
            break;
        }

    }

    void printBike(int i) {
        if (i >= 0) {
            System.out.println("/********************************/");
            System.out.println("Bike Name     " + bikesArray.get(i).name);
            System.out.println("Bike Company     " + bikesArray.get(i).company);
            System.out.println("Engine cc         " + bikesArray.get(i).cc);
            System.out.println("/********************************/\n");

        }
    }


}
// make delete funct
// after delete erase file writer and write all array list data
