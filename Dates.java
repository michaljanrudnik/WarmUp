import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

class DateAndNote {

    private Date dateAndHour;
    private String note;

    public DateAndNote() {

    }

    public DateAndNote(Date dateAndHour, String note) {
        this.dateAndHour = dateAndHour;
        this.note = note;
    }

    public Date getDateAndHour() {
        return dateAndHour;
    }

    public void setDateAndHour(Date dateAndHour) {
        this.dateAndHour = dateAndHour;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

public class Dates {

    public List<DateAndNote> readFile() {
        List<String> reader = new ArrayList<>();
        List<DateAndNote> dateList = new ArrayList<>();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        try {
            reader = Files.readAllLines(Paths.get("C:\\Users\\Rudolf\\IdeaProjects\\WarmUp\\src\\dates.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < reader.size(); i++) {
            String temp = reader.get(i);
            DateAndNote dateNotes = null;
            try {
                dateNotes = new DateAndNote(sdf1.parse(temp.substring(0,16)),temp.substring(17));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            dateList.add(dateNotes);
        }
        return dateList;
    }

    public void writeFile(List<DateAndNote> dateList) {
        List<String> writeList = new ArrayList<>();
        FileWriter fileWrite = null;
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd HH:mm");

        try {
            fileWrite = new FileWriter("C:\\Users\\Rudolf\\IdeaProjects\\WarmUp\\src\\dates.txt", false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < dateList.size(); i++) {
            writeList.add(sdf1.format(dateList.get(i).getDateAndHour()) + " " + dateList.get(i).getNote());
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

    public void showDates() {
        List<DateAndNote> datesToPrint = readFile();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd HH:mm");

        for (int i = 0; i <datesToPrint.size(); i++) {
            System.out.println(sdf1.format(datesToPrint.get(i).getDateAndHour()) + " " + datesToPrint.get(i).getNote());
        }
    }

    public void addDate() {
        List<DateAndNote> listOfDates = readFile();
        DateAndNote temp = new DateAndNote();
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd HH:mm");

        System.out.println("Enter date and hour (e.g. 2012.01.02 11:22)");
        try {
            temp.setDateAndHour(sdf1.parse(scan.nextLine()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Enter note");
        temp.setNote(scan.nextLine());

        listOfDates.add(temp);

        writeFile(listOfDates);
    }

    public void sortDate() {

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Dates start = new Dates();
        boolean exit = false;
        int choice;

        while(!exit) {
            System.out.println("Menu");
            System.out.println("1. Show dates");
            System.out.println("2. Add date");
            System.out.println("3. Sort and show");
            System.out.println("0. Exit");

            choice = scan.nextInt();

            switch(choice) {
                case 1 :
                    start.showDates();
                    break;
                case 2 :
                    start.addDate();
                    break;
                case 3 :

                    break;
                case 0 :
                    exit = true;
                    break;
            }
        }
    }

}
