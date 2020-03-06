import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;
import java.nio.file.Paths;

public class BooksCatalog {

    public List<String> readFile() {
        List<String> readed = null;

        try {
            readed = Files.readAllLines(Paths.get("C:\\Users\\Rudolf\\IdeaProjects\\WarmUp\\src\\bookcatalog.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readed;
    }

    public void writeFile(List<String> writeList) {
        FileWriter fileWrite = null;
        try {
            fileWrite = new FileWriter("C:\\Users\\Rudolf\\IdeaProjects\\WarmUp\\src\\bookcatalog.txt", false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String s : writeList) {
            try {
                fileWrite.write(s + System.lineSeparator());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fileWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCatalog() {
        List<String> printList = readFile();
        System.out.println("No. | Title | Author | Release Date");

        for (int i = 0; i < printList.size(); i++) {
            String[] parse = printList.get(i).split(",");
            System.out.println(i + " | " + parse[0] + " | " + parse[1] + " | " + parse[2]);
        }
    }

    public void addBook() {
       List<String> addList = readFile();
       Scanner scan = new Scanner(System.in);
       String[] temp = new String[3];

       System.out.println("Enter the title");
       temp[0] = scan.nextLine();
       System.out.println("Enter author name and surname");
       temp[1] = scan.nextLine();
       System.out.println("Enter release date (year)");
       temp[2] = scan.nextLine();
       addList.add(String.join(",",temp));

       writeFile(addList);
    }

    public void deleteBook() {
        Scanner scan = new Scanner(System.in);
        showCatalog();
        List<String> deleteList = readFile();
        System.out.println("Enter position number of book You want to delete");
        deleteList.remove(scan.nextInt());

        writeFile(deleteList);
    }

    public void searchBook() {
        List<String> searchList = readFile();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter title/author/release date of book");
        String search = scan.next();
        for (int i = 0; i < searchList.size(); i++) {
            if (searchList.get(i).toLowerCase().contains(search.toLowerCase())) {
                System.out.println(i + " | " + searchList.get(i));
            }
        }
    }



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BooksCatalog start = new BooksCatalog();
        boolean exit = false;
        int choice;

        while(!exit) {
            System.out.println("Menu");
            System.out.println("1. Show catalog");
            System.out.println("2. Add book");
            System.out.println("3. Delete book");
            System.out.println("4. Search book");
            System.out.println("0. Exit");

            choice = scan.nextInt();

            switch(choice) {
                case 1 :
                    start.showCatalog();
                    break;
                case 2 :
                    start.addBook();
                    break;
                case 3 :
                    start.deleteBook();
                    break;
                case 4 :
                    start.searchBook();
                    break;
                case 0 :
                    exit = true;
                    break;
            }
        }
    }
}
