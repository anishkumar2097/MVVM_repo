package com.example.booklibrary;

import java.util.List;

public class Book {


    //  @SerializedName("totalItems")
    int totalItems;
    //    @SerializedName("title")
    String title;

    //   @SerializedName("subtitle")
    String subtitle;

    //     @SerializedName("authors")
    List<String> authors;

    //   @SerializedName("description")
    String description;

    //    @SerializedName("categories")
    String categories;


    //  "smallThumbnail":"http://books.google.com/books/content?id=8Pr_kLFxciYC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api",
    //
    //         "thumbnail":"http://books.google.com/books/content?id=8Pr_kLFxciYC&printsec=frontcover&img=1&zo
    //  @SerializedName("thumbnail")
    String imageLinks;

    //   @SerializedName("")
    double amount;    //showing retail price
    //   @SerializedName("buyLink")
    String buyLink;


    public Book(String title, String subtitle, String description, List<String> authors, double price, String imageLinks) {
        //this.totalItems = totalItems;
        this.amount = price;
        this.subtitle = subtitle;
        this.title = title;
        this.description = description;
        this.imageLinks = imageLinks;


    }

    public String geBookTitle() {
        return title + " : " + subtitle;
    }


    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        authors = authors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(String imageLinks) {
        this.imageLinks = imageLinks;
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getBuyLink() {
        return buyLink;
    }

    public void setBuyLink(String buyLink) {
        this.buyLink = buyLink;
    }
}
