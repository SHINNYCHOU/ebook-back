package com.ebook.demo.base;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "cart")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String book;
    private double price;
    private int number;
    @Column(name = "goodtotle")
    private double goodTotal;
    public cart(){ }
    public cart(String name,String book,double price,int number){
        this.name=name;
        this.book=book;
        this.price=price;
        this.number=number;
        this.goodTotal=number*price;
    }
    public int getId(){return  id;}

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBook() {
        return book;
    }

    public String getName() {
        return name;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGoodTotal() {
        return goodTotal;
    }

    public void setGoodTotal(double goodTotal) {
        this.goodTotal = goodTotal;
    }
}
