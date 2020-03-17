import java.lang.reflect.Array;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DealingCards {
    final String[] DECK = {"9Clubs", "9Diamonds", "9Hearts", "9Spades", "10Clubs", "10Diamonds", "10Hearts", "10Spades", "JackClubs", "JackDiamonds", "JackHearts", "JackSpades",
            "QueenClubs", "QueenDiamonds", "QueenHearts", "QueenSpades", "KingClubs", "KingDiamonds", "KingHearts", "KingSpades", "AceClubs", "AceDiamonds", "AceHearts", "AceSpades"};

    void dealing(int players) {
        List<String> cards = new ArrayList<String>(Arrays.asList(DECK));
        String[][] distribution = new String[players][DECK.length / players];

        for (int i = 0; i < DECK.length / players; i++) {
            for (int j = 0; j < players; j++) {
                distribution[j][i] = cards.remove(ThreadLocalRandom.current().nextInt(0, cards.size()));
            }
        }
        print(distribution);
    }

    void print(String[][] toPrint) {
        for (int i = 0; i < toPrint.length; i++) {
            System.out.println("Player number " + (i+1));
            for (int j = 0; j < toPrint[0].length; j++) {
                System.out.print(toPrint[i][j] + " ");
            }
            System.out.println(" ");
            System.out.println(" ");
        }
    }



    public static void main(String[] args) {
        DealingCards start = new DealingCards();
        Scanner scan = new Scanner(System.in);
        int count;
        System.out.println("Enter number of players - max 4");
        count = scan.nextInt();
        start.dealing(count);
    }

}
