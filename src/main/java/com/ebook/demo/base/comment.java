package com.ebook.demo.base;

import org.springframework.data.annotation.Id;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class comment {
    @Id
    private String id;
    private String father;
    private String user;
    private String content;
    private Date time;
    private List<comment> children;
    public comment(){};
    public comment(String id, String user, String content, Date time, List<comment> children){
        this.id=id;
        //this.isbn=isbn;
        //this.father=father;
        this.time=time;
        this.user=user;
        this.content=content;
        this.children=children;
    }
    public comment(String id, String father, String user, String content, Date time, List<comment> children){
        this.id=id;
        this.father=father;
        this.time=time;
        this.user=user;
        this.content=content;
        this.children=children;
    }
    public List<comment> getChildren() {
        return children;
    }

    public void setChildren(List<comment> children) {
        this.children = children;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public String getUser() {
        return user;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public Date getTime() {
        return time;
    }

    public void setUser(String user) {
        this.user = user;
    }

   /* public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
*/
    public void setTime(Date time) {
        this.time = time;
    }

}