package model;

import java.util.Objects;

public class Book extends  Publication{
    public final static String TYPE =  "Książka";
   private String author;
   private int pages;
   private String isbn;

        public Book(int year, String title,String publisher, String author , int pages ,String isbn) {
        super(year, title, publisher);
        this.author = author;
        this.pages = pages;
        this.isbn = isbn;
    }



    @Override
    public String toString(){
            return super.toString()+" ; " + author +" ; "+ pages + " ; " + isbn;
    }

    @Override
    public String toCsv() {
        return TYPE + ";" + getTitle() + ";" + getPublisher() + ";" +
                getYear() + ";" + author + ";" + pages + ";" + isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return pages == book.pages && author.equals(book.author) && isbn.equals(book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author, pages, isbn);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }



    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }



    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
