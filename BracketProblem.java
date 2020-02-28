import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class BracketProblem {

    void countBrackets(Path directory){
        int countOpen = 0, countClose = 0;
        List<String> lines = null;
        try {
            lines = Files.readAllLines(directory);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(String line:lines){
            char[] characters = line.toCharArray();
            for (int i = 0; i < characters.length; i++) {
                if (characters[i] == '(')
                    countOpen++;
                if (characters[i] == ')')
                    countClose++;
            }
        }

        if (countOpen == countClose)
            System.out.println("There is the same number of brackets " + countOpen + " " + countClose);
        else
            System.out.println("There isn't");

    }

    public static void main(String[] args) {
        BracketProblem start = new BracketProblem();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter directory with file name ");
        Path directory = Paths.get(scan.next());
        start.countBrackets(directory);
    }

}
