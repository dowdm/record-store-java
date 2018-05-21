import models.Record;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        boolean programRunning = true;

        Record ronnieCuber = new Record("Ronnie Cuber", "Cuber Libre", 1976, 20);
        Record lilB = new Record("lil B", "I'm Thraxx", 2009, 18);
        Record meltBanana = new Record("Melt Banana", "Cactuses Come In Flocks", 1994, 78);
        Record flyingLotus = new Record("Flying Lotus", "1983", 2006, 21);

        ArrayList<Record> allRecords = new ArrayList<Record>();

        allRecords.add(ronnieCuber);
        allRecords.add(lilB);
        allRecords.add(meltBanana);
        allRecords.add(flyingLotus);

        while(programRunning) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Welcome to Matt and Matt's record emporium. Please enter one of the following options: View All Records, Search By Year, Search By Price, Search By Artist, Add A Record, or Exit");

            try {

                String navigationChoice = bufferedReader.readLine();

                if (navigationChoice.equals("View All Records")) {
                    for (Record individualRecord : allRecords) {
                        System.out.println("__________________________");
                        System.out.println("Artist: " + individualRecord.artist);
                        System.out.println("Title: " + individualRecord.albumTitle);
                        System.out.println("Year: " + individualRecord.year);
                        System.out.println("Price: $" + individualRecord.price);
                    }
                } else if (navigationChoice.equals("Search By Year")) {
                    System.out.println("What is the latest year you're interested in?");
                    int maxYear = Integer.parseInt(bufferedReader.readLine());
                    System.out.println("What is the earliest year you're interested in?");
                    int minYear = Integer.parseInt(bufferedReader.readLine());
                    for (Record individualRecord : allRecords) {
                        if (individualRecord.yearSearch(minYear, maxYear)) {
                            System.out.println("__________________________");
                            System.out.println("Artist: " + individualRecord.artist);
                            System.out.println("Title: " + individualRecord.albumTitle);
                            System.out.println("Year: " + individualRecord.year);
                            System.out.println("Price: $" + individualRecord.price);
                        }
                    }

                } else if (navigationChoice.equals("Search By Price")) {
                    System.out.println("What is your price ceiling?");
                    int maxPrice = Integer.parseInt(bufferedReader.readLine());
                    System.out.println("What is your price floor?");
                    int minPrice = Integer.parseInt(bufferedReader.readLine());
                    for (Record individualRecord : allRecords) {
                        if (individualRecord.priceSearch(minPrice, maxPrice)) {
                            System.out.println("__________________________");
                            System.out.println("Artist: " + individualRecord.artist);
                            System.out.println("Title: " + individualRecord.albumTitle);
                            System.out.println("Year: " + individualRecord.year);
                            System.out.println("Price: $" + individualRecord.price);
                        }
                    }
                } else if (navigationChoice.equals("Search By Artist")) {
                    System.out.println("What artist would you like to find?");
                    String searchedArtist = bufferedReader.readLine();
                    for (Record individualRecord : allRecords) {
                        if (individualRecord.artistSearch(searchedArtist)) {
                            System.out.println("__________________________");
                            System.out.println("Artist: " + individualRecord.artist);
                            System.out.println("Title: " + individualRecord.albumTitle);
                            System.out.println("Year: " + individualRecord.year);
                            System.out.println("Price: $" + individualRecord.price);
                        }
                    }

                } else if(navigationChoice.equals("Add A Record")) {
                    System.out.println("Let's add a record. First, please enter the artist name.");
                    String userArtist = bufferedReader.readLine();
                    System.out.println("Please enter the album title.");
                    String userAlbumTitle = bufferedReader.readLine();
                    System.out.println("Please enter the release year.");
                    int userYear = Integer.parseInt(bufferedReader.readLine());
                    System.out.println("Please enter the price.");
                    int userPrice = Integer.parseInt(bufferedReader.readLine());
                    Record userRecord = new Record(userArtist, userAlbumTitle, userYear, userPrice);
                    allRecords.add(userRecord);
                    System.out.println("Cool! Your record has been added.");
                } else if (navigationChoice.equals("Exit")){
                    programRunning = false;
                } else {
                    System.out.println("Say whaaaaaaaaa???");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
