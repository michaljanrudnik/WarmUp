import java.util.Scanner;

public class MultilanguageMenu {

    void menu(String lang) {
        Scanner scan = new Scanner(System.in);
        boolean exit = false;
        int choice;
        String[] english = {"Start", "Save", "Load", "Exit"};
        String[] polish = {"Start", "Zapisz", "Wczytaj", "Wyjście"};
        String[] menu = new String[4];
        switch (lang) {
            case "english" :
                menu = english;
                break;
            case "polish" :
                menu = polish;
                break;
        }

        while (!exit){
            System.out.println("1. " + menu[0]);
            System.out.println("2. " + menu[1]);
            System.out.println("3. " + menu[2]);
            System.out.println("4. " + menu[3]);
            choice = scan.nextInt();

            switch (choice) {
                case 1 :
                    System.out.println(menu[0]);
                    break;
                case 2 :
                    System.out.println(menu[1]);
                    break;
                case 3 :
                    System.out.println(menu[2]);
                    break;
                case 4 :
                    System.out.println(menu[3]);
                    exit = true;
                    break;
            }
        }

    }

    public static void main(String[] args) {
        MultilanguageMenu start = new MultilanguageMenu();
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose language polish/english");
        String lang = scan.nextLine();
        start.menu(lang);

    }
}
