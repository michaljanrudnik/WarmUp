import java.io.File;
import java.util.Scanner;

public class FileFinder {

    public void findFile(String name, File file) {
        File[] list = file.listFiles();
        if(list != null)
            for (File fil : list) {
                if (fil.isDirectory()) {
                    findFile(name,fil);
                }
                else if (name.equalsIgnoreCase(fil.getName())) {
                    System.out.println(fil.getParentFile());
                }
            }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the directory where to search... ");
        String directory = scan.next();
        System.out.println("Enter file name to be searched ");
        String name = scan.next();
        FileFinder ff = new FileFinder();
        ff.findFile(name, new File(directory));

    }
}
