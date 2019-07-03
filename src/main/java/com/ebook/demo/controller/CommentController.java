package com.ebook.demo.controller;

import com.ebook.demo.service.commentServiceImpl;
import com.ebook.demo.base.bookcomment;
import com.ebook.demo.base.comment;
import com.ebook.demo.util.CommentRequest;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:8081","null"},allowCredentials = "true")
@RestController
@RequestMapping(value="/comment",method = {RequestMethod.GET, RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.POST})
@Transactional
public class CommentController {
    @Autowired
    commentServiceImpl commentService;
    @GetMapping(value = "/get/{book_isbn}")
    public bookcomment getComment(@PathVariable(value = "book_isbn") String isbn){
        return commentService.findByIsbn(isbn);
    }
    @PostMapping(value = "/post/{book_id}")
    public comment addComment(@PathVariable(value = "book_id") String isbn,
                              @RequestParam(value = "father") String father,
                              @RequestParam(value = "content") String content,
                              @RequestParam(value = "user") String user){
        //System.out.println(isbn);
        return commentService.saveComment(isbn,father,content,user);
    }
}
