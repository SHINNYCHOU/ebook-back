package com.ebook.demo.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.ebook.demo.base.book_info;
import com.ebook.demo.service.bookService;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:8081","null"},allowCredentials = "true")
@RestController
@RequestMapping(value="/book",method = {RequestMethod.GET, RequestMethod.PUT,RequestMethod.DELETE, RequestMethod.POST})
public class BookController {
    @Autowired
    private bookService bookService;

    @GetMapping(value = "/booklist")
    public List<book_info> getBookList(){
        return bookService.findAll();
    }

    @GetMapping(value = "/get/{isbn}")
    public book_info findByIsbn(@PathVariable(value = "isbn") String isbn)
    {
        return bookService.findByIsbn(isbn);
    }

    @PutMapping(value = "/insert/{isbn}")
    public String insertByBook(@PathVariable(value = "isbn") String isbn,
                                    @RequestParam(value = "name") String name,
                                    @RequestParam(value = "author") String author,
                                    @RequestParam(value = "price") Double price,
                                    @RequestParam(value = "store") Integer store,
                                    @RequestParam(value = "cover",required = false) String cover)
    {
        book_info book=new book_info();
        book.setIsbn(isbn);
        book.setName(name);
        book.setAuthor(author);
        book.setPrice(price);
        book.setStore(store);
        book.setCover(cover);
        bookService.insertByBook(book);
        return "修改成功";
    }

    @PutMapping(value = "/update/{isbn}")
    public String update(@PathVariable(value = "isbn") String isbn,@RequestParam(value = "price") Double price,
                         @RequestParam(value = "store") Integer store)
    {
        book_info book=bookService.findByIsbn(isbn);
        book.setPrice(price);
        book.setStore(store);
        bookService.update(book);
        return "更新成功";
    }
    @PutMapping(value = "/changeNumber/{isbn}")
    public String changeNumber(@PathVariable(value = "isbn") String isbn,
                         @RequestParam(value = "store") Integer store)
    {
        book_info book=bookService.findByIsbn(isbn);
        //book.setPrice(price);
        book.setStore(book.getStore()+store);
        bookService.update(book);
        return "更新成功";
    }
    @DeleteMapping(value = "/delete")
    public String deleteStorages(@RequestParam(value = "isbn") String isbn)
    {
        System.out.println(isbn);
        bookService.delete(isbn);
        return "删除成功";
    }
}
