import java.util.Scanner;

public class GrepURL {

    void count(String url){
        if (url.isEmpty())
            System.out.println("Thw URL is empty");

        int wordCount = 0;
        int endOfLine = url.length() - 1;
        boolean isWord = false;
        char[] characters = url.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            if (Character.isLetter(characters[i]) && i != endOfLine){
                isWord = true;
            }
            else if (!Character.isLetter(characters[i]) && isWord){
                wordCount++;
                isWord = false;
            }
            else if (Character.isLetter(characters[i]) && i == endOfLine){
                wordCount++;
            }
        }

        System.out.println("The URL has " + wordCount + " words");

    }

    public static void main(String[] args) {
        GrepURL start = new GrepURL();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter  URL");
        String url = scan.next();
        start.count(url);
    }
}
