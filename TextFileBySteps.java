import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TextFileBySteps {

    void creatingFile(String directory, String name, String text) {
        String filePathAndName = (directory + name);
        FileWriter fileWrite = null;
        try {
            fileWrite = new FileWriter(directory + name, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileWrite.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TextFileBySteps start = new TextFileBySteps();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter path where You want to save file ");
        String directory = scan.next();
        System.out.println("Enter file name ");
        String name = scan.next();
        scan.nextLine();
        System.out.println("Enter text to write in file");
        String text = scan.nextLine();
        start.creatingFile(directory, name, text);

    }
}
