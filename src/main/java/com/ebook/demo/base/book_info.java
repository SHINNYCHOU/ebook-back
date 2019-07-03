package com.ebook.demo.base;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name="books")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class book_info {

   // private String id;
    @Id
    private String isbn;
    private String name;
    private String author;
    private String language;
    private Integer store;
    private Double price;
    private String cover;
    //private String descript;
    //private String subject;
    public book_info(){};
    //实现普通用户暂时不需要
    // public book_info(String isbn,String name,String author,String language,Integer store,Double price,String cover){}

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author=author;
    }
    public String getLanguage(){
        return language;
    }
    public void setLanguage(String language){
        this.language=language;
    }
    public Integer getStore(){
        return store;
    }
    public void setStore(Integer store){
        this.store=store;
    }
    public Double getPrice(){
        return price;
    }
    public void setPrice(Double price){
        this.price=price;
    }
    public String getCover(){
        return cover;
    }
    public void setCover(String cover){
        this.cover=cover;
    }

}