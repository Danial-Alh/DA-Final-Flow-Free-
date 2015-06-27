package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by Hosein on 6/28/2015.
 */
public class FileParser {

    String fileName;
    String inputData = "";

    public FileParser(String fileName)
    {
        this.fileName = fileName;

        getFile();

    }

    void getFile()
    {
        try {
            inputData = new Scanner(new File(fileName)).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            System.out.print("File empty!");
            System.exit(0);
        }
    }
}
