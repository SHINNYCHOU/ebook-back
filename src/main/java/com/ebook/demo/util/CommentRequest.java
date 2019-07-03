package com.ebook.demo.util;

public class CommentRequest {
    private String father;
    private String content;
    private String user;
    public CommentRequest(){};
    public CommentRequest(String father,String content,String user){
        this.content=content;
        this.user=user;
        this.father=father;
    }
    public void setFather(String father) {
        this.father = father;
    }

    public String getFather() {
        return father;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
