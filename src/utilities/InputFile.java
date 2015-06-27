package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by Hosein on 6/27/2015.
 */
public class InputFile {

    String getFile() {
        String myFileName = "";
        String inputData = "";

        System.out.println("Enter input file name (without format): ");
        Scanner in = new Scanner(System.in);
        myFileName = in.nextLine();
        myFileName += ".txt";
        try {
            inputData = new Scanner(new File(myFileName)).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            System.out.print("File empty!");
            System.exit(0);
        }
        return inputData;
    }

    void writeFile(String outputData) {

    }

}

