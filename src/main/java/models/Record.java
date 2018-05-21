package models;

public class Record {
    public String artist;
    public String albumTitle;
    public int year;
    public int price;

    public Record(String artist, String albumTitle, int year, int price) {
        this.artist = artist;
        this.albumTitle = albumTitle;
        this.year = year;
        this.price = price;
    }

    public boolean yearSearch(int min, int max){
        if(this.year >= min && this.year <= max){
            return true;
        } else {
            return false;
        }
    }

    public boolean priceSearch(int min, int max){
        if (this.price >= min && this.price <= max){
            return true;
        } else {
            return false;
        }
    }

    public boolean artistSearch(String name){
        if (this.artist.equals(name)){
            return true;
        } else {
            return false;
        }
    }
}
