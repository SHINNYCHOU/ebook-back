package com.ebook.demo.service;

import com.ebook.demo.base.bookcomment;
import com.ebook.demo.base.comment;
import com.ebook.demo.Repository.commentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class commentServiceImpl implements commentService{
    @Autowired
    private commentRepository commentRepository;

    public bookcomment findByIsbn(String isbn){
        return commentRepository.findByIsbn(isbn);
    }
    public comment saveComment(String isbn,String fatherId,String content,String user){
        System.out.println("enter s");
        //bookcomment bookcomment=new bookcomment(isbn);
        //直接评论书籍
        System.out.println(isbn);
        if (fatherId.isEmpty()){
            System.out.println("1");
            //如果该book以前有过评论
            if (commentRepository.findByIsbn(isbn)!=null){
                System.out.println("2");
                bookcomment bookcomment=commentRepository.findByIsbn(isbn);
                List<comment> chilren=new ArrayList<>();
                Date t=new Date(System.currentTimeMillis());
                String id= UUID.randomUUID().toString();
                comment comment=new comment(id,fatherId,user,content, t,chilren);
                bookcomment.getComments().add(comment);
                //commentRepository.deleteByIsbn(isbn);
                commentRepository.save(bookcomment);
                return comment;
            }
            //该书以前没评论（新建bookcomment）
            else {
                System.out.println("3");
                System.out.println(isbn);
                List<comment> chilren=new ArrayList<>();
                List<comment> comments=new ArrayList<>();
                Date t=new Date(System.currentTimeMillis());
                String id= UUID.randomUUID().toString();
                comment comment=new comment(id,fatherId,user,content, t,chilren);
                comments.add(comment);
                bookcomment bookcomment=new bookcomment(isbn,comments);
                System.out.println("service receive:");
                System.out.println(bookcomment);
                commentRepository.save(bookcomment);
                return comment;
            }
        }
        //回复评论
        else {
            System.out.println("4");
            if (commentRepository.existsById(isbn)){
                System.out.println("5");
                bookcomment bookcomment=commentRepository.findByIsbn(isbn);
                comment comment=findComment(bookcomment,fatherId);
                List<comment> chilren=new ArrayList<>();
                Date t=new Date(System.currentTimeMillis());
                comment newcomment=new comment(UUID.randomUUID().toString(),comment.getUser(),user,content, t,chilren);
                comment.getChildren().add(newcomment);
                commentRepository.save(bookcomment);
                return newcomment;
            }
            else {
                System.out.println("error 回复");
                return new comment();
            }
        }
    }
    private comment findComment(bookcomment bc,String commentId)
    {
        List<comment> comments = bc.getComments();
        return recursiveFind(comments,commentId);
    }
    private comment recursiveFind(List<comment> comments,String commentId){
        if (comments.isEmpty()){
            return null;
        }
        for (comment c:comments){
            if (c.getId().equals(commentId)){
                return c;
            }
            else {
                comment com = recursiveFind(c.getChildren(),commentId);
                if (com == null){
                    continue;
                }
                return com;
            }
        }
        return null;
    }
}
