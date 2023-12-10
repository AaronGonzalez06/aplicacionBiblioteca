package com.mycompany.bibliotecaproyecto.models;

public class BookApi {
    
    private String image;
    private String author;
    private String title;
    private Integer year;
    private Integer pages;
    private String category;
    private int isbn;
    private String summary;

    public BookApi(String image, String author, String title, Integer year, Integer pages, String category, int isbn, String summary) {
        this.image = image;
        this.author = author;
        this.title = title;
        this.year = year;
        this.pages = pages;
        this.category = category;
        this.isbn = isbn;
        this.summary = summary;
    }
    
    

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
