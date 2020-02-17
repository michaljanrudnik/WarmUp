import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CsvToObject {

    public void csvReader(Path fileName) {
        List<String> parseCSV = null;
        try {
            parseCSV = Files.readAllLines(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(parseCSV.toArray()));

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter directory with file name ");
        Path directory = Paths.get(scan.next());
        CsvToObject ff = new CsvToObject();
        ff.csvReader(directory);
    }
}
