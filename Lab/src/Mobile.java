import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;
import java.util.Scanner;

public class Mobile {

    private static final int  TOTAL_MOBILES = 10;
    private static final Mobile[] mobiles = new Mobile[TOTAL_MOBILES];
    private static int currentIndex = -1;
    private static final Scanner scanner = new Scanner(System.in);
    private static File mobileData;

    private String name;
    private String brand;
    private String camera;

    Mobile(){
        try {
            mobileData = new File("mobiles.data");
            if(mobileData.createNewFile()){
                System.out.println("File Created");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    void start(){
        readMobileDataFromFile();
        int con = 1;
        do{
            menu();
            System.out.println("Wants to continue press 1 ");
            con = scanner.nextInt();
            scanner.nextLine();
        }while (con == 1);
    }

    private void menu(){
        int option;
        System.out.println("Choose any one ");
        System.out.println("Press 1 for add mobile ");
        System.out.println("Press 2 for print all mobile");
        option = scanner.nextInt();
        scanner.nextLine();
        switch (option){
            case 1-> addMobile();
            case 2-> printAllMobiles();
            default -> System.out.println("Wrong Option");
        }
    }

    private void addMobile(){
        // add data to array
        if(currentIndex >= TOTAL_MOBILES - 1){
            System.out.println("Stock Full");
        }else{
            int currentNumber = ++currentIndex;
            Mobile m = getMobileFromUser();
            mobiles[currentNumber] = m;
            // add data to file
            saveMobileToFile(m);
        }
    }

    private Mobile getMobileFromUser(){

        Mobile mobile = new Mobile();

        System.out.print("Enter Mobile Name ");
        mobile.name = scanner.nextLine();

        System.out.print("Enter Brand name ");
        mobile.brand = scanner.nextLine();

        System.out.print("Enter Camera ");
        mobile.camera = scanner.nextLine();

        return mobile;
    }

    private void saveMobileToFile(Mobile mobile){
        String mobileString = mobile.name+"|"+mobile.brand+"|"+mobile.camera;
        String encodedString = Base64.getEncoder().encodeToString(mobileString.getBytes()) + "\n";
        try {
            FileWriter fileWriter = new FileWriter(mobileData,true);
            fileWriter.append(encodedString);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printAllMobiles(){
        for (int i =0; i<= currentIndex; i++){
            System.out.println("/********************************/");
            System.out.println("Mobile Brand     " + mobiles[i].name );
            System.out.println("Mobile Name      " + mobiles[i].brand );
            System.out.println("Camera           " + mobiles[i].camera );
            System.out.println("/********************************/\n");
        }
    }

    static void readMobileDataFromFile(){
        try {
            Scanner mobileScanner = new Scanner(mobileData);

            int count = 0;
            while (mobileScanner.hasNextLine()){
                String encodedRow = mobileScanner.nextLine();
                byte[] decodedString = Base64.getDecoder().decode(encodedRow);
                String mobileRow = new String(decodedString);
                if(!mobileRow.isEmpty()){
                    String[] mobileArray = mobileRow.split("\\|");
                    mobiles[count] = new Mobile();
                    mobiles[count].name = mobileArray[0];
                    mobiles[count].brand = mobileArray[1];
                    mobiles[count].camera = mobileArray[2];
                    count++;
                    currentIndex++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
