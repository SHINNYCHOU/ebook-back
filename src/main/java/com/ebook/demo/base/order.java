package com.ebook.demo.base;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;



@Entity
@Data
@Table(name="orders")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class order {
@Id
//@GeneratedValue
    private String id;
    @Column(name = "buyer_id")
    private String buyerId;
    private double price;
    private String state;//1：已提交 2：已完成 3：购物车
    private Timestamp time;
    public order(){}
    public order(String buyer_id,double price,String state,Timestamp time){
        this.buyerId=buyer_id;
        this.price=price;
        this.state=state;
        this.time= time;
    }
    public order(String id,String buyer_id,double price,String state,Timestamp time){
        this.id=id;
        this.buyerId=buyer_id;
        this.price=price;
        this.state=state;
        this.time=time;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public String getState() {
        return state;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public void setState(String state) {
        this.state = state;
    }
}
