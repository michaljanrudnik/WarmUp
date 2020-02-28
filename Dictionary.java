import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {

    void suggestWord(String word){
        //URL url = getClass().getResource("dictionary.txt");
        Scanner s = null;
        try {
            s = new Scanner(new File("C:\\Users\\Rudolf\\IdeaProjects\\WarmUp\\src\\dictionary.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext()){
            list.add(s.next());
        }
        s.close();

        for (String search:list){
            if(search.matches(word + ".*"))
                System.out.println(search);
        }

    }


    public static void main(String[] args) {
        Dictionary start = new Dictionary();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter begin of word");
        String word = scan.next();
        start.suggestWord(word);
    }
}
