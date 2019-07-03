package com.ebook.demo.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.ebook.demo.service.cartService;
import com.ebook.demo.base.cart;
import com.ebook.demo.Repository.cartRepository;
@CrossOrigin(origins = {"http://localhost:8081","null"},allowCredentials = "true")
@RestController
@RequestMapping(value="/cart",method = {RequestMethod.GET, RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.POST})
@Transactional
public class CartController {
    @Autowired
    private cartService cartService;
    @GetMapping(value = "/list/{uid}")
    public List<cart> getCart(@PathVariable(value = "uid") String uid){
        return cartService.findByName(uid);
    }
    @PostMapping(value = "/insert/")
    public cart insert(@RequestParam(value = "uid") String name,
                       @RequestParam(value = "book") String book,
                       @RequestParam(value = "price") double price,
                       @RequestParam(value = "number") int number){
        if (cartService.findByNameAndBook(name,book)==null){
        cart cart=new cart(name,book,price,number);
        //System.out.println(cart);
        return cartService.insert(cart);}
        else {
            return cartService.findByNameAndBook(name,book);
        }
    }
    @PostMapping(value = "/update")
    public cart update(@RequestParam(value = "name") String name,
                       @RequestParam(value = "book") String book,
                       @RequestParam(value = "number") int number){
        cart c= cartService.findByNameAndBook(name,book);
        c.setNumber(number);
        return cartService.insert(c);
    }
    @DeleteMapping(value = "/delete")
    public cart delete(@RequestParam(value = "name") String name,
                       @RequestParam(value = "book") String book){
        System.out.println(book);
        return cartService.delete(name,book);
    }
}
