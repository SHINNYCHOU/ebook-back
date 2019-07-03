package com.ebook.demo.base;
import org.springframework.data.annotation.Id;
//import javax.persistence.Id;
import java.util.List;

public class bookcomment {
    @Id
    private String isbn;
    private List<comment> comments;

    public bookcomment(){};
    public bookcomment(String isbn){
        this.isbn=isbn;
    };
    public bookcomment(String isbn,List<comment> comments){
        this.isbn=isbn;
        this.comments=comments;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public List<comment> getComments() {
        return comments;
    }

    public void setComments(List<comment> comments) {
        this.comments = comments;
    }
}
