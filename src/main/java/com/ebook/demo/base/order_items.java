package com.ebook.demo.base;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Entity
@Table(name = "order_items")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class order_items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "order_id")
    private String orderId;
    private String book_isbn;
    private double price;
    private int number;
    public order_items(){}
    public order_items(String order_id,String book_isbn,double price,int number){
        this.orderId=order_id;
        this.book_isbn=book_isbn;
        this.price=price;
        this.number=number;
    }
    public order_items(int id,String order_id,String book_isbn,double price,int number){
        this.id=id;
        this.orderId=order_id;
        this.book_isbn=book_isbn;
        this.price=price;
        this.number=number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook_isbn() {
        return book_isbn;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setBook_isbn(String book_isbn) {
        this.book_isbn = book_isbn;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

}
