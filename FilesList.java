import java.io.File;
import java.io.FilenameFilter;
import java.util.*;

public class FilesList {

    public void filesList(String type, File directory) {
        String[] list = directory.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(type);
            }
        });
        System.out.println("Lista plików :");
        for(String file : list) {
            System.out.println(file);
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter directory ");
        String directory = scan.next();
        System.out.println("Enter file type. Exampale .txt");
        String type = scan.next();
        FilesList ff = new FilesList();
        ff.filesList(type, new File(directory));
    }
}
