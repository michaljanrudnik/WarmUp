import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Person {
    String name;
    String surname;
    int age;

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    String getName() {
        return name;
    }

    String getSurname() {
        return surname;
    }

    int getAge() {
        return age;
    }

    void setName(String name) {
        this.name = name;
    }

    void setSurname(String surname) {
        this.surname = surname;
    }

    void setAge(int age) {
        this.age = age;
    }

}

public class CsvToObject {

    public void csvReader(Path fileName) {
        List<String> parseCSV = null;
        try {
            parseCSV = Files.readAllLines(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Person[] persons = new Person[parseCSV.size()];
        int counter = 0;
        //System.out.println(Arrays.toString(parseCSV.toArray()));
        for (int i = 0; i < parseCSV.size(); i++) {
            System.out.println(parseCSV.get(i));
            String[] CSVLineArray = parseCSV.get(i).split(",");
            persons[counter] = new Person(CSVLineArray[1],CSVLineArray[2],Integer.parseInt(CSVLineArray[3]));
            counter++;
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter directory with file name ");
        Path directory = Paths.get(scan.next());
        CsvToObject ff = new CsvToObject();
        ff.csvReader(directory);
    }
}
