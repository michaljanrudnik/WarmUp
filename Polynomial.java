import java.util.Arrays;
import java.util.Scanner;

public class Polynomial {

    void polyAsArray(String poly) {
        String polyOnlyDigits = poly.replaceAll("\\D+","");
        int[] polyArray = new int[polyOnlyDigits.length()];
        for (int i = 0; i < polyOnlyDigits.length(); i++) {
            polyArray[i] = Character.getNumericValue(polyOnlyDigits.charAt(i));
        }
        System.out.println(Arrays.toString(polyArray));
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Polynomial start = new Polynomial();
        String poly;
        System.out.println("Enter the polynomial example: 2x^2+3x+1");
        poly = scan.next();
        start.polyAsArray(poly);

    }
}
