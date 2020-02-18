import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GuessTheNumber {

    int random(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    boolean check(int answer, int guessnumber){
        boolean result = false;
        if(answer == guessnumber){
            System.out.println("Congratulation");
            result = true;
        }
        else if(guessnumber < answer)
            System.out.println("Miss! To low");
        else
            System.out.println("Miss! To high");
        return result;
    }

    public static void main(String[] args){
        int min,max,number;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter range minimum ");
        min = scan.nextInt();
        System.out.println("Enter range maximum ");
        max = scan.nextInt();
        GuessTheNumber guess = new GuessTheNumber();
        number = guess.random(min,max);
        do{
            System.out.println("Enter number ");
        }
        while(!guess.check(number, scan.nextInt()));

    }
}
