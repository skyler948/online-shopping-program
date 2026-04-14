package items;

import javax.swing.*;

public class BookItem extends Item {

    private String author;
    private String genre;
    private String type;
    private int pages;
    private int year;

    public BookItem(ImageIcon img, String name, float price, float weightKilograms,
                    String author, String genre, String type, int pages, int year) {
        super(img, name, price, weightKilograms);
        this.author = author;
        this.genre = genre;
        this.type = type;
        this.pages = Math.max(0, pages);
        this.year = year;

        category = "Book";
    }

    @Override
    public String getInformation() {
        return String.format("Author: %s\nGenre: %s\nPages: %d\nLength: %s\nYear: %d\n%s",
                author, genre, pages, getLength(), year, type);
    }

    public String getLength() {
        return (pages <= 250) ? "Short" :
               (pages <= 500) ? "Medium" :
               (pages <= 1000) ? "Long" : "Very Long";
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getType() {
        return type;
    }

    public int getPages() {
        return pages;
    }

    public int getYear() {
        return year;
    }

}
