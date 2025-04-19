/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author asus
 */
public class BookDTO {
    private String bookID;
    private String title;
    private String author;
    private int pushlistYear;
    private double price;
    private int quantity;

    public BookDTO() {
        this.bookID = "";
        this.title = "";
        this.author = "";
        this.pushlistYear = 0;
        this.price = 0;
        this.quantity = 0;
    
    
    }

    public BookDTO(String bookID, String title, String author, int pushlistYear, double price, int quantity) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.pushlistYear = pushlistYear;
        this.price = price;
        this.quantity = quantity;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPushlistYear() {
        return pushlistYear;
    }

    public void setPushlistYear(int pushlistYear) {
        this.pushlistYear = pushlistYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
