package com.ebook.demo.base;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
@Entity
@Data
@Table(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class users {
    @Id
    //@GeneratedValue
   // private String id;
    private String name;
    private String password;
    private int type;// 1是管理员，0是普通
    private int state;// 0为禁用，1是正常
    public users(){}
    public users(String name,String password,int type,int state){
        this.name=name;
        this.password=password;
        this.state=state;
        this.type=type;
    }
    /*public users(String id, String name,String password,int type,int state){
        this.id=id;
        this.name=name;
        this.password=password;
        this.state=state;
        this.type=type;
    }*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword(){return password;}
    public void setPassword(String password){this.password=password;}
    public int getType(){return type;}
    public void setType(int t){this.type=t;}
    public int getState(){return state;}
    public void setState(int state){this.state=state;}
}
